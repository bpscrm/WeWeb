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
	
	@Autowired
	private CRMDBManageService crmdbSrv;
	
	//////////////////////////////////////////////////////////////////////for 设定微信服务号菜单
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
	
	//////////////////////////////////////////////////////////////////////for 你问我答
	@RequestMapping(value="QAOnlineIndex", method = RequestMethod.GET)
	public String redirectQAOnlineIndexu(){
		
		System.out.println( "[MenuMangerController][redirectQAOnlineIndexu]");
		return "qaonlineindex";
	}
	
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
	
	//////////////////////////////////////////////////////////////////////for 会员管理
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
	
	///////
	public static void main(String[] args){
		int i =0;
		System.out.println( "[MenuMangerController][main]");
		System.out.println("[{\"code\":\"" + i  + "\"}]");
	}
}
