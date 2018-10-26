package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.UserComment;
import org.zxs.imp.task.dao.model.vo.output.UserCommentOut;

import tk.mybatis.mapper.common.Mapper;

public interface IUserCommentMapper extends Mapper<UserComment>{

	/**
	 * 根据子任务编号获取领导评论
	 * @param subId
	 * @return
	 */
	List<UserCommentOut> selectLeaderCommentsBySubId(long subId);

	/**
	 * 根据子任务编号获取最终结论列表
	 * @param subId
	 * @return
	 */
	List<UserCommentOut> selectFinalCommentsBySubId(long subId);
}