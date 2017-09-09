package com.bp.wei.util;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.WeAppConfig;
@Component
public class ConfigUtil {
	
	public static Logger log = LoggerFactory.getLogger(ConfigUtil.class);	
	
	@Autowired
	private WeAppConfig config;
	
	private static ConfigUtil factory;
	
	@PostConstruct
	public void init(){
		factory = this;
		factory.config = this.config;
	}
	
	//read local cached access token
	public static AccessToken getCachedAccessToken(){
		
		AccessToken accessToken = new AccessToken();
		long expiredTime = factory.config.getExpiredIn();
		
		if(System.currentTimeMillis() < expiredTime){
			accessToken.setToken(factory.config.getAccessToken());
			accessToken.setExpiresIn(factory.config.getExpiredIn());
			return accessToken;
		}
		
		log.info("Local cached access token expired and get it from Wechat.");
		accessToken = WeUtil.getAccessToken();
		updateCachedAccessToken(accessToken.getToken(), accessToken.getExpiresIn());		
		return accessToken;
	}
	
	public static synchronized void updateCachedAccessToken(String token, long expiredIn){		
		factory.config.setAccessToken(token);
		factory.config.setExpiredIn(expiredIn);
	}
	
	public static int tokenRefreshIn(){
		return factory.config.getRefreshIn();
	}
}
