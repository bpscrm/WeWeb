package com.bp.wei.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.WeAppConfig;
import com.bp.wei.util.ConfigUtil;
import com.bp.wei.util.WeUtil;

@Component
public class Task {
	public static Logger log = LoggerFactory.getLogger(Task.class);
	public static int refreshInterval = 3600000;
	
	/*@Autowired
	WeAppConfig config;*/
	
	@Scheduled(fixedRate = 3600000)
	public void updateAccessToken(){
		log.info("Scheduled job to get the access token from Wechat.");
		AccessToken accessToken = WeUtil.getAccessToken();
		if(accessToken == null){
			log.error("Failed to get access token from Wechat.");
			return;
		}
		log.info("Got renewed access token from Wechat:" + accessToken.toString());
		
		long now = System.currentTimeMillis();
		int refreshIn = ConfigUtil.tokenRefreshIn();
		log.debug("refreshin in config file is:" + refreshIn);
		refreshIn = refreshIn > 0 ? refreshIn : refreshInterval;
		String token = accessToken.getToken();		
		ConfigUtil.updateCachedAccessToken(token, now + refreshIn*1000);		
	}

}
