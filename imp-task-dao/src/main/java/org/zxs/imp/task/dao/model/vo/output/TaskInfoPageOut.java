package org.zxs.imp.task.dao.model.vo.output;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.TaskView;

public class TaskInfoPageOut extends TaskView{
	private String[] taskLabelArray;
	private String dayRestDis;
	private Long favoriteId;
	private String[] aheadDeptArray;
	private Integer alertLevel;
	private int dayRestAbs;
	private String customLabels;
	private String[] customLabelArray;
	private Set<String> allLabelSet = new LinkedHashSet<>();
	
	public String[] getTaskLabelArray() {
		String taskLabels = this.getTaskLabels();
		if(null != taskLabels && !taskLabels.isEmpty()) {
			this.taskLabelArray = taskLabels.split(",");
			this.allLabelSet.addAll(Arrays.asList(this.taskLabelArray));
		}
		return taskLabelArray;
	}
	public void setTaskLabelArray(String[] taskLabelArray) {
		this.taskLabelArray = taskLabelArray;
	}
	public String getDayRestDis() {
		Integer status = this.getStatus();
		if(status == IDicInfoConst.TASK_DONE) {
			this.dayRestDis = "已办";
		}else if(status == IDicInfoConst.TASK_DONE) {
			this.dayRestDis = "缓办";
		}else {
			Integer dayRest = this.getDayRest();
			if(null != dayRest) {
				if(dayRest >= 0) {
					this.dayRestDis = "还剩" + dayRestAbs + "天";
				} else {
					this.dayRestDis = "超过" + dayRestAbs + "天";
				} 
			}
		}
		return dayRestDis;
	}
	public void setDayRestDis(String dayRestDis) {
		this.dayRestDis = dayRestDis;
	}
	
	public Long getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String[] getAheadDeptArray() {
		String aheadDepts = this.getAheadDepts();
		if(null != aheadDepts && !aheadDepts.isEmpty()) {
			this.aheadDeptArray = aheadDepts.split(",");
		}
		return aheadDeptArray;
	}
	public void setAheadDeptArray(String[] aheadDeptArray) {
		this.aheadDeptArray = aheadDeptArray;
	}
	public Integer getAlertLevel() {
		Integer status = this.getStatus();
		if(status == IDicInfoConst.TASK_DONE) {
			this.alertLevel = 1;
		}else if(status == IDicInfoConst.TASK_DONE) {
			this.alertLevel = 2;
		}else {
			Integer dayRest = this.getDayRest();
			if(null != dayRest) {
				if(dayRest >= 2) {
					this.alertLevel = 3;
				} else if(dayRest >= 0) {
					this.alertLevel = 4;
				} else {
					this.alertLevel = 5;
				}
			}
			 
		}
		return alertLevel;
	}
	public void setAlertLevel(Integer alertLevel) {
		this.alertLevel = alertLevel;
	}
	public int getDayRestAbs() {
		Integer dayRest = this.getDayRest();
		if(null != dayRest)
			this.dayRestAbs = Math.abs(dayRest.intValue());
		return dayRestAbs;
	}
	public void setDayRestAbs(int dayRestAbs) {
		this.dayRestAbs = dayRestAbs;
	}
	public String getCustomLabels() {
		return customLabels;
	}
	public void setCustomLabels(String customLabels) {
		this.customLabels = customLabels;
		if(null != customLabels && !customLabels.isEmpty()) {
			this.customLabelArray = customLabels.split(",");
			this.allLabelSet.addAll(Arrays.asList(this.customLabelArray));
		}
	}
	public String[] getCustomLabelArray() {
		return customLabelArray;
	}
	public void setCustomLabelArray(String[] customLabelArray) {
		this.customLabelArray = customLabelArray;
	}
	public Set<String> getAllLabelSet() {
		return allLabelSet;
	}
	public void setAllLabelSet(Set<String> allLabelSet) {
		this.allLabelSet = allLabelSet;
	}
	
}
