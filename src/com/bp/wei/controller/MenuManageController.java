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
	
	//////////////////////////////////////////////////////////////////////for 你问我答
	@RequestMapping(value="QAOnlineIndex", method = RequestMethod.GET)
	public String redirectQAOnlineIndex(){
		
		System.out.println( "[MenuMangerController][redirectQAOnlineIndex]");
		return "indexqaonline";
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
		url = url.replace("REDIRECT_URI", WeUtil.redirect_url);
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
		StringBuffer sb = new StringBuffer("http://www.wecarecrm.cn/MemberMgmt");
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
	
	//////////////////////////////////////////////////////////////////////
	public static void main(String[] args){
		int i =0;
		System.out.println( "[MenuMangerController][main]");
		System.out.println("[{\"code\":\"" + i  + "\"}]");
	}
}
