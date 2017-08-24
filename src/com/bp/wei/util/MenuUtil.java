package com.bp.wei.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);
	private static final String FILENAME = "c:\\10\\menu.xml";
	
	public static String getMenuDefinition() 
	{
		System.out.println("[MenuTil][Menutil][getMenuDefinition]");
		
		
		FileReader fr = null;
		BufferedReader br = null;
		String ws_whole_string="";
		try 
		{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) 
			{
				//log.error(sCurrentLine);
				ws_whole_string+=sCurrentLine;
			}

		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		}
		finally
		{

			try 
			{

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} 
			catch (IOException ex) 
			{

				ex.printStackTrace();

			}
		}
		
		/*
		Resource rs = new ClassPathResource("menu.xml");		
		if (!rs.exists()) {
			log.error("Menu definition file not found!");
			return null;
		}
		*/
		
		XMLSerializer xmlSerializer = new XMLSerializer();
		
		try 
		{
			JSON jmenu = xmlSerializer.read(ws_whole_string);  
			//.readFromStream(rs.getInputStream());	
			
			return jmenu.toString();
		} catch (Exception e) {
			log.error("Failed to read menu definition file: " + e.getMessage());
			e.printStackTrace();
		}		
		return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println( "[MenuTil][Menutil][main]");
		MenuUtil.getMenuDefinition();
	}
}