package org.zxs.imp.task.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.IChatGroupInfoMapper;
import org.zxs.imp.task.dao.interf.IChatGroupUserMapper;
import org.zxs.imp.task.dao.interf.IUserInfoMapper;
import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.ChatGroupUser;
import org.zxs.imp.task.dao.model.UserInfo;
import org.zxs.imp.task.dao.model.vo.query.ChatGroupQuery;
import org.zxs.imp.task.service.interf.IChatGroupInfoService;


@Service
public class ChatGroupInfoServiceImpl implements IChatGroupInfoService {
	private static final Logger log = LoggerFactory.getLogger(IChatGroupInfoService.class);

	@Resource
	private IChatGroupInfoMapper cgInfoMapper;

	@Resource
	private IChatGroupUserMapper cgUserMapper;
	
	@Resource
	private IUserInfoMapper userMapper;

	@Override
	public List<ChatGroupInfo> getAllChatGroup() {
		ChatGroupInfo cgInfo = new ChatGroupInfo();
		cgInfo.setIsDeleted(false);
		return cgInfoMapper.select(cgInfo);
	}

	@Override
	public ChatGroupInfo createChatRoom(ChatGroupQuery query) {
		String groupName = query.getGroupName();
		int createId = query.getCreateId();
		byte type = query.getType();
		Date nowtime = new Date();
		
		List<Integer> userList = new ArrayList<>();
		userList.add(createId);
		List<Integer> uList = query.getUserList();
		userList.addAll(uList);
		
		ChatGroupInfo cgInfo = null;
		
		// TODO 判断是否已存在相应聊天群组
		List<Integer> userQueryList = new ArrayList<>();
		if(type == ChatGroupInfo.CHAT_DOUBLE_DIALOG) {
			userQueryList.add(createId);
			userQueryList.add(uList.get(0));
			Collections.sort(userQueryList); // 重排序
			cgInfo = cgInfoMapper.selectIfGroupExist(null, StringUtils.join(userQueryList, ','));
		}else {
			userQueryList.addAll(uList);
			Collections.sort(userQueryList); // 重排序
			cgInfo = cgInfoMapper.selectIfGroupExist(createId, StringUtils.join(userQueryList, ','));
		}
		
		if(cgInfo == null) { // 群组不存在
			cgInfo = new ChatGroupInfo();
			
			if (null == groupName || groupName.isEmpty()) {
				groupName = userMapper.selectNameInRow(userList);
			}

			 if(groupName.length() > 50) {
				 cgInfo.setGroupName(groupName.substring(0, 50) + "...");
			 }else {
				 cgInfo.setGroupName(groupName);
			 }
			 
			 cgInfo.setEnableNameUpdate((byte) 1); // 允许修改群名
			 cgInfo.setEnableRemove((byte)1);
			 
			 if(type == ChatGroupInfo.CHAT_DOUBLE_DIALOG)
				 cgInfo.setEnableRemove((byte)0);
			 cgInfo.setType(type);
			 cgInfo.setCreateAt(nowtime);
			 cgInfo.setUpdateAt(nowtime);
			 cgInfo.setIsDeleted(false);
			 
			// 保存群组
			int cgInfoSaveRet = cgInfoMapper.insert(cgInfo);

			if (cgInfoSaveRet == 1) {
				Integer cgId = cgInfo.getId();
				
				if(type == ChatGroupInfo.CHAT_DOUBLE_DIALOG) {
					saveCgUser(createId, cgId, ChatGroupUser.ROLE_ADMIN);
					saveCgUser(uList.get(0), cgId, ChatGroupUser.ROLE_ADMIN);
				}else {
					// 创建者
					int creatorSaveRet = saveCgUser(createId, cgId, ChatGroupUser.ROLE_OWNER);

					if (creatorSaveRet == 1) { // 保存成功
						// 组员
						if (null != uList && uList.size() > 0) {
							for (Integer userId : uList) {
								int memberSaveRet = saveCgUser(userId, cgId, ChatGroupUser.ROLE_MEMBER);
								if (memberSaveRet != 1) {// 保存失败
									log.error("添加聊天组成员[" + userId + "]失败！");
									return null;
								}
							}
						}
					}
				}
				
				return cgInfo;
			}
			log.warn("新增聊天群组记录失败！");
			return null;
		}

		return cgInfo;
	}

	@Transactional
	private int saveCgUser(int userId, Integer cgId, byte roleOwner) {
		UserInfo createUser = userMapper.selectByPrimaryKey(userId);

		ChatGroupUser creator = new ChatGroupUser();
		creator.setChatGroupId(cgId);
		creator.setUserId(userId);
		creator.setNickname(createUser.getRealName());
		creator.setRole(roleOwner);
		
		if(roleOwner < ChatGroupUser.ROLE_MEMBER)
			creator.setRemoveable(ChatGroupUser.REMOVE_REJECT);

		return cgUserMapper.insert(creator);
	}

	@Override
	public int deleteChatGroupById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCgName(int id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
