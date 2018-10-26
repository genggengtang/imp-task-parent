package org.zxs.imp.task.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.IChatGroupMsgMapper;
import org.zxs.imp.task.dao.interf.IChatMsgStatusMapper;
import org.zxs.imp.task.dao.model.ChatMsgStatus;
import org.zxs.imp.task.dao.model.ChatMsgStatusExample;
import org.zxs.imp.task.dao.model.ChatMsgStatusExample.Criteria;
import org.zxs.imp.task.dao.model.vo.output.UnreadMsgOut;
import org.zxs.imp.task.service.interf.IChatMsgStatusService;


@Service
public class ChatMsgStatusServiceImpl implements IChatMsgStatusService {
	private static Logger log = LoggerFactory.getLogger(ChatMsgStatusServiceImpl.class);

	@Resource
	private IChatMsgStatusMapper msgStatusMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;
	

	@Override
	@Transactional
	public int updateMsgReadStatus(int userId, long msgId) {
		ChatMsgStatus mStatus = new ChatMsgStatus();
		mStatus.setChatMsgId(msgId);
		mStatus.setUserId(userId);
		mStatus.setReadStatus(ChatMsgStatus.STATUS_UNREAD);
		
		ChatMsgStatus uMsgStatus = msgStatusMapper.selectOne(mStatus);
		
		if(null != uMsgStatus) {
			uMsgStatus.setUpdateAt(new Date());
			uMsgStatus.setReadStatus(ChatMsgStatus.STATUS_READ);
			return msgStatusMapper.updateByPrimaryKeySelective(uMsgStatus);
		}
		return 0;
		
	}

	@Override
	@Transactional
	public int updateMsgReadStatusByUserIdAndCgId(int userId, int cgId) {
		return msgStatusMapper.updateByCgIdAndUserId(cgId, userId);
	}

	@Override
	public int getTotalUnreadMsgCnt(int userId) {
		ChatMsgStatusExample example = new ChatMsgStatusExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andReadStatusEqualTo(ChatMsgStatus.STATUS_UNREAD);
		return msgStatusMapper.selectCountByExample(example);
	}

	@Override
	public List<String> getUnpushSysMsg(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUnpushChatCnt(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAllPushStatus(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UnreadMsgOut getUnreadMsgCnt(int userId) {
		log.info("获取用户{}未读消息！", userId);
		UnreadMsgOut unreadRet = new UnreadMsgOut();
		unreadRet.setUserId(userId);
		int totalUnread = getTotalUnreadMsgCnt(userId);
		log.info("用户{}未读消息总数为{}", userId, totalUnread);
		unreadRet.setTotalUnreadNum(totalUnread);
		
		unreadRet.setUnreadList(msgStatusMapper.selectUnreadCountByRoom(userId));
		return unreadRet;
	}


}
