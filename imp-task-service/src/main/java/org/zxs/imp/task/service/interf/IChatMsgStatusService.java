package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.UnreadMsgOut;

public interface IChatMsgStatusService {
	
	/**
	 * 根据用户、消息编号，更新消息已读状态、推送状态
	 * @param userId
	 * @param msgId
	 * @return
	 */
	int updateMsgReadStatus(int userId, long msgId);
	
	/**
	 * 根据用户、群聊组编号，更新消息已读状态
	 * @param userId
	 * @param cgId
	 * @return
	 */
	int updateMsgReadStatusByUserIdAndCgId(int userId, int cgId);
	
	/**
	 * 查询用户未读消息总数，不包括系统消息
	 * @param userId
	 * @return
	 */
	int getTotalUnreadMsgCnt(int userId);

	/**
	 * 获取未推送系统消息列表，按时间降序排列
	 * @param userId
	 * @return
	 */
	List<String> getUnpushSysMsg(int userId);

	/**
	 * 获取未推送聊天消息数
	 * @param userId
	 * @return
	 */
	int getUnpushChatCnt(int userId);

	/**
	 * 更新所有推送消息的状态为已推送，包括系统通知、聊天消息、随手拍
	 * @param userId
	 */
	int updateAllPushStatus(int userId);

	/**
	 * 获取用户未读消息信息
	 * @param userId
	 * @return
	 */
	UnreadMsgOut getUnreadMsgCnt(int userId);
}
