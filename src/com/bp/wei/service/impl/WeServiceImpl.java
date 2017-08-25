package com.bp.wei.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.Oauth2AccessToken;
import com.bp.wei.model.User;
import com.bp.wei.model.message.response.TextMessage;
import com.bp.wei.service.UserService;
import com.bp.wei.service.WeService;
import com.bp.wei.util.MessageUtil;
import com.bp.wei.util.WeUtil;

@Service
public class WeServiceImpl implements WeService {
	
	private static Logger log = LoggerFactory.getLogger(WeServiceImpl.class);
	
	private final static String DNBX_TOKEN = "bpscrmtoken";
	
	@Autowired
	UserService userSrv;
	
	@Override
	public String process(Map<String,String> requestMap) {
		
		String eventType = requestMap.get("Event");
		//关注者OpenID
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String respXML = null;
		
		log.info("Processing event :" + eventType + ", from user openid:" + fromUserName);
		AccessToken accessToken = WeUtil.getAccessToken();
		User user = this.userSrv.getUser(accessToken.getToken(), fromUserName);
		if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equalsIgnoreCase(eventType)){			
			TextMessage text = new TextMessage();
			if(user != null){				
	            text.setContent("欢迎关注，" + user.getNickname());
	            log.info("Subscribe from user(nickname):" + user.getNickname());
	            text.setToUserName(fromUserName);
	            text.setFromUserName(toUserName);     	            
	            
			}else{
				text.setContent("获取用户信息失败");
			}
			text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			respXML = MessageUtil.messageToXml(text);
        } 
        // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
        else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
        	respXML = "";         
        }else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
        	
        }
		
		log.info("Message response: " + respXML);
		
		return respXML;

	}

	@Override
	public boolean valid(String signature, String timestamp, String nonce) {
		String[] params = new String[] { DNBX_TOKEN, timestamp, nonce }; 
		Arrays.sort(params);  
		String clearText = params[0] + params[1] + params[2];
		String tempSign = null;
		try {
			tempSign = new String(Hex.encodeHex(MessageDigest.getInstance("SHA-1").digest(clearText.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return tempSign != null && signature.equals(tempSign);
	}	

}
