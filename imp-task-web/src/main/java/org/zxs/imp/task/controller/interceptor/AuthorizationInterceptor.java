package org.zxs.imp.task.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zxs.imp.task.controller.annotation.Authorization;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.service.interf.ITokenManager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	
    @Resource
    private ITokenManager<AppUser> tokenManager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //如果方法注明了Authorization
        if (method.getAnnotation(Authorization.class) != null) {
        	
        	//从header中得到token
            String authorization = request.getHeader(IAppConst.AUTHORIZATION);
//            String authorization = request.getParameter(IAppConst.AUTHORIZATION);
            if(null != authorization && !authorization.isEmpty()) {
                
                //验证token
                if (!tokenManager.checkToken(authorization)) {
                	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                	log.warn("授权验证失败,验证串为:{}", authorization);
                    return false;
                }else {
                	//如果token验证成功，将token对应的用户id存在session中，便于之后注入
                    request.getSession().setAttribute(IAppConst.SESSION_USER_NAME, tokenManager.getTokenObject(authorization));
                	log.info("授权验证成功,验证串为:{}", authorization);
                }
            } else {
            	log.warn("授权验证失败,验证串为空!");
            	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }
        return true;
    }
}
