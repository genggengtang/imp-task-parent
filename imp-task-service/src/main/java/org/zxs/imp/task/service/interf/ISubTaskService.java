package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.PeriodTaskOut;

public interface ISubTaskService {
	/**
	 * 根据任务编号获取子任务信息
	 * @param id
	 * @return
	 */
	List<PeriodTaskOut> getPeriodSubTaskInfoByTaskId(long id);
}
