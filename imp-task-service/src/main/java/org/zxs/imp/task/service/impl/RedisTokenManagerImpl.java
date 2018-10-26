package org.zxs.imp.task.service.impl;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.consts.IAppConst;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.service.interf.ITokenManager;

import com.alibaba.fastjson.JSON;

@Service
public class RedisTokenManagerImpl implements ITokenManager<AppUser> {
	private static final Logger log = LoggerFactory.getLogger(ITokenManager.class);
	
	private final static String KEY_PRE = "it_";
	
	@Resource
	private StringRedisTemplate strRedis;

	@Override
	public String createToken(AppUser user){
		String originToken = user.getToken();
		if(null == originToken || originToken.isEmpty()) {
			Integer userId = user.getUserId();
			// 遍历redis
			Set<String> keySet = strRedis.keys(KEY_PRE + "*");
			if(!keySet.isEmpty()) {
				for(String redisKey : keySet) {
					String redisValue = strRedis.boundValueOps(redisKey).get();
					if(redisValue.contains(userId + "")) { // 用户token已存在
						AppUser tokenUser = JSON.parseObject(strRedis.boundValueOps(redisKey).get(), AppUser.class);
						String token = tokenUser.getToken();
						log.info("登录用户{}的token{}已存在!", user.getUsername(), token);	
						return token;
					}
				}
			}
		}
		
		AppUser tokenUser = JSON.parseObject(strRedis.boundValueOps(KEY_PRE + originToken).get(), AppUser.class);
		if(tokenUser == null || tokenUser.getToken() == null) { // 创建token
			log.info("用户{}的token{}不存在或已失效，开始创建新token!", user.getUsername(),originToken);
			// 使用uuid作为源token
			String token = UUID.randomUUID().toString().replace("-", "");
			user.setToken(token);
			// 存储到redis并设置过期时间
			strRedis.boundValueOps(KEY_PRE + token).set(JSON.toJSONString(user), IAppConst.TOKEN_EXPIRES_DAYS, TimeUnit.DAYS);
			return token;
		}
		log.info("用户{}的token已存在!", user.getUsername());	
		return originToken;
	}

	@Override
	public boolean checkToken(String token){
		AppUser user = getTokenObject(token);		
		if (user == null) {
			log.info("redis中不存在key为{}的token!", token);
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		strRedis.boundValueOps(KEY_PRE + token).expire(IAppConst.TOKEN_EXPIRES_DAYS, TimeUnit.HOURS);
		return true;
	}

	@Override
	public AppUser getTokenObject(String token){
		String userStr = strRedis.boundValueOps(KEY_PRE + token).get();
		if(null != userStr && !userStr.isEmpty())
			return JSON.parseObject(userStr, AppUser.class);
		return null;
	}

	@Override
	public void deleteToken(String token){
		strRedis.delete(KEY_PRE + token);
	}

}
