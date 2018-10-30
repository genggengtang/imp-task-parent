package org.zxs.imp.task.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.dao.consts.ErrorCodeITEnum;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.CardInfo;
import org.zxs.imp.task.dao.model.input.CardAddInput;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.CardPageOut;
import org.zxs.imp.task.dao.model.vo.output.CardTaskPageOut;
import org.zxs.imp.task.dao.model.vo.query.CardTaskQuery;
import org.zxs.imp.task.service.interf.ICardInfoService;
import org.zxs.imp.task.service.interf.IDeptInfoService;
import org.zxs.imp.task.service.interf.IDicInfoService;
import org.zxs.imp.task.service.interf.ILabelInfoService;
import org.zxs.imp.task.service.interf.IUserInfoService;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="003.卡片接口")
//@SessionAttributes({"taskQuery"})
public class CardInfoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CardInfoController.class);
	
	@Resource
	private ICardInfoService cardService;
	
	@Resource
	private IDicInfoService dicService;
	
	@Resource
	private IDeptInfoService deptService;
	
	@Resource
	private IUserInfoService userService;
	
	@Resource
	private ILabelInfoService labelService;
	
	
	@RequestMapping(value = "card-task-page", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "卡片分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<CardPageOut> getCardTaskPage(@RequestParam(value="cLevel", required=false, defaultValue = "" + CardInfo.LEVEL_TOP) Integer cLevel, 
			@RequestBody @ModelAttribute CardTaskQuery query, HttpSession session) {
		if(null == query)
			query = new CardTaskQuery();
		
		query.setCardLevel(cLevel);
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
		
		PageInfo<CardTaskPageOut> pageInfo = cardService.getCardTaskInfoByPage(query);
		// 根据卡片编号获取相关标签信息
		if(null != pageInfo) {
			List<CardTaskPageOut> dList = pageInfo.getList();
			if(null != dList) {
				for(CardTaskPageOut cOut : dList) {
					cOut.setPubLabelList(labelService.getPubLabelsByIds(cOut.getPubLabelIds()));
				}
			}
		}
		
//		PageReturnBean<CardTaskPageOut> pageRet = new PageReturnBean<>();
//		pageRet.setErrorCode(0);
//		pageRet.setDraw(query.getDraw());
//		pageRet.setData(pageInfo.getList());
//		pageRet.setTotal(pageInfo.getTotal());
		
		CommonReturnBean<CardPageOut> pageRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		
		CardPageOut pageOut = new CardPageOut();
		pageOut.setCardPageData(pageInfo);
		switch(cLevel) {
			case CardInfo.LEVEL_SEC: 
				pageOut.setsCardNum(pageInfo.getTotal());
				
				pageOut.setbCardNum(cardService.getCountByCardLevel(CardInfo.LEVEL_TOP, query));
				// 查询相同条件大卡片数量
				break;
			case CardInfo.LEVEL_TOP:
			default:
				pageOut.setbCardNum(pageInfo.getTotal());
				// 查询相同条件小卡片数量
				pageOut.setsCardNum(cardService.getCountByCardLevel(CardInfo.LEVEL_SEC, query));
		}
		pageRet.setData(pageOut);
		return pageRet;
	}
	
//	@RequestMapping(value = "my-card-page", method = RequestMethod.POST)
//	@ApiOperation(httpMethod = "POST", value = "单种卡片分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Authorization
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
//    })
//	public PageReturnBean<MyCardPageOut> getMyCardPage(@RequestParam(value="myType", required=false, defaultValue="" + CardInfo.LEVEL_TOP) Byte cLevel, @ModelAttribute CardTaskQuery query, HttpSession session) {
//		if(null == query)
//			query = new CardTaskQuery();
//		
//		query.setCardLevel(cLevel);
//		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
//		query.setUserId(user.getUserId());
//		int role = user.getRole();
//		Integer deptId = query.getDeptId();
//		if(deptId == null && role > IDicInfoConst.ROLE_LEADER) {
//			query.setDeptId(user.getDeptId());
////			List<Integer> depts = user.getDeptList();
////			if(null != depts && !depts.isEmpty()) {
////				query.setUserDeptList(depts);
////			}
//		}
//		
//		PageInfo<CardTaskPageOut> pageInfo = cardService.getCardTaskInfoByPage(query);
//		// 根据卡片编号获取相关标签信息
//		if(null != pageInfo) {
//			List<CardTaskPageOut> dList = pageInfo.getList();
//			if(null != dList) {
//				for(CardTaskPageOut cOut : dList) {
//					cOut.setPubLabelList(labelService.getPubLabelsByIds(cOut.getPubLabelIds()));
//				}
//			}
//		}
//		
//		PageReturnBean<MyCardPageOut> pageRet = new PageReturnBean<>();
//		pageRet.setErrorCode(0);
//		pageRet.setDraw(query.getDraw());
//		pageRet.setData(pageInfo.getList());
//		pageRet.setTotal(pageInfo.getTotal());
//		return pageRet;
//	}
	
//	@RequestMapping(value = "card-page", method = RequestMethod.POST)
//	@ApiOperation(httpMethod = "POST", value = "所有卡片分页列表", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Authorization
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
//    })
//	public CommonReturnBean<Map<String, PageInfo<CardTaskPageOut>>> getCardPage(@RequestBody @ModelAttribute CardTaskQuery query, HttpSession session) {
//		
//		if(null == query)
//			query = new CardTaskQuery();
//		
//		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
//		query.setUserId(user.getUserId());
//		int role = user.getRole();
//		Integer deptId = query.getDeptId();
//		if(deptId == null && role > IDicInfoConst.ROLE_LEADER_ADMIN) {
//			query.setDeptId(user.getDeptId());
//		}
//		
//		query.setCardLevel(CardInfo.LEVEL_SEC); // 查询第2层级卡片
//		PageInfo<CardTaskPageOut> sCardPage = cardService.getCardTaskInfoByPage(query); // 小卡片列表
//		// 根据卡片编号获取相关标签信息
//		if(null != sCardPage) {
//			List<CardTaskPageOut> sList = sCardPage.getList();
//			if(null != sList) {
//				for(CardTaskPageOut sOut : sList) {
//					sOut.setPubLabelList(labelService.getPubLabelsByIds(sOut.getPubLabelIds()));
//				}
//			}
//		}
//		
//		query.setCardLevel(CardInfo.LEVEL_TOP); // 查询第1层级卡片
//		PageInfo<CardTaskPageOut> bCardPage = cardService.getCardTaskInfoByPage(query); // 大卡片列表
//		// 根据卡片编号获取相关标签信息
//		if(null != bCardPage) {
//			List<CardTaskPageOut> bList = bCardPage.getList();
//			if(null != bList) {
//				for(CardTaskPageOut bOut : bList) {
//					bOut.setPubLabelList(labelService.getPubLabelsByIds(bOut.getPubLabelIds()));
//				}
//			}
//		}
//		
//		Map<String, PageInfo<CardTaskPageOut>> retMap = new HashMap<>();
//		retMap.put("sCard", sCardPage);
//		retMap.put("bCard", bCardPage);
//		
//		CommonReturnBean<Map<String, PageInfo<CardTaskPageOut>>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
//		ret.setData(retMap);
//		return ret;
//	}
	
	
//	@RequestMapping(value = "card-task-conditions", method = RequestMethod.POST)
//	@ApiOperation(httpMethod = "POST", value = "获取卡片任务查询条件", produces = MediaType.APPLICATION_JSON_VALUE)
//	public CommonReturnBean<TaskCondition> getTaskCondition(@RequestParam(required=false, defaultValue=IDicInfoConst.TASK_ALL+"") Integer type) {
//		TaskCondition cond = new TaskCondition();
//		if(null != type) {
//			cond.setTypeList(dicService.getOptionsByType(type, "1"));
//		}
//		
//		cond.setDeptList(deptService.getAllDeptSearchOpts()); // 科室
//		cond.setLeaderList(userService.getLeaderOpts()); // 分管领导
//		cond.setStatusList(dicService.getOptionsByType(IDicInfoConst.TYPE_TASK_STATUS, "4"));
//		
//		CommonReturnBean<TaskCondition> condOut = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
//		condOut.setData(cond);
//		return condOut;
//	}
	
	@RequestMapping(value = "create-card", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "创建卡片", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<Integer> createCard(
			@RequestBody @ModelAttribute @Valid CardAddInput query, BindingResult bResult, HttpSession session) {
		if(bResult.hasErrors()) {
			List<FieldError> fieldErrors = bResult.getFieldErrors();
			LOGGER.warn("请求参数验证失败！{}", JSON.toJSONString(fieldErrors));
			CommonReturnBean<Integer> errorRet = new CommonReturnBean<>(ErrorCodeBaseEnum.PARAM_ILLEGAL);
			errorRet.setErrorMsg(fieldErrors.get(0).getDefaultMessage());
			return errorRet;
		}
		
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		int userId = user.getUserId();
		String name = query.getName();
		
		// 检查卡片名称是否重复
		boolean isDup = cardService.isCardNameExist(name, userId);
		if(isDup) {
			LOGGER.warn("卡片名称'{}'已存在！", name);
			return new CommonReturnBean<>(ErrorCodeITEnum.CARD_NAME_DUP);
		}
		
		query.setUserId(userId);
		
		try {
			int saveCnt = cardService.saveNewCard(query);
			if(saveCnt != 1) {
				LOGGER.warn("新增卡片'{}'失败！", name);
				return new CommonReturnBean<>(ErrorCodeITEnum.CARD_CREATE_FAIL);
			}
			CommonReturnBean<Integer> saveRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
			saveRet.setData(saveCnt);
			return saveRet;
		}  catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			return new CommonReturnBean<>(ErrorCodeBaseEnum.RETURN_ERROR);
		}
		
	}
	
}
