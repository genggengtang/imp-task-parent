package org.zxs.imp.task.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.IChatGroupMsgMapper;
import org.zxs.imp.task.dao.interf.IChatGroupUserMapper;
import org.zxs.imp.task.dao.interf.IChatMsgStatusMapper;
import org.zxs.imp.task.dao.model.ChatGroupMsg;
import org.zxs.imp.task.dao.model.ChatGroupUser;
import org.zxs.imp.task.dao.model.ChatGroupUserExample;
import org.zxs.imp.task.dao.model.ChatGroupUserExample.Criteria;
import org.zxs.imp.task.dao.model.ChatMsgStatus;
import org.zxs.imp.task.dao.model.vo.output.ChatMsgOut;
import org.zxs.imp.task.dao.model.vo.query.MsgHisQuery;
import org.zxs.imp.task.service.interf.IChatGroupMsgService;
import org.zxs.utils.CommonUtil;
import com.qiniu.common.QiniuException;

@Service
public class ChatGroupMsgServiceImpl implements IChatGroupMsgService {

	@Resource
	private IChatGroupUserMapper cgUserMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;
	
	@Resource
	private IChatMsgStatusMapper msgStatusMapper;

	@Override
	@Transactional
	public ChatMsgOut saveChatMsg(ChatMsgOut data, Integer chatRoom) throws QiniuException, IOException {
		int submitMsgType = data.getShMsgType();
		ChatGroupMsg msg = new ChatGroupMsg();
		msg.setChatGroupId(chatRoom);
		msg.setFromId(data.getUserId());
		msg.setFromName(data.getUserName());
		
		if(submitMsgType == ChatGroupMsg.TYPE_PIC || submitMsgType == ChatGroupMsg.TYPE_DOC) { // 图片或文件消息
			msg.setChatType(submitMsgType);
			String fileName = data.getFileName();
			
			msg.setFileName(fileName);
			msg.setFileUrl(data.getFileUrl());
		} else {
			msg.setContent(data.getMsgContent());
			msg.setChatType(ChatGroupMsg.TYPE_MSSAGE);
			
			data.setShMsgType(ChatGroupMsg.TYPE_MSSAGE);
		}
		
		Date nowtime = new Date();
		msg.setCreateAt(nowtime);
		
		int iSaveRet = cgMsgMapper.insert(msg);
		if(iSaveRet == 1) { // 消息记录插入成功,添加消息阅读状态记录
			// 获取该群组所有成员，除本人
			Long msgId = msg.getId();
			ChatGroupUserExample userExp = new ChatGroupUserExample();
			Criteria userCriteria = userExp.createCriteria();
			userCriteria.andChatGroupIdEqualTo(chatRoom);
//			userCriteria.andUserIdNotEqualTo(data.getUserId());
			List<ChatGroupUser> userList = cgUserMapper.selectByExample(userExp);
			if(!userList.isEmpty()) {
				for(ChatGroupUser rcvUser : userList) {
					ChatMsgStatus mStatus = new ChatMsgStatus();
					mStatus.setChatMsgId(msgId);
//					mStatus.setReadStatus(ChatMsgStatus.STATUS_UNREAD);
//					mStatus.setPushStatus(ChatMsgStatus.STATUS_UNPUSH);
					mStatus.setUserId(rcvUser.getUserId());
					mStatus.setCreateAt(nowtime);
					mStatus.setUpdateAt(nowtime);
					int msgStatusRet = msgStatusMapper.insert(mStatus);
					if(msgStatusRet != 1) {
						// TODO 插入失败
					}
				}
			}
			data.setMsgId(msgId);
			data.setMsgAt(nowtime);
			return data;
		}
		
		return null;
	}

	@Override
	public List<ChatMsgOut> getLatestMsgHisById(MsgHisQuery query) {
		return cgMsgMapper.selectLatestMsgHis(query);
	}

	@Override
	public int saveSYSMsg(String sysMsg) {
		// TODO Auto-generated method stub
		return 0;
	}

}
