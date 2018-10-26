package org.zxs.imp.task.dao.model.vo.query;

import java.util.List;

import org.zxs.base.model.PageQueryBase;

public class MyLabelQuery extends PageQueryBase{
	private Integer userId;
	private String keyword;
	private List<Long> excludeIds;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Long> getExcludeIds() {
		return excludeIds;
	}
	public void setExcludeIds(List<Long> excludeIds) {
		this.excludeIds = excludeIds;
	}
	
}
