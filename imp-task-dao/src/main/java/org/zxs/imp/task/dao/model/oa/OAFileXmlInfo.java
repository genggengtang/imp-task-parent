package org.zxs.imp.task.dao.model.oa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OA系统收文信息
 * @author Administrator
 *
 */
public class OAFileXmlInfo {
	private String txtTitle;
	private String fileType;
	private String txtLaiWenHao;
	private String txtLaiWenDept;
	private String txtFileDate;
	private String txtShouWenDate;
	private String processVersionInstanceGuid;
	private String lastAt;
	private String xianbanDate;
	private String oldXianbanDate;
	
	private Date tfDate;
	private Date tswDate;
	private Date xbDate;
	private Date oxbDate;
	private Date lstAt;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("y/M/d H:m:s");
	public String getTxtTitle() {
		return txtTitle;
	}
	public void setTxtTitle(String txtTitle) {
		this.txtTitle = txtTitle;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getTxtLaiWenHao() {
		return txtLaiWenHao;
	}
	public void setTxtLaiWenHao(String txtLaiWenHao) {
		this.txtLaiWenHao = txtLaiWenHao;
	}
	public String getTxtLaiWenDept() {
		return txtLaiWenDept;
	}
	public void setTxtLaiWenDept(String txtLaiWenDept) {
		this.txtLaiWenDept = txtLaiWenDept;
	}
	public String getTxtFileDate() {
		return txtFileDate;
	}
	public void setTxtFileDate(String txtFileDate) {
		this.txtFileDate = txtFileDate;
	}
	public String getTxtShouWenDate() {
		return txtShouWenDate;
	}
	public void setTxtShouWenDate(String txtShouWenDate) {
		this.txtShouWenDate = txtShouWenDate;
	}
	public String getProcessVersionInstanceGuid() {
		return processVersionInstanceGuid;
	}
	public void setProcessVersionInstanceGuid(String processVersionInstanceGuid) {
		this.processVersionInstanceGuid = processVersionInstanceGuid;
	}
	public String getLastAt() {
		return lastAt;
	}
	public void setLastAt(String lastAt) {
		this.lastAt = lastAt;
	}
	public String getXianbanDate() {
		return xianbanDate;
	}
	public void setXianbanDate(String xianbanDate) {
		this.xianbanDate = xianbanDate;
	}
	public String getOldXianbanDate() {
		return oldXianbanDate;
	}
	public void setOldXianbanDate(String oldXianbanDate) {
		this.oldXianbanDate = oldXianbanDate;
	}
	public Date getTfDate() throws ParseException {
		tfDate = txtFileDate == null || txtFileDate.isEmpty() ? null : sdf.parse(txtFileDate);
		return tfDate;
	}
	public void setTfDate(Date tfDate) {
		this.tfDate = tfDate;
	}
	public Date getTswDate() throws ParseException {
		tswDate = txtShouWenDate == null || txtShouWenDate.isEmpty() ? null : sdf.parse(txtShouWenDate);
		return tswDate;
	}
	public void setTswDate(Date tswDate) {
		this.tswDate = tswDate;
	}
	public Date getXbDate() throws ParseException {
		xbDate = xianbanDate == null || xianbanDate.isEmpty() ? null : sdf.parse(xianbanDate);
		return xbDate;
	}
	public void setXbDate(Date xbDate) {
		this.xbDate = xbDate;
	}
	public Date getOxbDate() throws ParseException {
		oxbDate = oldXianbanDate == null || oldXianbanDate.isEmpty() ? null : sdf.parse(oldXianbanDate);
		return oxbDate;
	}
	public void setOxbDate(Date oxbDate) {
		this.oxbDate = oxbDate;
	}
	public Date getLstAt() throws ParseException {
		lstAt = lastAt == null || lastAt.isEmpty() ? null : sdf.parse(lastAt);
		return lstAt;
	}
	public void setLstAt(Date lstAt) {
		this.lstAt = lstAt;
	}
	
}
