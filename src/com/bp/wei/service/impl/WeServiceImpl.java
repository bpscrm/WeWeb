package com.bp.wei.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.dao.FollowerinfoDao;
import com.bp.wei.model.AccessToken;
import com.bp.wei.model.User;
import com.bp.wei.model.message.response.TextMessage;
import com.bp.wei.service.UserService;
import com.bp.wei.service.WeService;
import com.bp.wei.util.ConfigUtil;
import com.bp.wei.util.MessageUtil;
import com.bp.wei.util.WeUtil;

@Service
public class WeServiceImpl implements WeService {
	
	private static Logger log = LoggerFactory.getLogger(WeServiceImpl.class);
	
	private final static String DNBX_TOKEN = "bpscrmtoken";
	
	@Autowired
	UserService userSrv;
	
	@Resource
	private FollowerinfoDao fldao;
	
	@Override
	public String process(Map<String,String> requestMap) {
		
		String eventType = requestMap.get("Event");
		//关注者OpenID
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String eventKey = requestMap.get("EventKey");
		String respXML = null;
		
		Iterator<String> itr = requestMap.keySet().iterator();
    	while(itr.hasNext()){
    		String key = itr.next();
    		log.debug("key=" + key + ", value=" + requestMap.get(key));
    	}
    	
		log.info("Processing event :" + eventType + ", from user openid:" + fromUserName);
		
		if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equalsIgnoreCase(eventType)){	
			AccessToken accessToken = ConfigUtil.getCachedAccessToken();//WeUtil.getAccessToken();
			User user = this.userSrv.getUser(accessToken.getToken(), fromUserName);
			TextMessage text = new TextMessage();
			String Nickname = "粉丝昵称";
			if(user != null){				
	            text.setContent("欢迎关注，" + user.getNickname());
	            log.info("Subscribe from user(nickname):" + user.getNickname());
	            text.setToUserName(fromUserName);
	            text.setFromUserName(toUserName);  
	            
	            Nickname = user.getNickname();
	            
			}else{
				text.setContent("获取用户信息失败");
				
				Nickname = "获取昵称失败";
			}
			text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			respXML = MessageUtil.messageToXml(text);
			
			if(eventKey != null && eventKey.startsWith("qrscene_")){
				//如果有场景值，可获得转发者的openid,目前暂时只有面对面，其他场景后续需要添加
				String fromOpenId = eventKey.substring(8);
				log.debug("Got the follwer's open id:" + fromOpenId);
			}
			
			//关注后处理CRM资料
			Followerinfo follow = new Followerinfo();
			follow.setWechatUserid(fromUserName);  //open id
			follow.setName(Nickname);			   //昵称
			String FollowerID = fldao.selectByPrimaryOpenid(fromUserName);
			
			if(FollowerID != null && FollowerID.length() > 0){
				//更新已有粉丝资料
				follow.setFollowType("L2");
				follow.setId(FollowerID);
				int result = fldao.updateByFollowerID(follow);
				
			} else {
				//新增粉丝资料
				follow.setFollowType("L1");
				int result = fldao.insert(follow);
				if(result == 1){
					//return follow.getId();
				} else {
					//return "null";
				}				
			}			
						
        } 
        // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
        else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
        	respXML = "";
        	//TO-DO
        }else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){        	
        	
        	if (eventKey.equals("1_1")) { 
            	TextMessage text = new TextMessage();
            	
            	text.setContent("中心从珠海芝麻街购买课程，取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息，取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息");
	            text.setToUserName(fromUserName);
	            text.setFromUserName(toUserName);
    			text.setCreateTime(new Date().getTime());
                text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    			respXML = MessageUtil.messageToXml(text);
        	}        	

        }else if(eventType.equals(MessageUtil.EVENT_TYPE_VIEW)){
        	String url = requestMap.get("EventKey");
        	log.debug("Got url callback request:" + url);
        	respXML = "";
        	//TO-DO
        }else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)){        	
        	respXML = "";
        	//TO-DO
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
