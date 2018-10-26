package org.zxs.imp.task.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.service.interf.ITokenManager;
import org.zxs.imp.task.service.interf.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags="001.用户登录接口")
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
    private ITokenManager<AppUser> tokenManager;
	
	@Resource
    private IUserInfoService userService;
	
    @RequestMapping(value = "app-login", method = RequestMethod.POST, name="APP登录")
    @ApiOperation(httpMethod = "POST", value = "APP登录", produces = MediaType.APPLICATION_JSON_VALUE, notes="密码需经过md5加密")
    public CommonReturnBean<AppUser> appLogin(@RequestParam(required=true,value="username") String username,
			@RequestParam(required=true,value="password") String password, HttpSession session) {
//    	try {
    		AppUser appUser = userService.getAppLoginInfo(username, null);
        	if(null == appUser) {
                return new CommonReturnBean<>(ErrorCodeBaseEnum.USER_ABSENT);
        	}
        	
        	appUser = userService.getAppLoginInfo(username, password);
        	
        	if(null == appUser) {
                return new CommonReturnBean<>(ErrorCodeBaseEnum.PSW_ERROR);
        	}
        	
        	log.info("用户登录验证通过，用户名为{}", username);
        	
        	//生成一个token，保存用户登录状态
        	String token = tokenManager.createToken(appUser);
        	appUser.setToken(token);
        	appUser.setToday(new Date());
            session.setAttribute(IAppConst.SESSION_USER_NAME, appUser);
            
        	CommonReturnBean<AppUser> result = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
        	result.setData(appUser);
        	log.info("用户{}登录成功!", appUser.getLoginName());
        	return result;
//    	}catch(Exception e) {
//    		log.error(e.getMessage(), e);
//    		return new CommonReturnBean<>(ErrorCodeBaseEnum.APP_LOGIN_FAIL);
//    	}
    }
    
    @Authorization
    @ApiOperation(httpMethod = "POST", value = "授权登录", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息！")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
    @RequestMapping(value = "auth-login", method = RequestMethod.POST, name="APP授权登录")
    public CommonReturnBean<AppUser> authLogin(HttpSession session) throws IOException {
    	AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	CommonReturnBean<AppUser> result = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
    	user.setToday(new Date());
		result.setData(user);
		log.info("授权登录成功！登录用户为{}",user.getUsername());
		return result;
    }
    
    @Authorization
    @ApiOperation(httpMethod = "POST", value = "APP修改用户密码", produces = MediaType.APPLICATION_JSON_VALUE, notes="请在头部添加授权信息,同时,密码需经过md5加密")
    @ApiImplicitParams({
        @ApiImplicitParam(name = IAppConst.AUTHORIZATION, value = IAppConst.AUTHORIZATION, required = true, dataType = "string", paramType = "header"),
    })
    @RequestMapping(value = "mod-password", method = RequestMethod.POST, name="APP用户修改密码")
    public CommonReturnBean<Integer> modPassword(@RequestParam(required=true,value="pswdOld") String pswdOld,
    		@RequestParam(required=true,value="pswdNew") String pswdNew, HttpSession session) {
    	CommonReturnBean<Integer> result = new CommonReturnBean<>();
    	AppUser user = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);
    	if(null != user){
    		try {
    			AppUser userOut = userService.getAppLoginInfo(user.getLoginName(), pswdOld);
        		if(null == userOut) {
        			return new CommonReturnBean<>(ErrorCodeBaseEnum.PSW_ERROR);
        		}
        		
        		int userId = user.getUserId();
    			int updRet = userService.updatePassword(userId, pswdNew);
        		if(updRet != 1) {
                    return new CommonReturnBean<>(ErrorCodeBaseEnum.MOD_PSW_FAIL);
        		}
        		
        		tokenManager.deleteToken(userOut.getToken());
        		result.setErrorCode(0);
                result.setErrorMsg("修改密码成功！");
                return new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
    		}catch(Exception e) {
    			log.error(e.getMessage(), e);
    			return new CommonReturnBean<>(ErrorCodeBaseEnum.MOD_PSW_ERROR);
    		}
    		
    	}else {
    		return new CommonReturnBean<>(ErrorCodeBaseEnum.UNAUTHORIZED);
    	}
        
    }
    
}
