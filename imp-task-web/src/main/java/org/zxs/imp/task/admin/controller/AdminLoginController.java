package org.zxs.imp.task.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.SessionUser;
import org.zxs.utils.CommonUtil;

@Controller
//@SessionAttributes({IAppConst.SESSION_ADMIN_NAME}) 
@RequestMapping("/admin")
public class AdminLoginController {
	private static final Log log = LogFactory.getLog(AdminLoginController.class);
	
//	@Resource
//	private IAdminUserService adminUserService;
	
//    @RequestMapping(value = "/admin-login", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonReturnBean<AdminUserOut> adminLogin(@RequestParam(required=true,value="username") String username,
//			@RequestParam(required=true,value="password") String password,
//			HttpServletRequest request) {
//    	CommonReturnBean<AdminUserOut> ret = new CommonReturnBean<>();
//    	try {
//    		AdminUserOut admin = adminUserService.getAdminByLoginNameAndPassword(username, password);
//    		if(null == admin) {
//    			String ipAddr = CommonUtil.getIpAddr(request);
//    			String errMsg = String.format("[%s] - %s", ipAddr, "后台登录失败，用户名或密码错误！");
//				log.warn(errMsg);
//    			ret.setErrorCode(-202);
//    			ret.setErrorMsg("用户名或密码错误！");
//                return ret;
//    		}
//    		
//    		SessionUser su = new SessionUser();
//    		su.setUserId(admin.getId());
//    		su.setRole(admin.getRole().intValue());
//    		su.setNickname(admin.getNickName());
//    		
////    		model.addAttribute(IAppConst.SESSION_ADMIN_NAME, su);
////    		session.setAttribute(IAppConst.SESSION_ADMIN_NAME, su);
//    		
//    		WebUtils.setSessionAttribute(request, IAppConst.SESSION_ADMIN_NAME, su);
//    		
//    		ret.setErrorCode(0);
//    		ret.setErrorMsg("登录成功!");
//    		ret.setData(admin);
//    		
//            return ret;
//    	} catch (Exception e) {
//        	log.error(e.getMessage(), e);
//            // 身份验证失败
//        	ret.setErrorCode(0);
//    		ret.setErrorMsg("登录失败!");
//            return ret;
//        }
//    }
    
//    @RequestMapping(value="/auth/main", method=RequestMethod.GET)
//	public String mainHome(@ModelAttribute(IAppConst.SESSION_ADMIN_NAME) SessionUser admin) {
//		return "main";
//	}
    
    @RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:../admin/login.html";
    }
    
}
