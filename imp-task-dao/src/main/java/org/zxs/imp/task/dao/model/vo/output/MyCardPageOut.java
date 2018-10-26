package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

import org.zxs.imp.task.dao.model.LabelInfo;

public class MyCardPageOut extends CardTaskPageOut{
	private Integer myCardStatus;
	private List<LabelInfo> priLabelList;
	
	public Integer getMyCardStatus() {
		return myCardStatus;
	}
	public void setMyCardStatus(Integer myCardStatus) {
		this.myCardStatus = myCardStatus;
	}
	public List<LabelInfo> getPriLabelList() {
		return priLabelList;
	}
	public void setPriLabelList(List<LabelInfo> priLabelList) {
		this.priLabelList = priLabelList;
	}
	
}
