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
public class MenuManageController {
	public static Logger log = LoggerFactory.getLogger(MenuManageController.class);
	
	@Autowired
	private MenuManager menuMgt;
	
	@RequestMapping(value="menu", method = RequestMethod.GET)
	public String redirectMenu(){
		
		return "menu_config";
	}
	
	@RequestMapping(value="getMenu", method = RequestMethod.GET)
	public @ResponseBody JSONObject getMenu(){
		JSONObject menu = null;
		menu = menuMgt.getMenu();
		log.info("Fetched WeChat menu: " + menu.toString());
		return menu;
	}
	
	@RequestMapping(value="setMenu", method = RequestMethod.POST)
	public String setMenu(@RequestBody JSONObject menu){
		log.debug("Start updating the WeChat menu " + menu.toString());

		Menu objMenu = this.fromJSONObject(menu);
		if(objMenu != null){
			menuMgt.createMenu(objMenu);
		}
		log.debug("WeChat menu updated.");
		return "menu_config";
	}
	
	/**
	 * 
	 * @param jmenu
	 * @return
	 * @see Temporary solution for mapping json menu to menu class, to be changed
	 */
	private Menu fromJSONObject(JSONObject jmenu){
		Menu menu = new Menu();
//		ObjectMapper mapper = new ObjectMapper(); 
//		mapper.convertValue(jmenu, Menu.class);
		JSONArray bnames = (JSONArray) jmenu.get("buttons");
		JSONArray sbnames = (JSONArray) jmenu.get("subButtons");
		int i = 0;		
		List<ComboButton> buttons = new ArrayList<ComboButton>();
		for(int a = 0; a < bnames.size(); a ++){
			String bname = bnames.get(a).toString();
			if(bname == null || "".equals(bname)){
				continue;
			}
			ComboButton btn = new ComboButton();
			btn.setName(bname);		

			List<Button> subButtons = new ArrayList<Button>();
			
			for(int b = i,c = 0; c < 5; b ++, c ++){
				String sbname = sbnames.get(b).toString();
				if(sbname == null || "".equals(sbname)){
					i ++;
					continue;
				}
				Button sbtn = new Button();
				sbtn.setName(sbname);
				sbtn.setKey(a + "_" + b);
				sbtn.setType("click");				
				subButtons.add(sbtn);
				i ++;
			}
			Button[] sbtns = subButtonsToArray(subButtons);
			if(sbtns != null){
				btn.setSubButton(sbtns);
			}

			buttons.add(btn);
		}
		ComboButton[] btns = buttonsToArray(buttons);
		if(btns != null){
			menu.setButton(btns);
		}
		System.out.println("Encode menu as: " + menu.toString());
		return menu;
	}
	
	private Button[] subButtonsToArray(List<Button> buttons){
		
		if(buttons.size() == 0){
			return null;
		}
		Button[] btns = new Button[buttons.size()];
		int i = 0;
		for(Button btn:buttons){
			btns[i] = btn;
			i ++;
		}
		
		return btns;
	}
	
	private ComboButton[] buttonsToArray(List<ComboButton> buttons){
		
		if(buttons.size() == 0){
			return null;
		}
		ComboButton[] btns = new ComboButton[buttons.size()];
		int i = 0;
		for(ComboButton btn:buttons){
			btns[i] = btn;
			i ++;
		}
		
		return btns;
	}
}
