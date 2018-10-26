package org.zxs.imp.task.dao.model.vo.query;

import java.util.List;

/**
 * 通讯录查询对象
 * @author Administrator
 *
 */
public class PhoneListQuery{
	private Integer userId;
	private Integer roomId;
	private Integer isUserIn;
	private Integer userLevel;
	private String nameLike;
	private List<Integer> userSelected;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getIsUserIn() {
		return isUserIn;
	}
	public void setIsUserIn(Integer isUserIn) {
		this.isUserIn = isUserIn;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	public List<Integer> getUserSelected() {
		return userSelected;
	}
	public void setUserSelected(List<Integer> userSelected) {
		this.userSelected = userSelected;
	}
	
}
