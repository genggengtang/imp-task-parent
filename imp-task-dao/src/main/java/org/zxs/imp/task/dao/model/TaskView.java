package org.zxs.imp.task.dao.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskView extends TaskInfo{
	private String taskLabels;
	private Integer status;
	private String statusDis;
	private String draftComment;
	private String finalComment;
	private String prcComment;
	private Date subCreateAt;
	private Date subUpdateAt;
	private String taskDepts;
	private String aheadDepts;
	private String parternDepts;
	private Integer dayRest;
	private String kpi1stName;
	private String kpi2ndName;
	private String kpi3rdName;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date alertDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String finishDate;
	
	public String getTaskLabels() {
		return taskLabels;
	}
	public void setTaskLabels(String taskLabels) {
		this.taskLabels = taskLabels;
	}
	public Date getAlertDate() {
		return alertDate;
	}
	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusDis() {
		return statusDis;
	}
	public void setStatusDis(String statusDis) {
		this.statusDis = statusDis;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getDraftComment() {
		return draftComment;
	}
	public void setDraftComment(String draftComment) {
		this.draftComment = draftComment;
	}
	public String getFinalComment() {
		return finalComment;
	}
	public void setFinalComment(String finalComment) {
		this.finalComment = finalComment;
	}
	public String getPrcComment() {
		return prcComment;
	}
	public void setPrcComment(String prcComment) {
		this.prcComment = prcComment;
	}
	public Date getSubCreateAt() {
		return subCreateAt;
	}
	public void setSubCreateAt(Date subCreateAt) {
		this.subCreateAt = subCreateAt;
	}
	public Date getSubUpdateAt() {
		return subUpdateAt;
	}
	public void setSubUpdateAt(Date subUpdateAt) {
		this.subUpdateAt = subUpdateAt;
	}
	public String getTaskDepts() {
		return taskDepts;
	}
	public void setTaskDepts(String taskDepts) {
		this.taskDepts = taskDepts;
	}
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
	public Integer getDayRest() {
		return dayRest;
	}
	public void setDayRest(Integer dayRest) {
		this.dayRest = dayRest;
	}
	public String getKpi1stName() {
		return kpi1stName;
	}
	public void setKpi1stName(String kpi1stName) {
		this.kpi1stName = kpi1stName == null ? "无":kpi1stName;
	}
	public String getKpi2ndName() {
		return kpi2ndName;
	}
	public void setKpi2ndName(String kpi2ndName) {
		this.kpi2ndName = kpi2ndName == null ? "无":kpi2ndName;
	}
	public String getKpi3rdName() {
		return kpi3rdName;
	}
	public void setKpi3rdName(String kpi3rdName) {
		this.kpi3rdName = kpi3rdName == null ? "无":kpi3rdName;
	}
	
}
