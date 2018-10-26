package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

import org.zxs.imp.task.dao.model.TaskView;

public class TaskDetailOut extends TaskView{
	private String[] aheadDeptArray;
	
	private String[] parternDeptArray;
	
	private List<UserCommentOut> leaderCommentList;
	
	private List<UserCommentOut> finalCommentList;
	
	private List<FileSimpleOut> fileBaseList;
	
	private List<FileSimpleOut> attachmentList;
	
	private List<PeriodTaskOut> periodList;

	public String[] getAheadDeptArray() {
		return aheadDeptArray;
	}

	public void setAheadDeptArray(String[] aheadDeptArray) {
		this.aheadDeptArray = aheadDeptArray;
		String aheadDepts = this.getAheadDepts();
		if(null != aheadDepts && !aheadDepts.isEmpty()) {
			this.aheadDeptArray = aheadDepts.split(",");
		}
	}

	public String[] getParternDeptArray() {
		return parternDeptArray;
	}

	public void setParternDeptArray(String[] parternDeptArray) {
		this.parternDeptArray = parternDeptArray;
		String parternDepts = this.getParternDepts();
		if(null != parternDepts && !parternDepts.isEmpty()) {
			this.parternDeptArray = parternDepts.split(",");
		}
	}

	public List<UserCommentOut> getLeaderCommentList() {
		return leaderCommentList;
	}

	public void setLeaderCommentList(List<UserCommentOut> leaderCommentList) {
		this.leaderCommentList = leaderCommentList;
	}

	public List<UserCommentOut> getFinalCommentList() {
		return finalCommentList;
	}

	public void setFinalCommentList(List<UserCommentOut> finalCommentList) {
		this.finalCommentList = finalCommentList;
	}

	public List<FileSimpleOut> getFileBaseList() {
		return fileBaseList;
	}

	public void setFileBaseList(List<FileSimpleOut> fileBaseList) {
		this.fileBaseList = fileBaseList;
	}

	public List<FileSimpleOut> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<FileSimpleOut> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<PeriodTaskOut> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<PeriodTaskOut> periodList) {
		this.periodList = periodList;
	}
	
}
