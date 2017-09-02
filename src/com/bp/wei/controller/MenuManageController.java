/**
 * 
 */
package com.bp.wei.controller;

import java.io.IOException;

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

import com.bp.wei.model.User;
import com.bp.wei.service.MenuManager;
import com.bp.wei.service.UserService;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping()
public class MenuManageController {
	public static Logger log = LoggerFactory.getLogger(MenuManageController.class);
	
	@Autowired
	private MenuManager menuMgt;
	
	@Autowired
	private UserService userSrv;
	
	//////////////////////////////////////////////////////////////////////
	public static void main(String[] args){
		int i =0;
		System.out.println( "[MenuMangerController][main]");
		System.out.println("[{\"code\":\"" + i  + "\"}]");
	}
	
	//////////////////////////////////////////////////////////////////////for 测试页面
	//测试主页
	@RequestMapping(value="TestIndex", method = RequestMethod.GET)
	public String redirectTestIndex(){
		
		System.out.println( "[MenuMangerController][TestIndex]");
		return "indextest";
	}
	
	//打开你问我答
	@RequestMapping(value="indexqaonline", method = RequestMethod.GET)
	public String redirectintoQAOnlineIndex(){		
		
		System.out.println( "[MenuMangerController][redirectintoQAOnlineIndex]");
		return "indexqaonline";
	}	
	
	//打开会员管理
	@RequestMapping(value="indexmember", method = RequestMethod.GET)
	public String redirectintoMemberIndex(){		
		
		System.out.println( "[MenuMangerController][redirectintoMemberIndex]");
		return "indexmember";
	}	
	
	//打开营销活动
	@RequestMapping(value="indexmarketing", method = RequestMethod.GET)
	public String redirectintoMarketingIndex(){		
		
		System.out.println( "[MenuMangerController][redirectintoMarketingIndex]");
		return "indexmarketing";
	}		
	
	//////////////////////////////////////////////////////////////////////for 设定微信服务号菜单
	@RequestMapping(value="menu", method = RequestMethod.GET)
	public String redirectMenu(){
		
		System.out.println( "[MenuMangerController][redirectMenu]");
		return "menu_config";
	}
	
	@RequestMapping(value="getMenu", method = RequestMethod.GET)
	public @ResponseBody JSONObject getMenu(){
		JSONObject menu = null;
		menu = menuMgt.getMenu();
		System.out.println( "[MenuMangerController][getMenu]");
		log.info("Fetched WeChat menu: " + menu.toString());
		return menu;
	}
	
	@RequestMapping(value="setMenu", method = RequestMethod.POST)
	public @ResponseBody int setMenu(){
		//log.debug("Start updating the WeChat menu " + menu.toString());

		int result = menuMgt.createMenu(null);
		
		System.out.println( "[MenuMangerController][setMenu]");
		log.debug("WeChat menu updated " + (result == 0 ? "successfully":"failed"));
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////for 英语故事
	@RequestMapping(value="ENStroryIndex", method = RequestMethod.GET)
	public String redirectENStroryIndex(){
		
		System.out.println( "[MenuMangerController][redirectENStroryIndex]");
		return "indexenstory";
	}
	
	//////////////////////////////////////////////////////////////////////for 你问我答
	@RequestMapping(value="QAOnlineIndex", method = RequestMethod.GET)
	public String redirectQAOnlineIndex(){
		
		System.out.println( "[MenuMangerController][redirectQAOnlineIndex]");
		return "indexqaonline";
	}
	
	@RequestMapping(value="redirectQAOnline", method = RequestMethod.GET)
	public void redirectQAOnlineMgmt(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		String url = WeUtil.getRedirectUrl();
		url = url.replace("REDIRECT_URI", "http://www.wecarecrm.cn/EnglishCenterZHH/oauthQAOnline");
		log.debug("Redirect to: " + url);
		response.sendRedirect(url);
	}
	
	@RequestMapping(value = "oauthQAOnline", method = RequestMethod.GET)
	public void authAndRedirectQAOnline(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        log.info("Enter redirectQAOnline and got the code as:" + code + ", state:" + state);

        if(!"authdeny".equals(code)){
        	User user = userSrv.getUser(code);
        	
        	if(user == null){
        		log.error("Failed to get User Info from wechat!");
        	}else{
        		log.info("Got user info:" + user.toString());
        		String url = getRedirectQAOnlineUrl(user);
        		response.sendRedirect(url);
        	}
        }		
	}
	
	private String getRedirectQAOnlineUrl(User user){
		StringBuffer sb = new StringBuffer("http://www.wecarecrm.cn/EnglishCenterZHH/QAOnlineIndex");
		sb.append("?");
		if(user.getOpenId() != null){
			sb.append("openid=" + user.getOpenId());
			sb.append("&");
		}
		if(user.getNickname()!=null){
			sb.append("nickname="+user.getNickname());
		}
		return sb.toString();
	}
	
	//////////////////////////////////////////////////////////////////////for 会员管理
	@RequestMapping(value="MemberIndex", method = RequestMethod.GET)
	public String redirectMemberIndex(){
		
		System.out.println( "[MenuMangerController][redirectMemberIndex]");
		return "indexmember";
	}
	
	@RequestMapping(value="redirectMember", method = RequestMethod.GET)
	public void redirectMemberMgmt(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		String url = WeUtil.getRedirectUrl();
		url = url.replace("REDIRECT_URI", "http://www.wecarecrm.cn/EnglishCenterZHH/oauth");
		log.debug("Redirect to: " + url);
		response.sendRedirect(url);
	}
	
	@RequestMapping(value = "oauth", method = RequestMethod.GET)
	public void authAndRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        log.info("Enter redirectMember and got the code as:" + code + ", state:" + state);

        if(!"authdeny".equals(code)){
        	User user = userSrv.getUser(code);
        	
        	if(user == null){
        		log.error("Failed to get User Info from wechat!");
        	}else{
        		log.info("Got user info:" + user.toString());
        		String url = getRedirectUrl(user);
        		response.sendRedirect(url);
        	}
        }		
	}
	
	private String getRedirectUrl(User user){
		StringBuffer sb = new StringBuffer("http://www.wecarecrm.cn/EnglishCenterZHH/MemberIndex");
		sb.append("?");
		if(user.getOpenId() != null){
			sb.append("openid=" + user.getOpenId());
			sb.append("&");
		}
		if(user.getNickname()!=null){
			sb.append("nickname="+user.getNickname());
		}
		return sb.toString();
	}
	
	//////////////////////////////////////////////////////////////////////for 营销活动
	@RequestMapping(value="MarketingIndex", method = RequestMethod.GET)
	public String redirectMarketingIndex(){
		
		System.out.println( "[MenuMangerController][MarketingIndex]");
		return "indexmarketing";
	}
	
	@RequestMapping(value="redirectMarketing", method = RequestMethod.GET)
	public void redirectMarketingMgmt(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		String url = WeUtil.getRedirectUrl();
		url = url.replace("REDIRECT_URI", "http://www.wecarecrm.cn/EnglishCenterZHH/oauthMarketing");
		log.debug("Redirect to: " + url);
		response.sendRedirect(url);
	}
	
	@RequestMapping(value = "oauthMarketing", method = RequestMethod.GET)
	public void authAndRedirectMarketing(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        log.info("Enter redirectMarketing and got the code as:" + code + ", state:" + state);

        if(!"authdeny".equals(code)){
        	User user = userSrv.getUser(code);
        	
        	if(user == null){
        		log.error("Failed to get User Info from wechat!");
        	}else{
        		log.info("Got user info:" + user.toString());
        		String url = getRedirectMarketingUrl(user);
        		response.sendRedirect(url);
        	}
        }		
	}
	
	private String getRedirectMarketingUrl(User user){
		StringBuffer sb = new StringBuffer("http://www.wecarecrm.cn/EnglishCenterZHH/MarketingIndex");
		sb.append("?");
		if(user.getOpenId() != null){
			sb.append("openid=" + user.getOpenId());
			sb.append("&");
		}
		if(user.getNickname()!=null){
			sb.append("nickname="+user.getNickname());
		}
		return sb.toString();
	}
	
	//////////////////////////////////////////////////////////////////////for 联系我们
	@RequestMapping(value="ContactUSIndex", method = RequestMethod.GET)
	public String redirectContactUSIndex(){
		
		System.out.println( "[MenuMangerController][ContactUSIndex]");
		return "indexcontactus";
	}
	
	@RequestMapping(value="redirectContactUS", method = RequestMethod.GET)
	public void redirectContactUS(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		String url = WeUtil.getRedirectUrl();
		url = url.replace("REDIRECT_URI", "http://www.wecarecrm.cn/EnglishCenterZHH/oauthContactUS");
		log.debug("Redirect to: " + url);
		response.sendRedirect(url);
	}
	
	@RequestMapping(value = "oauthContactUS", method = RequestMethod.GET)
	public void authAndRedirectContactUS(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException{
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        log.info("Enter redirectContactUS and got the code as:" + code + ", state:" + state);

        if(!"authdeny".equals(code)){
        	User user = userSrv.getUser(code);
        	
        	if(user == null){
        		log.error("Failed to get User Info from wechat!");
        	}else{
        		log.info("Got user info:" + user.toString());
        		String url = getRedirectContactUSUrl(user);
        		response.sendRedirect(url);
        	}
        }		
	}
	
	private String getRedirectContactUSUrl(User user){
		StringBuffer sb = new StringBuffer("http://www.wecarecrm.cn/EnglishCenterZHH/ContactUSIndex");
		sb.append("?");
		if(user.getOpenId() != null){
			sb.append("openid=" + user.getOpenId());
			sb.append("&");
		}
		if(user.getNickname()!=null){
			sb.append("nickname="+user.getNickname());
		}
		return sb.toString();
	}
	
}
