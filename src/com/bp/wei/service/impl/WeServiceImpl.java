package com.bp.wei.service.impl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.bp.wei.model.message.response.Article;
import com.bp.wei.model.message.response.IMessage;
import com.bp.wei.model.message.response.NewsMessage;
import com.bp.wei.model.message.response.TextMessage;
import com.bp.wei.service.WeService;
import com.bp.wei.util.MessageUtil;
import com.bp.wei.model.message.response.PicNewsMessage;

import java.util.List;

@Service
public class WeServiceImpl implements WeService {
	
	private static Logger log = LoggerFactory.getLogger(WeServiceImpl.class);
	
	private final static String DNBX_TOKEN = "bpscrmtoken";
	
	@SuppressWarnings("unused")
	@Override
	public String process(Map<String,String> requestMap) {
		String eventType = requestMap.get("Event");
		String messageType = requestMap.get("MsgType");
		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String respMsg = null;
		
		System.out.println( "[WeServiceImpl][process] " + eventType);
		System.out.println( "[WeServiceImpl][process]fromusername " + fromUserName);
		System.out.println( "[WeServiceImpl][process]toUserName " + toUserName);
		if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equalsIgnoreCase(eventType)){
			TextMessage text = new TextMessage();
            text.setContent("欢迎关注，xxx");
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            
            respMsg = MessageUtil.messageToXml((IMessage) text);
        } 
		else if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equalsIgnoreCase(messageType)){
			TextMessage text = new TextMessage();
			
			String org_message = requestMap.get("Content");
            text.setContent("FxxK you " + org_message);
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            
            respMsg = MessageUtil.textMessageToXml((TextMessage) text);
        } 
		else if(MessageUtil.EVENT_TYPE_CLICK.equalsIgnoreCase(eventType))
		{			
			/*
			TextMessage text = new TextMessage();
            text.setContent("欢迎关注 CLICK，xxx");
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            
            respMsg = MessageUtil.textMessageToXml((TextMessage) text);
            */
			NewsMessage newsMessage = new NewsMessage();  
            newsMessage.setToUserName(fromUserName);  
            newsMessage.setFromUserName(toUserName);  
            newsMessage.setCreateTime(new Date().getTime());  
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
            //newsMessage.setFuncFlag(0); 
            
            Article article = new Article();  
            article.setTitle("欢迎关注 CLICK，xxx");  
            article.setDescription("掃一掃");  
            article.setPicUrl("http://127.0.0.1/project/images/qrcode_for_gh_252ab00a75c6_1280.jpg");  
            //article.setUrl("http://blog.csdn.net/lyq8479");  
            
            List<Article> articleList = new ArrayList<Article>(); 
			articleList.add(article);  
            // 设置图文消息个数  
			newsMessage.setArticleCount(articleList.size());  
            // 设置图文消息包含的图文集合  
            newsMessage.setArticles(articleList);  
            // 将图文消息对象转换成xml字符串  
            respMsg = MessageUtil.newsMessageToXml(newsMessage);  
            
            //File file = new File("c:\\10\\display_qrcode.html");
            //try {
                //Files.write(file.toPath(), content.getBytes());
            //    java.awt.Desktop.getDesktop().browse(file.toURI());
            //} catch (IOException e) {
                // TODO Auto-generated catch block
            //}
        } 
        // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
        else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
        	// 取消订阅         
        }
        else
        {
    		TextMessage text = new TextMessage();
            text.setContent(eventType);
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            
            respMsg = MessageUtil.textMessageToXml((TextMessage) text);
        }
		
		return respMsg;

	}

	@Override
	public boolean valid(String signature, String timestamp, String nonce) {
		String[] params = new String[] { DNBX_TOKEN, timestamp, nonce }; 
		Arrays.sort(params);  
		String clearText = params[0] + params[1] + params[2];
		String tempSign = null;
		
		System.out.println( "[WeServiceImpl][valid] " + signature + "' '"+clearText);
		try {
			tempSign = new String(Hex.encodeHex(MessageDigest.getInstance("SHA-1").digest(clearText.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return tempSign != null && signature.equals(tempSign);
	}

}
