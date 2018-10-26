package org.zxs.imp.task.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.service.interf.IDeptInfoService;
import org.zxs.imp.task.service.interf.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="002.科室信息")
public class DeptInfoController {
	private static final Logger logger = LoggerFactory.getLogger(DeptInfoController.class);
	
	@Resource
	private IDeptInfoService deptService;
	
	@Resource
	private IUserInfoService userService;
	
	@RequestMapping(value = "dept-list", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "科室列表", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Authorization
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
//    })
	public CommonReturnBean<List<OptionsOut>> getDeptList() {
//		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
//		int userId = user.getUserId();
//		int role = user.getRole();
		
		CommonReturnBean<List<OptionsOut>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
//		if(role > IDicInfoConst.ROLE_OFFICE) {
//			ret.setData(deptService.getAllDeptSearchOpts());
//		} else {
//			ret.setData(deptService.getDeptOptsByUser(userId));
//		}
		ret.setData(deptService.getAllDeptSearchOpts());
		return ret;
	}
	
	@RequestMapping(value = "dept-user-list", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "科室用户列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<List<OptionsOut>> getDeptUserList(@RequestParam(value="deptId", required=true)int deptId) {
		CommonReturnBean<List<OptionsOut>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		ret.setData(userService.getUserOptsByDept(deptId));
		return ret;
	}
	
	@RequestMapping(value = "dept-user-opts", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "科室用户选项列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Map<String, List<OptionsOut>>> getDeptUserOpts() {
		CommonReturnBean<Map<String, List<OptionsOut>>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		ret.setData(userService.getDeptUserOpts());
		return ret;
	}
	
	@RequestMapping(value = "leader-opts", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "分管领导选项列表", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<List<OptionsOut>> getLeaderOpts() {
		CommonReturnBean<List<OptionsOut>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		ret.setData(userService.getLeaderOpts());
		return ret;
	}
}
