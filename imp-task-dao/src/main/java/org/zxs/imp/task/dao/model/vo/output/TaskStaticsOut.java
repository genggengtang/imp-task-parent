package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

import org.zxs.imp.task.dao.model.TaskStaticsView;

public class TaskStaticsOut {
	private Integer total; // 每一类任务总数
	private List<TaskStaticsView> typeStsList; // 按任务分类
	private List<TaskStaticsView> deptStsList; // 按科室
	private List<TaskStaticsView> statusStsList; // 按状态
	private List<TaskStaticsView> deptTypeStsList; // 科室按任务分类
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<TaskStaticsView> getTypeStsList() {
		return typeStsList;
	}
	public void setTypeStsList(List<TaskStaticsView> typeStsList) {
		this.typeStsList = typeStsList;
	}
	public List<TaskStaticsView> getDeptStsList() {
		return deptStsList;
	}
	public void setDeptStsList(List<TaskStaticsView> deptStsList) {
		this.deptStsList = deptStsList;
	}
	public List<TaskStaticsView> getStatusStsList() {
		return statusStsList;
	}
	public void setStatusStsList(List<TaskStaticsView> statusStsList) {
		this.statusStsList = statusStsList;
	}
	public List<TaskStaticsView> getDeptTypeStsList() {
		return deptTypeStsList;
	}
	public void setDeptTypeStsList(List<TaskStaticsView> deptTypeStsList) {
		this.deptTypeStsList = deptTypeStsList;
	}
	
}
