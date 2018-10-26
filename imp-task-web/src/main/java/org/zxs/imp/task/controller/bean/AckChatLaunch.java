package org.zxs.imp.task.controller.bean;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.ChatGroupMsg;
import org.zxs.imp.task.dao.model.vo.output.ChatMsgOut;
import org.zxs.imp.task.dao.model.vo.output.UnreadMsgOut;
import org.zxs.imp.task.service.interf.IChatGroupInfoService;
import org.zxs.imp.task.service.interf.IChatGroupMsgService;
import org.zxs.imp.task.service.interf.IChatGroupUserService;
import org.zxs.imp.task.service.interf.IChatMsgStatusService;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.BroadcastAckCallback;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

/**
 * 启动socketio server
 * @author Administrator
 *
 */
@Component
public class AckChatLaunch implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AckChatLaunch.class);
	private static final String ROOM_NOTIFY = "/notify";
	
	private Map<SocketIOClient, Integer> unreadMap = new HashMap<>();
//	private Map<SocketIOClient, Integer> unpushMap = new HashMap<>();
	private Map<UUID, Integer> clientUserMap = new HashMap<>();

	@Resource
	private SocketIOServer server;
	
	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IChatGroupMsgService cgMsgService;
	
	@Resource
	private IChatMsgStatusService msgStatusService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		if (evt.getApplicationContext().getParent() != null) {
			LOGGER.info("SocketIOServer服务启动!");
//			unreadMap.clear();
			server.start();
			
			List<ChatGroupInfo> cgList = cgInfoService.getAllChatGroup();
			// 为每一个聊天群开启监听
			if(null != cgList && !cgList.isEmpty()) {
				LOGGER.info("需要添加的聊天室监听数为：" + cgList.size());
				for(ChatGroupInfo cgInfo : cgList) {
					addMsgEventListener(cgInfo.getId());
				}
			}
			
			if(server.getNamespace(ROOM_NOTIFY) == null) { // 聊天室未被监听
				final SocketIONamespace unreadRoomNamespace = server.addNamespace(ROOM_NOTIFY);
				unreadRoomNamespace.addJsonObjectListener(UnreadMsgOut.class, new DataListener<UnreadMsgOut>() {
		        	@Override
		            public void onData(SocketIOClient client, UnreadMsgOut data, AckRequest ackRequest) {
		        		if(client.isChannelOpen()) {
		            		UUID currentSessionId = client.getSessionId();
		            		if(data != null) {
			    				Integer userId = data.getUserId();
			    				if(null != userId) {
			    					LOGGER.info("添加服务器端未读消息监听！sessionId为：{},userId为：{}", currentSessionId, userId);
			    					unreadMap.put(client, userId);
			    					notifyUnreadMsg(client, userId);
			    				}else{
			            			LOGGER.warn("客户端未发送用户信息！");
			            		}
								
		            		}else {
		            			LOGGER.warn("客户端发送的数据信息为空！");
		            		}
		                	
		            	}else {
		            		LOGGER.warn("客户端消息渠道未打开！");
		            	}
		            }
		        });
			}
			
			server.addDisconnectListener(new DisconnectListener(){

				@Override
				public void onDisconnect(SocketIOClient client) {
					UUID sessionId = client.getSessionId();
					Integer userId = clientUserMap.get(sessionId);
					if(null != userId) {
						LOGGER.info("客户端{}断开socket连接，用户{}", sessionId, userId);
						clientUserMap.remove(sessionId);
					}
					
				}
				
			});
		}
	}
	
	/**
	 * 为每个聊天室添加消息事件监听
	 * @param cgInfo
	 */
	public void addMsgEventListener(int roomId) {
		String chatRoom = "/" + roomId;
		if(server.getNamespace(chatRoom) == null) { // 聊天室未被监听
			SocketIONamespace chatRoomNamespace = server.addNamespace(chatRoom);
	        chatRoomNamespace.addJsonObjectListener(ChatMsgOut.class, new DataListener<ChatMsgOut>() { 
	            @Override
	            public void onData(SocketIOClient client, ChatMsgOut data, AckRequest ackRequest) {
	            	if (null != ackRequest && ackRequest.isAckRequested()) {
	                    // send ack response with data to client
	                    ackRequest.sendAckData("client message was delivered to server!", "yeah!");
	                }
	            	
	            	UUID clientUuid = client.getSessionId();
	            	
	            	if(null != data) {
	            		Integer sendId = data.getUserId();
						
						clientUserMap.put(clientUuid, sendId);
		            	
						try {
							// 保存到数据库中
							ChatMsgOut saveMsgOut = cgMsgService.saveChatMsg(data, roomId);
							
							if(null != saveMsgOut) {
								LOGGER.info("聊天记录保存成功!" + JSON.toJSONString(data));
							}
							// saveMsgOut.setShMsgType(ChatGroupMsg.TYPE_MSSAGE);
							Set<UUID> uuidSet = new HashSet<>();
							
							for(SocketIOClient receiver : chatRoomNamespace.getAllClients()) {
								UUID rUuid = receiver.getSessionId();
								if(!uuidSet.contains(rUuid)) { // 判断客户端是否处理过
									uuidSet.add(rUuid);
									
									Integer receiveId = clientUserMap.get(rUuid);
									if(rUuid.equals(clientUuid)) {
										saveMsgOut.setIsSelf(1);
									}else {
										saveMsgOut.setIsSelf(0);
									}
									
									receiver.sendJsonObject(saveMsgOut, new AckCallback<String>(String.class) {
										@Override
					                    public void onSuccess(String result) {
											LOGGER.info("客户端{},返回{}", rUuid, result);
											if(null != receiveId) {
												msgStatusService.updateMsgReadStatus(receiveId, saveMsgOut.getMsgId());
												for(Map.Entry<SocketIOClient,Integer> sClientEntry : unreadMap.entrySet()) {
													Integer sClientUserId = sClientEntry.getValue();
													if(sClientUserId.equals(receiveId)) {
														notifyUnreadMsg(sClientEntry.getKey(), receiveId);
													}
												}
												
											}
					                    }
									});
								}
								
								
							}
						} catch (IOException e) {
							LOGGER.error(e.getMessage(), e);
						}
	            	} else {
	            		LOGGER.info("客户端{}传了空数据到服务器！", clientUuid);
	            	}
					
	            }
	        });
		}

	}
	
	/**
	 * 服务器通知聊天室所有在线客户端
	 * @param roomId 聊天室编号
	 */
	public void notifyAllRoomClientsWithData(Integer roomId, ChatMsgOut data) {
		final SocketIONamespace chatRoomNamespace = server.getNamespace("/" + roomId);
		
		for(SocketIOClient receiver : chatRoomNamespace.getAllClients()) {
			UUID rUuid = receiver.getSessionId();
			Integer receiveId = clientUserMap.get(rUuid);
			
			String rmUsers = "";
			data.setIsSelf(0);
			if(ChatGroupMsg.TYPE_REMOVE_MEMBER == data.getShMsgType()) { // 移除用户
				rmUsers = data.getsUserIds();
				if(null != receiveId && rmUsers.contains(receiveId+"")) {
					data.setIsSelf(1);
				}
			}
			
			receiver.sendJsonObject(data, new AckCallback<String>(String.class) {
				
				@Override
				public void onSuccess(String result) {
					LOGGER.info("客户端{}成功收到未读消息通知！结果为{}", rUuid, result);
					if(null != receiveId) {
						msgStatusService.updateMsgReadStatus(receiveId, data.getMsgId());
						for(Map.Entry<SocketIOClient,Integer> sClientEntry : unreadMap.entrySet()) {
							Integer sClientUserId = sClientEntry.getValue();
							if(sClientUserId.equals(receiveId)) {
								notifyUnreadMsg(sClientEntry.getKey(), receiveId);
							}
						}
					}
				}
			
			});
			
		}
	}
	
	/**
	 * 通知单个客户端有新的未读消息
	 * @param cgInfo
	 */
	private void notifyUnreadMsg(SocketIOClient client, int userId) {
		LOGGER.info("通知用户{}未读聊天消息！", userId);
		// 查询聊天未读消息
    	UnreadMsgOut unreadMsg = msgStatusService.getUnreadMsgCnt(userId);
    	
		client.sendJsonObject(unreadMsg, new AckCallback<String>(String.class) {

			@Override
			public void onSuccess(String result) {
				LOGGER.info("客户端{}成功收到未读消息通知！结果为：{}", client.getSessionId(), result);
			}
			
		});
	}
	
	
}
