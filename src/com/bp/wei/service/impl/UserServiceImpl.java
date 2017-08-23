package com.bp.wei.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.model.User;
import com.bp.wei.service.UserService;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {
	
	public static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User getUser(String accessToken, String openId) {
		String requestUrl = UserService.requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		
		JSONObject respJson = WeUtil.httpRequest(requestUrl, "GET", null);
		
		if(respJson == null){
			log.error("Cannot get user info for OPENID: " + openId);
			return null;
		}
		
		User user = new User();
		user.setOpenId(openId);
		user.setNickname(respJson.getString("nickname"));
		user.setCountry(respJson.getString("country"));
		user.setProvince(respJson.getString("province"));
		user.setCity(respJson.getString("city"));
		user.setSex(respJson.getInt("sex"));
		user.setSubscribe(respJson.getInt("subscribe"));
		user.setSubscribeTime(respJson.getString("subscribe_time"));
		user.setLanguage(respJson.getString("language"));
		user.setHeadImgUrl(respJson.getString("headimgurl"));
		
		return user;
	}

}
