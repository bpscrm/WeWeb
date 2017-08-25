package com.bp.wei.model;

public class WeAPIConfig {
	
	private String appId;
	
	private String appSecret;
	
	private String token;

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

	@Override
	public String toString() {
		return "WeAPIConfig [appId=" + appId + ", appSecret=" + appSecret + ", token=" + token + "]";
	}	
	
}
