package org.zxs.imp.task.controller.aop;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;

import com.alibaba.fastjson.JSON;

@Component
@Aspect
public class ControllerLogAspect {
	private final static Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);  
	  
    private String requestPath = null ; // 请求地址  
    private String userName = null ; // 用户名  
    private long startTimeMillis = 0; // 开始时间  
  
    /** 
     *  
     * @Title：doAfterInServiceLayer 
     * @Description: 方法调用后触发  
     *  记录结束时间 
     * @author shaojian.yu  
     * @date 2014年11月2日 下午4:46:21 
     * @param joinPoint 
     */  
    @AfterReturning(value="execution(* org.zxs.imp.task.controller..*Controller.*(..))", argNames="rtv", returning="rtv")  
    public void doAfterInControllerLayer(JoinPoint joinPoint, Object rtv) {  
    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();
        HttpSession session = request.getSession();
    	// 从session中获取用户信息  
        AppUser appUser = (AppUser) session.getAttribute(IAppConst.SESSION_USER_NAME);  
        if(appUser != null){  
            userName = appUser.getUsername();  
        }else{  
            userName = "无" ;  
        } 
        
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间  
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTimeMillis);  
        logger.info("\n 用户：{}; 地址：{}; 结束时间：{}; 处理时长：{}ms; 请求参数：{};\n 处理结果：{}", userName, requestPath
                , optTime, endTimeMillis - startTimeMillis, JSON.toJSONString(joinPoint.getArgs()), JSON.toJSONString(rtv));
        
        // 记录操作日志
        
        
    }  
  
    /** 
     *  
     * @Title：doAround 
     * @Description: 环绕触发  
     * @author shaojian.yu  
     * @date 2014年11月3日 下午1:58:45 
     * @param pjp 
     * @return 
     * @throws Throwable 
     */  
    @Around("execution(* org.zxs.imp.task.controller..*Controller.*(..))")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        /** 
         * 1.获取request信息 
         * 2.根据request获取session 
         * 3.从session中取出登录用户信息 
         */  
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();
        // 获取请求地址  
        requestPath = request.getRequestURI();  
          
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        return pjp.proceed();  // result的值就是被拦截方法的返回值  
    } 
    
    /** 
     *  
     * @Title：doBeforeInServiceLayer 
     * @Description: 方法调用前触发  
     *  记录开始时间  
     * @author shaojian.yu  
     * @date 2014年11月2日 下午4:45:53 
     * @param joinPoint 
     */  
    @Before(value="execution(* org.zxs.imp.task.controller..*Controller.*(..))")  
    public void doBeforeInControllerLayer(JoinPoint joinPoint) { 
    	startTimeMillis = System.currentTimeMillis(); 
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(startTimeMillis);
        logger.info("\n 地址：{}; 开始时间：{}; 请求参数：{};", requestPath, optTime, JSON.toJSONString(joinPoint.getArgs()));  
    } 
    
    @AfterThrowing(value="execution(* org.zxs.imp.task.controller..*.*(..))", throwing="ex")  
    public void doAfterThrowing(Throwable ex) {
    	logger.error(ex.getMessage(), ex);
    } 
  
}
