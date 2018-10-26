package org.zxs.imp.task.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.controller.bean.AckChatLaunch;
import org.zxs.imp.task.dao.consts.ErrorCodeITEnum;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneListOut;
import org.zxs.imp.task.dao.model.vo.query.ChatGroupQuery;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;
import org.zxs.imp.task.dao.model.vo.query.TaskQuery;
import org.zxs.imp.task.service.interf.IChatGroupInfoService;
import org.zxs.imp.task.service.interf.IChatGroupUserService;
import org.zxs.imp.task.service.interf.IChatMsgStatusService;
import org.zxs.imp.task.service.interf.IUserInfoService;
import org.zxs.utils.CommonUtil;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="004.群聊接口")
public class ChatGroupController {
	private static final Log log = LogFactory.getLog(ChatGroupController.class);

	@Resource
	private IChatGroupInfoService cgInfoService;
	
	@Resource
	private IChatGroupUserService cgUserService;
	
	@Resource
	private IChatMsgStatusService msgStatusService;
	
	@Resource
	private IUserInfoService userService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
	@RequestMapping(value = "create-chat-room", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "创建聊天室", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<ChatGroupSimpleOut> createChatRoom(@ModelAttribute ChatGroupQuery query, HttpSession session) {
		if(null == query)
			return new CommonReturnBean<>(ErrorCodeBaseEnum.PARAM_ILLEGAL);
		
		Integer roomId = query.getId();
		if(roomId != null) {
			return new CommonReturnBean<>(ErrorCodeBaseEnum.CHATROOM_EXIST);
		}
		
		List<Integer> uList = query.getUserList();
		if(null == uList || uList.isEmpty())
			return new CommonReturnBean<>(ErrorCodeITEnum.CG_USER_NULL);
		
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		query.setEnableRemove((byte) 1);
		query.setCreateAt(new Date());
		query.setCreateId(user.getUserId());
		
		try {
			ChatGroupInfo cgInfo = cgInfoService.createChatRoom(query);
    		if(null == cgInfo) {
    			return new CommonReturnBean<>(ErrorCodeBaseEnum.CREATE_CHATROOM_FAIL);
    		}
    		
    		ChatGroupSimpleOut cgSimple = new ChatGroupSimpleOut();
    		Integer id = cgInfo.getId();
			cgSimple.setId(id);
    		cgSimple.setGroupName(query.getGroupName());
    		cgSimple.setGroupNum(query.getUserList().size() + 1);
    		cgSimple.setCreateAt(query.getCreateAt());
    		
    		ecLaunch.addMsgEventListener(id);
    		CommonReturnBean<ChatGroupSimpleOut> createRet = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
			createRet.setData(cgSimple);
			return createRet;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			return new CommonReturnBean<>(ErrorCodeBaseEnum.CREATE_CHATROOM_ERROR);
		}
	}
	
	@RequestMapping(value = "phone-list", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "通讯录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<PhoneListOut> getPhoneList(@RequestParam(required=false,value="nameLike") String nameLike, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		PhoneListQuery query = new PhoneListQuery();
		query.setUserId(user.getUserId());
		query.setUserLevel(user.getLevel());
			
		if(null != nameLike)
			query.setNameLike(nameLike);
    	
		CommonReturnBean<PhoneListOut> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		ret.setData(userService.getPhoneList(query));
		return ret;
	}
}
