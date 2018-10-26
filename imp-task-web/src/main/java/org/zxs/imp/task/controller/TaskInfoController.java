package org.zxs.imp.task.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.base.model.PageReturnBean;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.dao.consts.ErrorCodeITEnum;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.TaskCondition;
import org.zxs.imp.task.dao.model.vo.output.TaskDetailOut;
import org.zxs.imp.task.dao.model.vo.output.TaskInfoPageOut;
import org.zxs.imp.task.dao.model.vo.output.TaskStaticsOut;
import org.zxs.imp.task.dao.model.vo.query.TaskQuery;
import org.zxs.imp.task.service.interf.IDeptInfoService;
import org.zxs.imp.task.service.interf.IDicInfoService;
import org.zxs.imp.task.service.interf.ISubTaskService;
import org.zxs.imp.task.service.interf.ITaskFileService;
import org.zxs.imp.task.service.interf.ITaskInfoService;
import org.zxs.imp.task.service.interf.IUserCommentService;
import org.zxs.imp.task.service.interf.IUserInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="任务接口")
//@SessionAttributes({"taskQuery"})
public class TaskInfoController {
	private static final Logger logger = LoggerFactory.getLogger(TaskInfoController.class);
	
	@Resource
	private ITaskInfoService taskService;
	
	@Resource
	private IDicInfoService dicService;
	
	@Resource
	private IDeptInfoService deptService;
	
	@Resource
	private IUserInfoService userService;
	
	@Resource
	private IUserCommentService userCommentService;
	
	@Resource
	private ITaskFileService taskFileService;
	
	@Resource
	private ISubTaskService subTaskService;
	
	
	@RequestMapping(value = "task-page", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "任务分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public PageReturnBean<TaskInfoPageOut> getTaskPage(@RequestBody @ModelAttribute TaskQuery query, HttpSession session) {
		if(null == query)
			query = new TaskQuery();
		
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		query.setUserId(user.getUserId());
		int role = user.getRole();
		Integer deptId = query.getDeptId();
		if(deptId == null && role > IDicInfoConst.ROLE_LEADER_ADMIN) {
			query.setDeptId(user.getDeptId());
//			List<Integer> depts = user.getDeptList();
//			if(null != depts && !depts.isEmpty()) {
//				query.setUserDeptList(depts);
//			}
		}
		
		PageInfo<TaskInfoPageOut> pageInfo = taskService.getTaskInfoByPage(query);
		PageReturnBean<TaskInfoPageOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(query.getDraw());
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "task-detail", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "获取任务详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<TaskDetailOut> getTaskDetail(@RequestParam(value="id", required=true) long id) {
		TaskDetailOut detail = taskService.getTaskDetailById(id);
		
		if(null == detail) {
			return new CommonReturnBean<>(ErrorCodeITEnum.TASK_ABSENT);
		}
		
		CommonReturnBean<TaskDetailOut> detailOut = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		
		long subId = detail.getCurrentSubId();
		detail.setLeaderCommentList(userCommentService.getLeaderComments(subId));
		detail.setFinalCommentList(userCommentService.getFinalComments(subId));
		detail.setFileBaseList(taskFileService.getFileSimpleInfoBySubIdAndType(subId, IDicInfoConst.FILE_BASIS));
		detail.setAttachmentList(taskFileService.getFileSimpleInfoBySubIdAndType(subId, IDicInfoConst.FILE_ATTACHMENT));
		byte isPeriod = detail.getIsPeriod();
		if(isPeriod == 1) { // 周期性项目
			detail.setPeriodList(subTaskService.getPeriodSubTaskInfoByTaskId(id));
		}
		detailOut.setData(detail);
		return detailOut;
	}
	
	@RequestMapping(value = "task-conditions", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "获取任务查询条件", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<TaskCondition> getTaskCondition(@RequestParam(required=false, defaultValue=IDicInfoConst.TASK_ALL+"") Integer type) {
		TaskCondition cond = new TaskCondition();
		if(null != type) {
			cond.setTypeList(dicService.getOptionsByType(type, "1"));
		}
		
		cond.setDeptList(deptService.getAllDeptSearchOpts()); // 科室
		cond.setLeaderList(userService.getLeaderOpts()); // 分管领导
		cond.setStatusList(dicService.getOptionsByType(IDicInfoConst.TYPE_TASK_STATUS, "4"));
		
		CommonReturnBean<TaskCondition> condOut = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		condOut.setData(cond);
		return condOut;
	}
	
	@RequestMapping(value = "task-statics", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "任务统计", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<TaskStaticsOut> getTaskStatics(
			@RequestParam(required=false, defaultValue=IDicInfoConst.TASK_ALL+"") Integer type, 
			@RequestParam(required=false) Integer year,
			@RequestParam(required=false, value="deptId") Integer deptId) {
		CommonReturnBean<TaskStaticsOut> stsOut = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		stsOut.setData(taskService.getTaskStaticsByTypeAndYear(type, year, deptId));
		return stsOut;
	}
	
}
