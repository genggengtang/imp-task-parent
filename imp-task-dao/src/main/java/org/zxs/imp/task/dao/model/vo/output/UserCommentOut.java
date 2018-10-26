package org.zxs.imp.task.dao.model.vo.output;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.zxs.imp.task.dao.model.UserComment;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserCommentOut extends UserComment{
	private String userName;
	private String deptName;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date commentDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
}
