package org.zxs.imp.task.dao.model.oa;

import java.util.ArrayList;
import java.util.List;

import org.zxs.imp.task.dao.model.CardAttachment;
import org.zxs.imp.task.dao.model.OaFileAttachment;

public class OAReturnFileDetailList extends OAReturnBase<OAFileXmlDetail> {
	private List<OAFileHandleDetail> handleList = new ArrayList<>();
	private List<OaFileAttachment> attachList = new ArrayList<>();
	
	public List<OAFileHandleDetail> getHandleList() {
		return handleList;
	}
	public void setHandleList(List<OAFileHandleDetail> handleList) {
		this.handleList = handleList;
	}
	public List<OaFileAttachment> getAttachList() {
		return attachList;
	}
	public void setAttachList(List<OaFileAttachment> attachList) {
		this.attachList = attachList;
	}
	
	public void addHandleDetail(OAFileHandleDetail handleDetail) {
		handleList.add(handleDetail);
	}
	
	public void addAttachDetail(OaFileAttachment attachDetail) {
		attachList.add(attachDetail);
	}
	
}
