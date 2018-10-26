package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

public class TaskCondition {
	List<OptionsOut> typeList;
	List<OptionsOut> deptList;
	List<OptionsOut> leaderList;
	List<OptionsOut> statusList;
	
	public List<OptionsOut> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<OptionsOut> typeList) {
		this.typeList = typeList;
	}
	public List<OptionsOut> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<OptionsOut> deptList) {
		this.deptList = deptList;
	}
	public List<OptionsOut> getLeaderList() {
		return leaderList;
	}
	public void setLeaderList(List<OptionsOut> leaderList) {
		this.leaderList = leaderList;
	}
	public List<OptionsOut> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<OptionsOut> statusList) {
		this.statusList = statusList;
	}
	
}
