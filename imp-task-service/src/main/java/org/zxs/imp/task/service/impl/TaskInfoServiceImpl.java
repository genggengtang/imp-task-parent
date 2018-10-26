package org.zxs.imp.task.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.interf.ITaskInfoMapper;
import org.zxs.imp.task.dao.interf.IUserDeptMapper;
import org.zxs.imp.task.dao.model.TaskInfo;
import org.zxs.imp.task.dao.model.TaskStaticsView;
import org.zxs.imp.task.dao.model.UserDept;
import org.zxs.imp.task.dao.model.UserDeptExample;
import org.zxs.imp.task.dao.model.UserDeptExample.Criteria;
import org.zxs.imp.task.dao.model.vo.output.TaskDetailOut;
import org.zxs.imp.task.dao.model.vo.output.TaskInfoPageOut;
import org.zxs.imp.task.dao.model.vo.output.TaskStaticsOut;
import org.zxs.imp.task.dao.model.vo.query.TaskQuery;
import org.zxs.imp.task.service.interf.ITaskInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class TaskInfoServiceImpl implements ITaskInfoService {

	@Resource
	private ITaskInfoMapper taskMapper;
	
	@Resource
	private IUserDeptMapper userDeptMapper;

	@Override
	public PageInfo<TaskInfoPageOut> getTaskInfoByPage(TaskQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		
		List<Integer> leaderArray = query.getLeaderArray();
		if(null != leaderArray && !leaderArray.isEmpty()) { // 分管领导条件转换为部门
			UserDeptExample example = new UserDeptExample();
			Criteria leaderCriteria = example.createCriteria();
			leaderCriteria.andUserIdIn(leaderArray);
			leaderCriteria.andRoleEqualTo(IUserDeptMapper.ROLE_LEADER);
			List<UserDept> userDeptList = userDeptMapper.selectByExample(example);
			
			if(null != userDeptList && !userDeptList.isEmpty()) {
				List<Integer> deptArray = query.getDeptArray();
				Set<Integer> leaderSet = new HashSet<>();
				if(null != deptArray && !deptArray.isEmpty()) {
					leaderSet = new HashSet<>(deptArray);
				}else {
					deptArray = new ArrayList<>();
				}
				
				for(UserDept ud : userDeptList) {
					Integer deptId = ud.getDeptId();
					if(leaderSet.isEmpty()) {
						deptArray.add(deptId);
						leaderSet.add(deptId);
					}else {
						if(!leaderSet.contains(deptId)) {
							deptArray.add(deptId);
							leaderSet.add(deptId);
						}
					}
				}
				query.setDeptArray(deptArray);
			}
			
		}
		
		List<TaskInfoPageOut> outsList = taskMapper.selectTaskList(query);
		return new PageInfo<>(outsList);
	}

	@Override
	public TaskDetailOut getTaskDetailById(long id) {
		return taskMapper.selectTaskDetail(id);
	}

	@Override
	public TaskStaticsOut getTaskStaticsByTypeAndYear(int type, Integer year, Integer deptId) {
		TaskStaticsOut stsOut = new TaskStaticsOut();
		switch(type) {
			case IDicInfoConst.TASK_ALL: {// 获取全部任务统计
				stsOut.setTypeStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_ALL_TYPE, year));
				stsOut.setDeptStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_ALL_DEPT, year));
				stsOut.setStatusStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_ALL_STATUS, year));
				
				stsOut.setTotal(taskMapper.selectStaticsCountByTypeAndYear(TaskStaticsView.STS_ALL_TYPE, year));
				return stsOut;
			}
			case IDicInfoConst.TASK_CITY: {// 获取上级任务统计
				stsOut.setTypeStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_CITY_TYPE, year));
				stsOut.setDeptStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_CITY_DEPT, year));
				stsOut.setStatusStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_CITY_STATUS, year));
				
				stsOut.setTotal(taskMapper.selectStaticsCountByTypeAndYear(TaskStaticsView.STS_CITY_TYPE, year));
				return stsOut;
			}
			case IDicInfoConst.TASK_COMMITTEE:{// 获取委内任务统计
				stsOut.setTypeStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_COMMITEE_TYPE, year));
				stsOut.setDeptStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_COMMITEE_DEPT, year));
				stsOut.setStatusStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_COMMITEE_STATUS, year));
				
				stsOut.setTotal(taskMapper.selectStaticsCountByTypeAndYear(TaskStaticsView.STS_COMMITEE_TYPE, year));
				return stsOut;
			}
			case IDicInfoConst.TASK_KPI:{// 获取绩效考核统计
				stsOut.setTypeStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_KPI_TYPE, year));
				stsOut.setDeptStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_KPI_DEPT, year));
				stsOut.setStatusStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_KPI_STATUS, year));
				
				stsOut.setTotal(taskMapper.selectStaticsCountByTypeAndYear(TaskStaticsView.STS_KPI_TYPE, year));
				return stsOut;
			}
			case IDicInfoConst.TASK_DAILY:{// 获取日常任务统计
				stsOut.setTypeStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_DAILY_TYPE, year));
				stsOut.setDeptStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_DAILY_DEPT, year));
				stsOut.setStatusStsList(taskMapper.selectStaticsByTypeAndYear(TaskStaticsView.STS_DAILY_STATUS, year));
				
				stsOut.setTotal(taskMapper.selectStaticsCountByTypeAndYear(TaskStaticsView.STS_DAILY_TYPE, year));
				return stsOut;
			}
			default: // 科室工作统计
			{
				if(null != deptId) {
					stsOut.setTypeStsList(taskMapper.selectDeptRoleStaticsByYear(deptId, year));
					stsOut.setDeptTypeStsList(taskMapper.selectDeptTypeStaticsByYear(deptId, year));
					
					stsOut.setTotal(taskMapper.selectDeptStaticsCountByYear(deptId, year));
				}
				
				return stsOut;
			}
		}
	}

	@Override
	@Transactional
	public int batchSaveTaskFromOa(List<String> fileGuidList) {
		int insNum = taskMapper.insertFromOa(fileGuidList);
		return 0;
	}

	
	
}
