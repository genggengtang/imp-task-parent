package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.TaskStaticsView;
import org.zxs.imp.task.dao.model.vo.output.TaskDetailOut;
import org.zxs.imp.task.dao.model.vo.output.TaskInfoPageOut;
import org.zxs.imp.task.dao.model.vo.output.TaskStaticsOut;
import org.zxs.imp.task.dao.model.vo.query.TaskQuery;

import com.github.pagehelper.PageInfo;

public interface ITaskInfoService {
	
	/**
	 * 分页查询任务信息
	 * @return
	 */
	PageInfo<TaskInfoPageOut> getTaskInfoByPage(TaskQuery query);

	/**
	 * 根据编号获取项目详情
	 * @param id
	 * @return
	 */
	TaskDetailOut getTaskDetailById(long id);
	
	/**
	 * 根据任务分类、年份获取统计信息
	 * @param type
	 * @param year
	 * @param deptId
	 * @return
	 */
	TaskStaticsOut getTaskStaticsByTypeAndYear(int type, Integer year, Integer deptId);

	/**
	 * 根据guid将
	 * @param fileGuidList
	 * @return
	 */
	int batchSaveTaskFromOa(List<String> fileGuidList);
	
}
