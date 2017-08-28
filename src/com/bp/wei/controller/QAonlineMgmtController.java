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
import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.model.Menu;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.model.User;
import com.bp.wei.service.CRMDBManageService;
import com.bp.wei.service.MenuManager;
import com.bp.wei.service.UserService;
import com.bp.wei.util.WeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping()
public class QAonlineMgmtController {
	public static Logger log = LoggerFactory.getLogger(MenuManageController.class);
	
	@Autowired
	private MenuManager menuMgt;
	
	@Autowired
	private UserService userSrv;
	
	@Autowired
	private CRMDBManageService crmdbSrv;

	
	@RequestMapping(value="getFollowerInfo", method = RequestMethod.GET)
	public @ResponseBody Followerinfo findFollowerInfo(String id){
		log.debug("###########open id: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		Followerinfo followinfo = crmdbSrv.getFollowerInfo(id);
		log.debug("###########" + followinfo.toString());
		return followinfo;
	}
	
	
	@RequestMapping(value="getFollowerQAOnlineList", method = RequestMethod.GET)
	public @ResponseBody Followerinfo findFollowerQAOnlineList(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}

		Followerinfo followinfo = crmdbSrv.getFollowerQAOnlineList(id);
		log.debug("###########" + followinfo.toString());
		return followinfo;
	}
	
	
	@RequestMapping(value="setQAOnlineinfo", method = RequestMethod.POST)
	public @ResponseBody int setQAonlineinfo(@RequestBody JSONObject strQAOnlineinfo){
		
		log.debug("Start to set QAOnlineinfo...");
		if(strQAOnlineinfo == null){
			log.error("Failed to get qa online info from UI: " + strQAOnlineinfo);
			return -1;
		}
		
		System.out.println("#################" + strQAOnlineinfo.toString());
		
		QAOnlineWithBLOBs qaonline = new QAOnlineWithBLOBs();
		
		String cname = strQAOnlineinfo.getString("select_type_name");
		if(cname != null && cname.length() > 0){
			qaonline.setName(cname);
		}
		
		String cdesc = strQAOnlineinfo.getString("question_name");
		if(cdesc != null && cdesc.length() > 0){
			qaonline.setDescription(cdesc);
		}
		
		int result = crmdbSrv.setQAOnlineinfo(qaonline, strQAOnlineinfo.getString("followid_name"));
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	}

	@RequestMapping(value="qaonlineview", method = RequestMethod.GET)
	public String redirectQAOnlineview(){	
		return "qaonlineview";
	}
	
	@RequestMapping(value="getqaonlineinfo", method = RequestMethod.GET)
	public @ResponseBody QAOnlineWithBLOBs findQAOnlineInfo(String id){
		
		return crmdbSrv.getQAOnlineInfo(new String(id));
		
	}	
	
}
