package com.bp.wei.service;

import com.bp.wei.model.User;

public interface UserService {
	
	public static String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	
	public User getUser(String accessToken, String openId);
	
	public User getUser(String code);

}
