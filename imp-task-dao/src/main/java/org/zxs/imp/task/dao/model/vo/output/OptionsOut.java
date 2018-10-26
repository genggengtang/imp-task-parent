package org.zxs.imp.task.dao.model.vo.output;

/**
 * 选项对象
 * @author Administrator
 *
 */
public class OptionsOut {
	
	private String optText;
	
	private String optValue;
	
	private Integer textLength;
	
	private String remark; // 备用字段
	
	public String getOptValue() {
		return optValue;
	}
	public void setOptValue(String optValue) {
		this.optValue = optValue;
	}
	public String getOptText() {
		return optText;
	}
	public void setOptText(String optText) {
		this.optText = optText;
		if(null != optText) {
			this.textLength = optText.length();
		}
	}
	public Integer getTextLength() {
		return textLength;
	}
	public void setTextLength(Integer textLength) {
		this.textLength = textLength;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
