/**
 * 
 */
package com.bp.wei.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bp.wei.model.Button;
import com.bp.wei.model.ComboButton;
import com.bp.wei.model.Menu;
import com.bp.wei.model.User;
import com.bp.wei.service.MenuManager;
import com.bp.wei.service.UserService;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author liyanc
 *
 */
@Controller
@RequestMapping()
public class MenuManageController {
	public static Logger log = LoggerFactory.getLogger(MenuManageController.class);
	
	@Autowired
	private MenuManager menuMgt;
	
	@Autowired
	private UserService userSrv;
	
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
	
//	/**
//	 * 
//	 * @param jmenu
//	 * @return
//	 * @see Temporary solution for mapping json menu to menu class, to be changed
//	 */
//	private Menu fromJSONObject(JSONObject jmenu){
//		Menu menu = new Menu();
////		ObjectMapper mapper = new ObjectMapper(); 
////		mapper.convertValue(jmenu, Menu.class);
//		JSONArray bnames = (JSONArray) jmenu.get("buttons");
//		JSONArray sbnames = (JSONArray) jmenu.get("subButtons");
//		int i = 0;		
//		List<ComboButton> buttons = new ArrayList<ComboButton>();
//		for(int a = 0; a < bnames.size(); a ++){
//			String bname = bnames.get(a).toString();
//			if(bname == null || "".equals(bname)){
//				continue;
//			}
//			ComboButton btn = new ComboButton();
//			btn.setName(bname);		
//
//			List<Button> subButtons = new ArrayList<Button>();
//			
//			for(int b = i,c = 0; c < 5; b ++, c ++){
//				String sbname = sbnames.get(b).toString();
//				if(sbname == null || "".equals(sbname)){
//					i ++;
//					continue;
//				}
//				Button sbtn = new Button();
//				sbtn.setName(sbname);
//				subButtons.add(sbtn);
//				i ++;
//			}
//			Button[] sbtns = subButtonsToArray(subButtons);
//			if(sbtns != null && sbtns.length > 0){
//				btn.setSub_button(sbtns);
//			}
//
//			buttons.add(btn);
//		}
//		ComboButton[] btns = buttonsToArray(buttons);
//		if(btns != null){
//			menu.setButton(btns);
//		}
//		System.out.println("Encode menu as: " +JSONObject.fromObject(menu).toString());
//		return menu;
//	}
//	
//	private Button[] subButtonsToArray(List<Button> buttons){
//		
//		if(buttons.size() == 0){
//			return null;
//		}
//		Button[] btns = new Button[buttons.size()];
//		int i = 0;
//		for(Button btn:buttons){
//			btns[i] = btn;
//			i ++;
//		}
//		
//		return btns;
//	}
//	
//	private ComboButton[] buttonsToArray(List<ComboButton> buttons){
//		
//		if(buttons.size() == 0){
//			return null;
//		}
//		ComboButton[] btns = new ComboButton[buttons.size()];
//		int i = 0;
//		for(ComboButton btn:buttons){
//			btns[i] = btn;
//			i ++;
//		}
//		
//		return btns;
//	}
//	
	public static void main(String[] args){
		int i =0;
		System.out.println( "[MenuMangerController][main]");
		System.out.println("[{\"code\":\"" + i  + "\"}]");
	}
}
