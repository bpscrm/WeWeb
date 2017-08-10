package com.bp.wei.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
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

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.bp.wei.model.AccessToken;
import com.bp.wei.service.WeService;
import com.bp.wei.util.MessageUtil;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
/**
 * 
 * @author liyanc
 * @see WeChat interfaces access 
 */

@Controller
@RequestMapping("wechat")
public class WeController {
	private static Logger log = LoggerFactory.getLogger(WeController.class);
	
	private final String USER_AGENT = "Mozilla/5.0";
	private AccessToken accessToken = WeUtil.getAccessToken();
	
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
        
        System.out.println( "[WeController][validate]");
        PrintWriter out = response.getWriter();
        if(weService.valid(signature, timestamp, nonce)){
        	log.info("Connect to WeChat server successfully.");
        	System.out.println( "if [WeController][validate]");
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

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df_event = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        String formatted_today = df.format(new Date());
        String formatted_today_event = df_event.format(new Date());
		System.out.println(formatted_today); //2016-11-16
		System.out.println(formatted_today_event); //2016-11-16-03:56:00
		
		System.out.println(request.getQueryString());
		System.out.println(request.getAttributeNames());
		System.out.println(request.getParameterMap());
		String ACCESS_FILENAME = "c:\\10\\access.log_" + formatted_today;

		BufferedWriter bw = null;
		FileWriter fw = null;


		fw = new FileWriter(ACCESS_FILENAME, true);
		bw = new BufferedWriter(fw);
		String ws_access_rec;
		
		System.out.println( "[WeController][process]accessToken " + accessToken.getToken());
        System.out.println( "[WeController][process]request " + request);
        System.out.println( "[WeController][process]" + signature+"' '"+timestamp);
        PrintWriter out = response.getWriter(); 
        if(weService.valid(signature, timestamp, nonce))
        {
        	Map<String,String> requestMap = MessageUtil.parseXML(request);
        	//Get user info
        	String user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken.getToken()+"&openid="+requestMap.get("FromUserName");
        			
        	System.out.println("user_url " + user_url); 
        	
        	URL user_obj = new URL(user_url);
    		HttpURLConnection user_con = (HttpURLConnection) user_obj.openConnection();
    		
    		//user_con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36");
    		user_con.setRequestProperty("Accept-Charset", "UTF-8");
    		user_con.setRequestMethod("GET");
    		

    		//add request header
    		user_con.setRequestProperty("User-Agent", USER_AGENT);

    		int user_responseCode = user_con.getResponseCode();
    		System.out.println("\nSending 'GET' request to URL : " + user_url);
    		System.out.println("Response Code : " + user_responseCode);

    		Charset charset = Charset.forName("UTF8");
    		BufferedReader user_in = new BufferedReader(
    		        new InputStreamReader(user_con.getInputStream(), charset));
    		String user_inputLine;
    		StringBuffer user_response1 = new StringBuffer();
    		String user_trim_response;

    		while ((user_inputLine = user_in.readLine()) != null) {
    			user_response1.append(user_inputLine);
    		}
    		user_in.close();        	
        	
    		System.out.println( "[WeController][process]USER_INFO " + user_response1.toString());
    		
        	System.out.println( "[WeController][process]parsexml " + request);
        	
        	System.out.println( "[WeController][process]before process " + requestMap);
        	System.out.println( "[WeController][process]longtitude " + requestMap.get("Latitude"));
        	//requestMap.put("EventKey", "http://121.122.87.90/mavenapp/index.zul?WECHATID=1234567890&OPENID=9876543210");
        	//System.out.println( "[WeController][process]before process 1 " + requestMap);
        	String respMsg = weService.process(requestMap);
        	System.out.println( "[WeController][process][respmsg]" + respMsg);

        	String location_name_url = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+requestMap.get("Latitude")+","+requestMap.get("Longitude")+"&sensor=true";
        	System.out.println("location_url " + location_name_url); 
        	
        	URL obj = new URL(location_name_url);
    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    		
    		con.setRequestProperty("Accept-Charset", "UTF-8");
    		con.setRequestMethod("GET");

    		//add request header
    		con.setRequestProperty("User-Agent", USER_AGENT);

    		int responseCode = con.getResponseCode();
    		System.out.println("\nSending 'GET' request to URL : " + location_name_url);
    		System.out.println("Response Code : " + responseCode);

    		BufferedReader in = new BufferedReader(
    		        new InputStreamReader(con.getInputStream(), "UTF-8"));
    		String inputLine;
    		StringBuffer response1 = new StringBuffer();
    		String trim_response;

    		while ((inputLine = in.readLine()) != null) {
    			response1.append(inputLine);
    		}
    		in.close();

    		trim_response = response1.toString();
    		trim_response = trim_response.trim().replaceAll(" +", " ") + "\n";
    		//print result
    		System.out.println(trim_response);
    		
        	ws_access_rec = "OPENID="+requestMap.get("FromUserName") + "=" + formatted_today_event+ "==" + requestMap+" rmt addr {"+request.getRemoteAddr()+"," + request.getRemoteHost() + "," + request.getUserPrincipal() + ","+ request.getRemoteUser() +"}\n";
        	ws_access_rec += "USER_INFO:" + user_response1.toString();
        	ws_access_rec += "\nGEO=" +trim_response;
        	
        	bw.write(ws_access_rec);

        	out.write(respMsg);
        }
        out.close();
        bw.close();
        out = null;        
	}
}
