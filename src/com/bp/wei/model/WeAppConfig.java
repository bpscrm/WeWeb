package com.bp.wei.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("weAppConfig")
public class WeAppConfig {
	
	//@Value("${appid}")
	private String appId;
	
	//@Value("${appsecret}")
	private String appSecret;
	
	//@Value("${token}")
	private String token;
	
	//@Value("${accesstoken}")
	private String accessToken;
	
	//@Value("${expiredin}")
	private long expiredIn;
	
	//@Value("${refreshin}")
	private int refreshIn;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiredIn() {
		return expiredIn;
	}

	public void setExpiredIn(long expiredIn) {
		this.expiredIn = expiredIn;
	}

	public int getRefreshIn() {
		return refreshIn;
	}

	public void setRefreshIn(int refreshIn) {
		this.refreshIn = refreshIn;
	}

	@Override
	public String toString() {
		return "WeAPPConfig [appId=" + appId + ", appSecret=" + appSecret + ", token=" + token + ", accessToken="
				+ accessToken + ", expiredIn=" + expiredIn + ", refreshIn=" + refreshIn + "]";
	}
	
}
