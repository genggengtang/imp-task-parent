package org.zxs.imp.task.dao.model.oa;

import java.util.ArrayList;
import java.util.List;

public class OAReturnSingleList<T> {
	private Boolean returnStatus;
	private String description;
	private Integer totalNumCount;
	List<T> dataList = new ArrayList<>();

	public Boolean getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Boolean returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalNumCount() {
		return totalNumCount;
	}

	public void setTotalNumCount(Integer totalNumCount) {
		this.totalNumCount = totalNumCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void addData(T data) {
		dataList.add(data);
	}
}
