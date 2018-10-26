package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.SubTask;
import org.zxs.imp.task.dao.model.vo.output.PeriodTaskOut;

import tk.mybatis.mapper.common.Mapper;

public interface ISubTaskMapper extends Mapper<SubTask>{
	/**
	 * 根据任务编号获取子任务信息
	 * @param id
	 * @return
	 */
	List<PeriodTaskOut> selectSubTaskByTaskId(long id);
}