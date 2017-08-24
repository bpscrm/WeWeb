/**
 * 
 */
package com.bp.wei.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.bp.wei.service.MenuManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author liyanc
 *
 */
@Controller
@RequestMapping()
public class QrCodeController {
	public static Logger log = LoggerFactory.getLogger(QrCodeController.class);
	
	@Autowired
	private MenuManager menuMgt;
	
	@RequestMapping(value="qrcode", method = RequestMethod.GET)
	public String redirectQrcode(){
		
		System.out.println( "[QrCodeController][redirectQrcode]");
		return "qrcode";
	}
	
	/*@RequestMapping(value="getMenu", method = RequestMethod.GET)
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
    */
	
	public static void main(String[] args){
		int i =0;
		System.out.println( "[QrCodeController][main]");
		System.out.println("[{\"code\":\"" + i  + "\"}]");
	}
}
