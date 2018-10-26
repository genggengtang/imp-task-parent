package org.zxs.imp.task.controller;

import java.util.Date;

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
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.base.model.PageReturnBean;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.dao.consts.ErrorCodeITEnum;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.model.CardLabel;
import org.zxs.imp.task.dao.model.LabelInfo;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.LabelOut;
import org.zxs.imp.task.dao.model.vo.query.MyLabelQuery;
import org.zxs.imp.task.service.interf.ILabelInfoService;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="007.标签信息")
public class LabelInfoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LabelInfoController.class);
	
	@Resource
	private ILabelInfoService labelService;
	
	@RequestMapping(value = "my-labels", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "我的标签列表，包括公共和私人", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public PageReturnBean<LabelOut> getMyLabels(@RequestBody @ModelAttribute MyLabelQuery query, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		if(null == query)
			query = new MyLabelQuery();
		
		query.setUserId(user.getUserId());
		PageInfo<LabelOut> pageInfo = labelService.getMyLabels(query);
		PageReturnBean<LabelOut> pageRet = new PageReturnBean<>();
		pageRet.setErrorCode(0);
		pageRet.setDraw(query.getDraw());
		pageRet.setData(pageInfo.getList());
		pageRet.setTotal(pageInfo.getTotal());
		return pageRet;
	}
	
	@RequestMapping(value = "create-label", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "新增标签", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<Integer> createLabel(
			@RequestParam(value="isPublish", required=true) Byte isPublish,
			@RequestParam(value="content", required=true) String content,
			@RequestParam(value="starNum", required=false) Byte starNum,
			@RequestParam(value="textColor", required=false) String textColor,
			@RequestParam(value="bgColor", required=false) String bgcolor,
			@RequestParam(value="remark", required=false) String remark, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		int userId = user.getUserId();
		
		// 判断标签内容是否重复
		boolean isDup = labelService.checkLabelContent(content.trim(), userId);
		if(isDup) {
			LOGGER.warn("标签名称{}已存在！", content);
			return new CommonReturnBean<>(ErrorCodeITEnum.LABEL_NAME_DUP);
		}
		
		LabelInfo li = new LabelInfo();
		li.setCreateAt(new Date());
		li.setIsPublish(isPublish);
		li.setLabelContent(content);
		li.setIsDelete((byte) 0);
		
		if(isPublish == 0) {
			li.setCreateId(userId);
		}else {
			li.setCreateId(0);
		}
		
		if(null != starNum)
			li.setLabelStar(starNum);
		
		if(null != textColor)
			li.setLabelColor(textColor);
		
		if(null != bgcolor)
			li.setLabelBgcolor(bgcolor);
		
		if(null != remark)
			li.setRemark(remark);
		
		int addCnt = labelService.createLabel(li);
		
		CommonReturnBean<Integer> addRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		addRet.setData(addCnt);
		return addRet;
	}
	
	@RequestMapping(value = "add-card-label", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "添加卡片标签关联", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<Integer> addCardLabel(
			@RequestParam(value="labelId", required=true) Long labelId,
			@RequestParam(value="cardId", required=true) Long cardId, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		int userId = user.getUserId();
		
		// 判断卡片标签是否存在
		boolean isExist = labelService.checkCardLabel(labelId, cardId);
		if(isExist) {
			LOGGER.warn("卡片{}和标签{}已关联！", cardId, labelId);
			return new CommonReturnBean<>(ErrorCodeITEnum.CARD_LABEL_EXIST);
		}
		
		CardLabel cl = new CardLabel();
		cl.setCardId(cardId);
		cl.setLabelId(labelId);
		cl.setCreateId(userId);
		int addCnt = labelService.addCardLabel(cl);
		CommonReturnBean<Integer> addRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		addRet.setData(addCnt);
		return addRet;
	}
	
	@RequestMapping(value = "del-card-label", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "移除卡片标签关联", produces = MediaType.APPLICATION_JSON_VALUE)
	@Authorization
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<Integer> delCardLabel(
			@RequestParam(value="labelId", required=true) Long labelId,
			@RequestParam(value="cardId", required=true) Long cardId, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		int userId = user.getUserId();
		
		// 判断卡片标签关系是否存在
		boolean isExist = labelService.checkCardLabel(labelId, cardId);
		if(!isExist) {
			LOGGER.warn("卡片{}和标签{}无关联关系！", cardId, labelId);
			return new CommonReturnBean<>(ErrorCodeITEnum.CARD_LABEL_ABSENT);
		}
		
		CardLabel cl = new CardLabel();
		cl.setCardId(cardId);
		cl.setLabelId(labelId);
		cl.setCreateId(userId);
		int addCnt = labelService.addCardLabel(cl);
		CommonReturnBean<Integer> addRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		addRet.setData(addCnt);
		return addRet;
	}
}
