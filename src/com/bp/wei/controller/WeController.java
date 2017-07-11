package com.bp.wei.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bp.wei.service.WeService;
import com.bp.wei.util.MessageUtil;

/**
 * 
 * @author liyanc
 * @see WeChat interfaces access 
 */

@Controller
@RequestMapping("wechat")
public class WeController {
	private static Logger log = LoggerFactory.getLogger(WeController.class);
	
	@Autowired
	private WeService weService;
	/**
	 * Check if the request is from WeChat
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void validate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
        
        PrintWriter out = response.getWriter();
        if(weService.valid(signature, timestamp, nonce)){
        	log.info("Connect to WeChat server successfully.");
        	out.write(echostr); 
        }else{
        	log.info("Signature verification failed.");
        }
        out.close();
        out = null;        
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        String signature = request.getParameter("signature");  
        String timestamp = request.getParameter("timestamp");  
        String nonce = request.getParameter("nonce");  

        PrintWriter out = response.getWriter(); 
        if(weService.valid(signature, timestamp, nonce)){
        	Map<String,String> requestMap = MessageUtil.parseXML(request);
        	String respMsg = weService.process(requestMap);
        	out.write(respMsg);
        }
        out.close();
        out = null;        
	}
}
