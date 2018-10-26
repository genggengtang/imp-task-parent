package org.zxs.imp.task.dao.model.vo.output;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 群组简单信息
 * @author Administrator
 *
 */
public class ChatGroupSimpleOut{
	private Integer id;
	private Integer type; // 聊天类型，1为双人聊天，2为多人聊天
	private String createName; // 群主姓名
	private String groupName; // 群组名
	private Integer groupNum; // 群人数
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createAt; // 群聊组创建时间
	
	private Integer enableNameUpdate;  // 是否允许改名
	private Integer enableRemove;  // 是否允许解散
	
	private Integer unreadNum;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getEnableNameUpdate() {
		return enableNameUpdate;
	}
	public void setEnableNameUpdate(Integer enableNameUpdate) {
		this.enableNameUpdate = enableNameUpdate;
	}
	public Integer getEnableRemove() {
		return enableRemove;
	}
	public void setEnableRemove(Integer enableRemove) {
		this.enableRemove = enableRemove;
	}
	public Integer getUnreadNum() {
		return unreadNum;
	}
	public void setUnreadNum(Integer unreadNum) {
		this.unreadNum = unreadNum;
	}
	public Date getLastAt() {
		return lastAt;
	}
	public void setLastAt(Date lastAt) {
		this.lastAt = lastAt;
	}
	
}
