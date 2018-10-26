package org.zxs.imp.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.interf.IUserCommentMapper;
import org.zxs.imp.task.dao.model.vo.output.UserCommentOut;
import org.zxs.imp.task.service.interf.IUserCommentService;


@Service
public class UserCommentServiceImpl implements IUserCommentService {

	@Resource
	private IUserCommentMapper commentMapper;

	@Override
	public List<UserCommentOut> getLeaderComments(long subId) {
		return commentMapper.selectLeaderCommentsBySubId(subId);
	}

	@Override
	public List<UserCommentOut> getFinalComments(long subId) {
		return commentMapper.selectFinalCommentsBySubId(subId);
	}

	
}
