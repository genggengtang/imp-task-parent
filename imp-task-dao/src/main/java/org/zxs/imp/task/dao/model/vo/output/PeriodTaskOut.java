package org.zxs.imp.task.dao.model.vo.output;

import java.util.List;

import org.zxs.imp.task.dao.model.SubTask;

/**
 * 周期性任务信息
 * @author Administrator
 *
 */
public class PeriodTaskOut extends SubTask{
	private List<FileSimpleOut> attachments;
	
	public List<FileSimpleOut> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<FileSimpleOut> attachments) {
		this.attachments = attachments;
	}
	
}
