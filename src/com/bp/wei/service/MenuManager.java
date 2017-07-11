package com.bp.wei.service;

import com.bp.wei.model.Menu;

import net.sf.json.JSONObject;

public interface MenuManager {
	
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/* 生成微信服務號菜單*/
	public int createMenu(Menu menu);
	
	public JSONObject getMenu();
}
