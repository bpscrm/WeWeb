package com.bp.wei.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.Oauth2AccessToken;
import com.bp.wei.model.User;
import com.bp.wei.service.UserService;
import com.bp.wei.util.ConfigUtil;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {
	
	public static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User getUser(String accessToken, String openId) {
		AccessToken token = ConfigUtil.getCachedAccessToken();//WeUtil.getAccessToken();
		String requestUrl = UserService.requestUrl.replace("ACCESS_TOKEN", token.getToken()).replace("OPENID", openId);
		
		JSONObject respJson = WeUtil.httpRequest(requestUrl, "GET", null);
		
		if(respJson == null || respJson.has("errcode")){
			log.error("Cannot get user info for OPENID: " + openId);
			return null;
		}
		log.debug("Fetched user info from wechat:" + respJson.toString());
		
		User user = this.setUser(openId, respJson);
		
		return user;
	}

	@Override
	public User getUser(String code) {
		
		User user = null;

		Oauth2AccessToken accessToken = WeUtil.getOauth2AccessToken(code);
		
		if(accessToken == null){
			log.error("Cannot get valid Oauth2 access token for code:" + code);
		}else if(accessToken.getAccessToken() == null){
			log.error("Failed to get valid access token for code:" + code);
		}else if(accessToken.getOpenId() == null){
			log.error("Failed to get openid from code:" + code);
		}else{
			String token = accessToken.getAccessToken();
			String openid = accessToken.getOpenId();

			user = this.getUser(token, openid);
		}
		return user;
	}
	
	
	private User setUser(String openId, JSONObject respJson){
		if(openId == null || respJson == null){
			return null;
		}
		User user = new User();
		
		user.setOpenId(openId);
		
		
		String nickName = respJson.getString("nickname");
		if(nickName != null){
			user.setNickname(nickName);
		}
		String country = respJson.getString("country");
		if(country != null){
			user.setCountry(country);
		}
		String province = respJson.getString("province");
		if(province != null){
			user.setProvince(province);
		}
		String city = respJson.getString("city");
		if(city != null){
			user.setCity(city);
		}
		int sex = respJson.getInt("sex");
		if(sex >= 0){
			user.setSex(sex);
		}
		int subscribe = respJson.getInt("subscribe");
		if(subscribe >=0 ){
			user.setSubscribe(subscribe);
		}
		String subscribeTime = respJson.getString("subscribe_time");
		if(subscribeTime != null){
			user.setSubscribeTime(subscribeTime);
		}
		String language = respJson.getString("language");
		if(language != null){
			user.setLanguage(language);
		}
		String headImgUrl = respJson.getString("headimgurl");
		if(headImgUrl != null){
			user.setHeadImgUrl(headImgUrl);
		}
		return user;
	}
}
