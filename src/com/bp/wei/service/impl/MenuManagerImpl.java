package com.bp.wei.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.model.AccessToken;
import com.bp.wei.model.Button;
import com.bp.wei.model.ComboButton;
import com.bp.wei.model.Menu;
import com.bp.wei.service.MenuManager;
import com.bp.wei.util.WeUtil;
import net.sf.json.JSONObject;

@Service
public class MenuManagerImpl implements MenuManager {
	
	public static Logger log = LoggerFactory.getLogger(MenuManagerImpl.class);
	
	@Override
	public int createMenu(Menu menu) {
		int result = 0;
		AccessToken accessToken = WeUtil.getAccessToken();
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken.getToken());
		String jsonMenu = JSONObject.fromObject(menu).toString();
		
		JSONObject jsonObject = WeUtil.httpRequest(url, "POST", jsonMenu); 
		
		if (null != jsonObject) {  
	        if (0 != jsonObject.getInt("errcode")) {  
	            result = jsonObject.getInt("errcode");  
	            log.error("Failed to create menu:" + jsonMenu + " errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
	        }  
	    } 
		return result;
	}

	/**
	 * will be replace by actual configurations from UI or else
	 */
	@Override
	public JSONObject getMenu() {
		Button btn11 = new Button();
		btn11.setKey("m1_b1");
		btn11.setName("测试一");
		btn11.setType("click");
		
		Button btn12 = new Button();
		btn12.setKey("m1_b2");
		btn12.setName("测试二");
		btn12.setType("click");
		
		Button btn31 = new Button();
		btn31.setKey("m2_b1");
		btn31.setName("会员中心");
		btn31.setType("click");
		
		ComboButton cbtn1 = new ComboButton();
		cbtn1.setName("体验活动");
		Button[] sbs1 = new Button[]{btn11, btn12};
		cbtn1.setSubButton(sbs1);
		
		ComboButton cbtn2 = new ComboButton();
		cbtn2.setName("芝麻圈");
		
		ComboButton cbtn3 = new ComboButton();
		cbtn3.setName("更多信息");
		Button[] sbs3 = new Button[]{btn31};
		cbtn3.setSubButton(sbs3);
		
		Menu menu = new Menu();
		menu.setButton(new ComboButton[]{cbtn1, cbtn2, cbtn3});
		
		return JSONObject.fromObject(menu);
	}
	
	public static void main(String[] args){
		MenuManagerImpl mm = new MenuManagerImpl();
		JSONObject menu = mm.getMenu();
		System.out.println(menu.toString());
	}

}
