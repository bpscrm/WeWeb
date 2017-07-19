package com.bp.wei.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	
	public static String getMenuDefinition(){
		Resource rs = new ClassPathResource("menu.xml");		
		if (!rs.exists()) {
			log.error("Menu definition file not found!");
			return null;
			
		}
		XMLSerializer xmlSerializer = new XMLSerializer();
		
		try {
			JSON jmenu = xmlSerializer.readFromStream(rs.getInputStream());	
			
			return jmenu.toString();
		} catch (Exception e) {
			log.error("Failed to read menu definition file: " + e.getMessage());
			e.printStackTrace();
		}		
		return null;
	}
	
	public static void main(String[] args){
		MenuUtil.getMenuDefinition();
	}
}
