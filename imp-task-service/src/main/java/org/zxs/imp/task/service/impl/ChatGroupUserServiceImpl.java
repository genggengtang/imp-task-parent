package org.zxs.imp.task.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.IChatGroupMsgMapper;
import org.zxs.imp.task.dao.interf.IChatGroupUserMapper;
import org.zxs.imp.task.dao.interf.IChatMsgStatusMapper;
import org.zxs.imp.task.dao.model.ChatMsgStatus;
import org.zxs.imp.task.dao.model.ChatMsgStatusExample;
import org.zxs.imp.task.dao.model.ChatMsgStatusExample.Criteria;
import org.zxs.imp.task.service.interf.IChatGroupUserService;
import org.zxs.imp.task.service.interf.IChatMsgStatusService;


@Service
public class ChatGroupUserServiceImpl implements IChatGroupUserService {
	private static Log log = LogFactory.getLog(IChatGroupUserService.class);
	
	@Resource
	private IChatGroupUserMapper cgUserMapper;

	@Resource
	private IChatMsgStatusMapper msgStatusMapper;
	
	@Resource
	private IChatGroupMsgMapper cgMsgMapper;

	@Override
	public boolean isUserInGroup(int userId, int cgId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserGroupOwner(int userId, int cgId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGroupAdmin(int userId, int cgId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Integer> getUserByCgId(int cgId, Integer selfId) {
		return cgUserMapper.selectUserIdByCgId(cgId, selfId);
	}
	

	

}
