package org.zxs.imp.task.dao.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CardTaskView extends CardInfo{
	
	private String aheadDepts;
	private String aheadDeptIds;
	private String parternDepts;
	private String parternDeptIds;
	private String pubLabelIds;
	private String pubLabels; // 公共标签
	private String creatorName;
	private String creatorDeptName;
	private String endName;
	private String endDeptName;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;


	public String getAheadDepts() {
		return aheadDepts;
	}

	public void setAheadDepts(String aheadDepts) {
		this.aheadDepts = aheadDepts;
	}

	public String getParternDepts() {
		return parternDepts;
	}

	public void setParternDepts(String parternDepts) {
		this.parternDepts = parternDepts;
	}

	public String getAheadDeptIds() {
		return aheadDeptIds;
	}

	public void setAheadDeptIds(String aheadDeptIds) {
		this.aheadDeptIds = aheadDeptIds;
	}

	public String getParternDeptIds() {
		return parternDeptIds;
	}

	public void setParternDeptIds(String parternDeptIds) {
		this.parternDeptIds = parternDeptIds;
	}

	public String getPubLabelIds() {
		return pubLabelIds;
	}

	public void setPubLabelIds(String pubLabelIds) {
		this.pubLabelIds = pubLabelIds;
	}

	public String getPubLabels() {
		return pubLabels;
	}

	public void setPubLabels(String pubLabels) {
		this.pubLabels = pubLabels;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorDeptName() {
		return creatorDeptName;
	}

	public void setCreatorDeptName(String creatorDeptName) {
		this.creatorDeptName = creatorDeptName;
	}

	public String getEndName() {
		return endName;
	}

	public void setEndName(String endName) {
		this.endName = endName;
	}

	public String getEndDeptName() {
		return endDeptName;
	}

	public void setEndDeptName(String endDeptName) {
		this.endDeptName = endDeptName;
	}
	
}
