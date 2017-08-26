package com.bp.wei.service;

import com.bp.wei.model.User;

public interface UserService {
	
	public static String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	
	public static String auth_requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	public User getUser(String accessToken, String openId);
	
	public User getUser(String code);

}
