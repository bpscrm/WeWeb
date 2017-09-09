package com.bp.wei.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.Button;
import com.bp.wei.model.ComboButton;
import com.bp.wei.model.CommonButton;
import com.bp.wei.model.Menu;
import com.bp.wei.service.MenuManager;
import com.bp.wei.util.ConfigUtil;
import com.bp.wei.util.MenuUtil;
import com.bp.wei.util.WeUtil;
import net.sf.json.JSONObject;

@Service
public class MenuManagerImpl implements MenuManager {
	
	public static Logger log = LoggerFactory.getLogger(MenuManagerImpl.class);
	
	@Override
	public int createMenu(Menu menu) {
		
		System.err.print( "[MenuManagerImpl][createMenu]");
		int result = 0;
		AccessToken accessToken = ConfigUtil.getCachedAccessToken();//WeUtil.getAccessToken();
		if(accessToken == null){
			log.error("Failed to get access token from WeChat");
			return -1;
		}
		System.out.println("accessToken.getToken() " +accessToken.getToken());
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken.getToken());
		String jsonMenu = MenuUtil.getMenuDefinition();//JSONObject.fromObject(menu).toString();//
		if(jsonMenu == null){
			log.error("Load menu definition error.");
			return -1;
		}
		log.debug("JSON menu object before sending: " + jsonMenu);
		System.out.println("url " + url);
		JSONObject jsonObject = WeUtil.httpRequest(url, "POST", jsonMenu); 
		
		if (null != jsonObject) {  
	        if (0 != jsonObject.getInt("errcode")) {  
	            result = jsonObject.getInt("errcode");  
	            log.error("Failed to create menu:" + jsonMenu + " errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        } else{
	        	log.info("Successfully updated menu :" + jsonMenu.toString());
	        }
	    } 
		return result;
	}

	/**
	 * will be replace by actual configurations from UI or else
	 */
	@Override
	public JSONObject getMenu() {
		
		System.out.println( "[MenuManagerImpl][getMenu]");
		CommonButton btn11 = new CommonButton();
		btn11.setKey("m1_b1");
		btn11.setName("测试一");
		btn11.setType("click");
		
		CommonButton btn12 = new CommonButton();
		btn12.setKey("m1_b2");
		btn12.setName("测试二");
		btn12.setType("click");
		
		CommonButton btn31 = new CommonButton();
		btn31.setKey("m2_b1");
		btn31.setName("会员中心");
		btn31.setType("click");
		
		ComboButton cbtn1 = new ComboButton();
		cbtn1.setName("体验活动");
		CommonButton[] sbs1 = new CommonButton[]{btn11, btn12};
		cbtn1.setSub_button(sbs1);
		
		CommonButton cbtn2 = new CommonButton();
		cbtn2.setName("芝麻圈");
		cbtn2.setKey("m2");
		cbtn2.setType("click");
				
		ComboButton cbtn3 = new ComboButton();
		cbtn3.setName("更多信息");
		CommonButton[] sbs3 = new CommonButton[]{btn31};
		cbtn3.setSub_button(sbs3);
		
		Menu menu = new Menu();
		menu.setButton(new Button[]{cbtn1, cbtn2, cbtn3});
		
		return JSONObject.fromObject(menu);
		
	}
	
	public static void main(String[] args){
		
		System.out.println( "[MenuManagerImpl][main]");
		MenuManagerImpl mm = new MenuManagerImpl();
		JSONObject menu = mm.getMenu();
		System.out.println(menu.toString());
	}

}
