package org.zxs.imp.task.dao.model.vo.query;

/**
 * 聊天消息查询对象
 * @author Administrator
 *
 */
public class MsgHisQuery{
	private Integer id;
	private Long msgId;
	private Integer userId;
	private Integer num = 15; // 每次最大查询总数
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
