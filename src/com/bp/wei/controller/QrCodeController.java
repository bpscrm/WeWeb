/**
 * 
 */
package com.bp.wei.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bp.wei.model.qrcode.response.QRCodeTicket;
import com.bp.wei.service.QRCodeServcie;

/**
 * @author liyanc
 *
 */
@Controller
@RequestMapping()
public class QrCodeController {
	public static Logger log = LoggerFactory.getLogger(QrCodeController.class);
	
	@Autowired
	private QRCodeServcie qrService;
	
	@RequestMapping(value="qrcode", method = RequestMethod.GET)
	public String redirectQrcode(){
		
		System.out.println( "[QrCodeController][redirectQrcode]");
		return "qrcode";
	}
	

	@RequestMapping(value="myqrcode", method = RequestMethod.POST)
	public String getMyQRCode(HttpServletRequest request){
		String fromOpenId = request.getParameter("fromOpenId");
		if(fromOpenId == null || fromOpenId.length() == 0){
			log.error("Failed to pass openid in.");
			return "error";
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("action_name", "QR_STR_SCENE");
		//需要传入的字符串参数，如果需要传入的是整型参数，action_name需要使用QR_SCENE，永久型是QR_LIMIT_SCENE/QR_LIMIT_STR_SCENE
		params.put("scene_str", fromOpenId);
		QRCodeTicket qrTicket = qrService.getTicket(params);
		if(qrTicket == null || qrTicket.getTicket() == null){
			log.error("Failed to get promotion qrcode ticket for " + fromOpenId + " from Wechat.");
			return "error";
		}
		
		String showUrl = qrService.getTicketUrl(qrTicket);
		if(showUrl == null){
			log.error("Failed to get qrcode show url from Wechat.");
			return "error";
		}
		
		return "redirect:" + showUrl;
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
