package org.zxs.imp.task.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.controller.bean.AckChatLaunch;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.ChatMsgOut;
import org.zxs.imp.task.dao.model.vo.query.MsgHisQuery;
import org.zxs.imp.task.service.interf.IChatGroupMsgService;
import org.zxs.imp.task.service.interf.IChatMsgStatusService;
import org.zxs.utils.UploadQiniu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="005.群聊消息接口")
public class ChatGroupMsgController {
	private static final Logger log = LoggerFactory.getLogger(ChatGroupMsgController.class);
	
	@Resource
	private IChatGroupMsgService cgMsgService;
	
	@Resource
	private IChatMsgStatusService msgStatusService;
	
	@Resource
	private AckChatLaunch ecLaunch;
	
	
	@RequestMapping(value = "my-chat-msg", method = RequestMethod.POST)
	@Authorization
	@ApiOperation(httpMethod = "POST", value = "聊天室的聊天历史记录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
	public CommonReturnBean<List<ChatMsgOut>> getMyChatMsg(@ModelAttribute MsgHisQuery query, HttpSession session) {
		AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
		Integer cgId = query.getId();
		int userId = user.getUserId();
		query.setUserId(userId);
		
		List<ChatMsgOut> msgList = cgMsgService.getLatestMsgHisById(query);
		
		if(!msgList.isEmpty())
			Collections.reverse(msgList);
		
		log.info("更新已读消息状态！cgId({}),userId({})", cgId, userId);
		int updStatusCnt = msgStatusService.updateMsgReadStatusByUserIdAndCgId(userId, cgId);
		if(updStatusCnt > 0) {
			log.info("成功更新{}条消息已读状态！", updStatusCnt);
		}
		
		CommonReturnBean<List<ChatMsgOut>> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
		ret.setData(msgList);
		return ret;
	}
	
	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "upload-file", method = RequestMethod.POST)
	public CommonReturnBean<String> uploadChatFile(HttpServletRequest request) {
		CommonReturnBean<String> ret = new CommonReturnBean<>();
		String formData = request.getParameter("fileData");
		log.info(formData);
		if(null == formData || formData.isEmpty()) {
			ret.setErrorCode(-121);
			ret.setErrorMsg("没有文件上传！");
			return ret;
		}
		
		if(!formData.contains(",")) {
			ret.setErrorCode(-122);
			ret.setErrorMsg("文件上传参数出错！");
			return ret;
		}
		
		String fileName = request.getParameter("fileName");
		Decoder decoder = Base64.getDecoder();
		byte[] imgData = decoder.decode(formData.substring(formData.indexOf(",")+1));
		
		InputStream is = new ByteArrayInputStream(imgData);
		try {
			String url = UploadQiniu.uploadImgQiniu(is, System.currentTimeMillis() + "/" + fileName);
			ret.setErrorCode(0);
			ret.setData(url);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			ret.setErrorCode(-123);
			ret.setErrorMsg("文件上传服务器失败！");
		}

		return ret;
	}

}
