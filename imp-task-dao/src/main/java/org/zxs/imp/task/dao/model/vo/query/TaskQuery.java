package org.zxs.imp.task.dao.model.vo.query;

import java.util.List;

import org.zxs.base.model.PageQueryBase;

public class TaskQuery extends PageQueryBase{
	private Integer type;
	private List<Integer> labelArray;
	private List<Integer> deptArray;
	private List<Integer> leaderArray;
	private String startDateStr;
	private String endDateStr;
	private Integer status;
	private List<Integer> statusArray;
	private Integer deptId;
	private Integer userId;
	private Integer isFavorite;
	private String keyword;
	private List<Integer> userDeptList;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<Integer> getDeptArray() {
		return deptArray;
	}
	public void setDeptArray(List<Integer> deptArray) {
		this.deptArray = deptArray;
	}
	public List<Integer> getLeaderArray() {
		return leaderArray;
	}
	public void setLeaderArray(List<Integer> leaderArray) {
		this.leaderArray = leaderArray;
	}
	public List<Integer> getLabelArray() {
		return labelArray;
	}
	public void setLabelArray(List<Integer> labelArray) {
		this.labelArray = labelArray;
	}
	public List<Integer> getStatusArray() {
		return statusArray;
	}
	public void setStatusArray(List<Integer> statusArray) {
		this.statusArray = statusArray;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Integer> getUserDeptList() {
		return userDeptList;
	}
	public void setUserDeptList(List<Integer> userDeptList) {
		this.userDeptList = userDeptList;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Integer isFavorite) {
		this.isFavorite = isFavorite;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
