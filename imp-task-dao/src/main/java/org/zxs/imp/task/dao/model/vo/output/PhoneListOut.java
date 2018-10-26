package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

public class PhoneListOut {
	private List<PhoneCardOut> dialog;
	private List<ChatGroupSimpleOut> group;
	
	public PhoneListOut(List<PhoneCardOut> dialog, List<ChatGroupSimpleOut> group) {
		super();
		this.dialog = dialog;
		this.group = group;
	}
	public PhoneListOut() {
		super();
	}
	public List<PhoneCardOut> getDialog() {
		return dialog;
	}
	public void setDialog(List<PhoneCardOut> dialog) {
		this.dialog = dialog;
	}
	public List<ChatGroupSimpleOut> getGroup() {
		return group;
	}
	public void setGroup(List<ChatGroupSimpleOut> group) {
		this.group = group;
	}
	
	
}
