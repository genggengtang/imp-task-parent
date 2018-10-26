package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

/**
 * 未读消息对象
 * @author Administrator
 *
 */
public class UnreadMsgOut {
	private Integer userId; // 用户编号
	private Integer totalUnreadNum; // 所有未读消息总数
	private List<ChatGroupSimpleOut> unreadList; // 群聊组未读消息集合
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTotalUnreadNum() {
		return totalUnreadNum;
	}
	public void setTotalUnreadNum(Integer totalUnreadNum) {
		this.totalUnreadNum = totalUnreadNum;
	}
	public List<ChatGroupSimpleOut> getUnreadList() {
		return unreadList;
	}
	public void setUnreadList(List<ChatGroupSimpleOut> unreadList) {
		this.unreadList = unreadList;
	}
	
}
