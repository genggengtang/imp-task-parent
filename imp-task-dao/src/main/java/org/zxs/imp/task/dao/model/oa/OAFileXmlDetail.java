package org.zxs.imp.task.dao.model.oa;

/**
 * OA系统收文信息
 * @author Administrator
 *
 */
public class OAFileXmlDetail {
	private String approval;
	private String checkRead;
	private String txtFileDate;
	private String oldXianBanDate;
	private String guid;
	
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getCheckRead() {
		return checkRead;
	}
	public void setCheckRead(String checkRead) {
		this.checkRead = checkRead;
	}
	public String getTxtFileDate() {
		return txtFileDate;
	}
	public void setTxtFileDate(String txtFileDate) {
		this.txtFileDate = txtFileDate;
	}
	public String getOldXianBanDate() {
		return oldXianBanDate;
	}
	public void setOldXianBanDate(String oldXianBanDate) {
		this.oldXianBanDate = oldXianBanDate;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
}
