package org.zxs.imp.task.dao.model.vo.query;

import java.util.List;

import org.zxs.imp.task.dao.model.ChatGroupInfo;

public class ChatGroupQuery extends ChatGroupInfo{
	private Integer createId;
	private List<Integer> userList;
	
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public List<Integer> getUserList() {
		return userList;
	}
	public void setUserList(List<Integer> userList) {
		this.userList = userList;
	}
	
}
