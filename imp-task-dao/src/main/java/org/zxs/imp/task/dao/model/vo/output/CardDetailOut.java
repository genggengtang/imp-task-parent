package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

import org.zxs.imp.task.dao.model.DairyNote;
import org.zxs.imp.task.dao.model.LabelInfo;

public class CardDetailOut extends CardTaskPageOut{
	
	private List<CardSimpleOut> sonCardList; // 子卡片列表
	
	private List<UserSimpleOut> aheadUserList; // 负责人员
	
	private List<UserSimpleOut> parternUserList; // 配合人员
	
	private List<LabelInfo> priLabelList; // 私人标签列表
	
	private List<DairyNote> timelineList; // 卡片操作记录集合

	public List<CardSimpleOut> getSonCardList() {
		return sonCardList;
	}

	public void setSonCardList(List<CardSimpleOut> sonCardList) {
		this.sonCardList = sonCardList;
	}

	public List<UserSimpleOut> getAheadUserList() {
		return aheadUserList;
	}

	public void setAheadUserList(List<UserSimpleOut> aheadUserList) {
		this.aheadUserList = aheadUserList;
	}

	public List<UserSimpleOut> getParternUserList() {
		return parternUserList;
	}

	public void setParternUserList(List<UserSimpleOut> parternUserList) {
		this.parternUserList = parternUserList;
	}

	public List<LabelInfo> getPriLabelList() {
		return priLabelList;
	}

	public void setPriLabelList(List<LabelInfo> priLabelList) {
		this.priLabelList = priLabelList;
	}

	public List<DairyNote> getTimelineList() {
		return timelineList;
	}

	public void setTimelineList(List<DairyNote> timelineList) {
		this.timelineList = timelineList;
	}
	
}
