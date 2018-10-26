package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.TaskInfo;
import org.zxs.imp.task.dao.model.TaskStaticsView;
import org.zxs.imp.task.dao.model.vo.output.TaskDetailOut;
import org.zxs.imp.task.dao.model.vo.output.TaskInfoPageOut;
import org.zxs.imp.task.dao.model.vo.query.TaskQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ITaskInfoMapper extends Mapper<TaskInfo>{
	/**
	 * 查询总任务列表
	 * @param query
	 * @return
	 */
	List<TaskInfoPageOut> selectTaskList(@Param("query")TaskQuery query);
	
	/**
	 * 根据编号获取项目详情
	 * @param id
	 * @return
	 */
	TaskDetailOut selectTaskDetail(long id);
	
	/**
	 * 根据统计类型、年份获取统计信息
	 * @param type
	 * @param year
	 * @return
	 */
	List<TaskStaticsView> selectStaticsByTypeAndYear(@Param("type")int type, @Param("year")Integer year);
	
	/**
	 * 根据统计类型、年份获取任务总数
	 * @param type
	 * @param year
	 * @return
	 */
	int selectStaticsCountByTypeAndYear(@Param("type")int type, @Param("year")Integer year);
	
	/**
	 * 根据科室编号、年份获取部门角色统计信息
	 * @param deptId
	 * @param year
	 * @return
	 */
	List<TaskStaticsView> selectDeptRoleStaticsByYear(@Param("deptId")int deptId, @Param("year")Integer year);
	
	/**
	 * 根据科室编号、年份获取统计信息
	 * @param deptId
	 * @param year
	 * @return
	 */
	List<TaskStaticsView> selectDeptTypeStaticsByYear(@Param("deptId")int deptId, @Param("year")Integer year);
	
	/**
	 * 根据统计类型、年份获取任务总数
	 * @param deptId
	 * @param year
	 * @return
	 */
	int selectDeptStaticsCountByYear(@Param("deptId")int deptId, @Param("year")Integer year);

	/**
	 * 
	 * @param fileGuidList
	 * @return
	 */
	int insertFromOa(@Param("fileGuidList")List<String> fileGuidList);
}