package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.UserCommentOut;

public interface IUserCommentService {
	/**
	 * 根据子任务编号获取领导批示集合
	 * @param subId
	 * @return
	 */
	List<UserCommentOut> getLeaderComments(long subId);
	
	/**
	 * 根据子任务编号获取科室结论集合
	 * @param subId
	 * @return
	 */
	List<UserCommentOut> getFinalComments(long subId);
}
