package org.zxs.imp.task.dao.model.vo.output;

public class UserSimpleOut {
	private Integer id;
	private String realName;
	private Integer deptId;
	private String deptName;
	private String deptUserName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptUserName() {
		return deptUserName;
	}
	public void setDeptUserName(String deptUserName) {
		this.deptUserName = deptUserName;
	}
	
}
