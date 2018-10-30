package org.zxs.imp.task.dao.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LabelAddInput {
	
	@NotNull(message = "是否公共卡片字段不能为空！")
	private Byte isPublish;
	
	@NotEmpty(message = "标签内容不能为空！")
	@Size(max=50, message = "标签内容长度不能超过50！")
	private String content;
	
	@NotEmpty(message = "标签文字颜色不能为空！")
	@Size(max=30, message = "标签文字颜色长度不能超过30！")
	private String textColor;
	
	@NotEmpty(message = "标签背景颜色不能为空！")
	@Size(max=30, message = "标签文字颜色长度不能超过30！")
	private String bgcolor;
	
	private Byte starNum;
	
	private String remark;

	public Byte getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Byte isPublish) {
		this.isPublish = isPublish;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? "" : content.trim();
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor == null ? "" : textColor.trim();
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor == null ? "" : bgcolor.trim();
	}

	public Byte getStarNum() {
		return starNum;
	}

	public void setStarNum(Byte starNum) {
		this.starNum = starNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? "" : remark.trim();
	}
	
}
