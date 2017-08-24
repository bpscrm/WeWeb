package com.bp.wei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.service.CRMDBManageService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping
public class CRMDBManageController {
	public static Logger log = LoggerFactory.getLogger(CRMDBManageController.class);
	
	@Autowired
	CRMDBManageService memberService;
	
	@RequestMapping(value="memberregister", method = RequestMethod.GET)
	public String redirectMemberregister(){		
		return "memberregister";
	}
	
	
	@RequestMapping(value="memberinfo", method = RequestMethod.GET)
	public String redirectMemberinfo(){	
		return "memberinfo";
	}

	@RequestMapping(value="mypromotion", method = RequestMethod.GET)
	public String redirectMypromotion(){	
		return "mypromotion";
	}
	
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public String redirectRegister(){		
		return "register";
	}

	@RequestMapping(value="childrenlist", method = RequestMethod.GET)
	public String redirectChildrenlist(){	
		return "childrenlist";
	}
	
	@RequestMapping(value="msg_success", method = RequestMethod.GET)
	public String redirectMsg_success(){	
		return "msg_success";
	}
	
	@RequestMapping(value="childinfoadd", method = RequestMethod.GET)
	public String redirectChildinfoadd(){	
		return "childinfoadd";
	}
	
	@RequestMapping(value="childinfoupdate", method = RequestMethod.GET)
	public String redirectChildinfoupdate(){	
		return "childinfoupdate";
	}
	
	@RequestMapping(value="purchaselist", method = RequestMethod.GET)
	public String redirectPurchaselist(){	
		return "purchaselist";
	}
	
	@RequestMapping(value="feedbacklist", method = RequestMethod.GET)
	public String redirectFeedbacklist(){	
		return "feedbacklist";
	}
	
	@RequestMapping(value="feedbackinfoadd", method = RequestMethod.GET)
	public String redirectFeedbackinfoadd(){	
		return "feedbackinfoadd";
	}
	
	@RequestMapping(value="feedbackinfoupdate", method = RequestMethod.GET)
	public String redirectFeedbackinfoupdate(){	
		return "feedbackinfoupdate";
	}
	
	@RequestMapping(value="myfollower", method = RequestMethod.GET)
	public String redirectMyfollower(){	
		return "myfollower";
	}
	
	@RequestMapping(value="myqrcode", method = RequestMethod.GET)
	public String redirectMyqrcode(){	
		return "myqrcode";
	}
	
	@RequestMapping(value="registerinfo", method = RequestMethod.POST)
	public ModelAndView viewRegisterinfo(HttpServletRequest request){	
		log.debug("redirectRegisterinfo start...");
		Member member = new Member();
		member.setName(request.getParameter("membername"));
		log.debug("################" + member.toString());
		ModelAndView result = new ModelAndView();
		//Map<String, Object> modelMap = new HashMap<String, Object>();
		result.setViewName("registerinfo");		
		result.addObject("member", JSONObject.fromObject(member));	
		return result;
	}
	
	@RequestMapping(value="getmember", method = RequestMethod.GET)
	public @ResponseBody Member findMember(int id){
		
		return memberService.getMemberById(new Integer(id));
		
	}
	
	@RequestMapping(value="setmember", method = RequestMethod.POST)
	public @ResponseBody int setMember(@RequestBody JSONObject strMember){
		log.debug("Start to set member...");
		if(strMember == null){
			log.error("Failed to get member info from UI: " + strMember);
			return -1;
		}
		
		Member member = new Member();
		String mobile = strMember.getString("membermobile");
		if(mobile != null && mobile.length() > 0){
			member.setMobile(mobile);
		}
		String name = strMember.getString("membername");
		if(name != null && name.length() > 0){
			member.setName(name);
		}
		member.setGender("F");
		member.setBirthday("2017-01-01");
		
		int result = memberService.setMember(member);		
		
		return result;		
	}
	
	/////////for follower
	//search myfollower
	@RequestMapping(value="getFollowerlist", method = RequestMethod.GET)
	public @ResponseBody Followerinfo findMyFollowerList(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		Followerinfo followerinfo = memberService.getFollowerlist(id);
		log.debug("###########" + followerinfo.toString());
		return followerinfo;
	}
	
	
	/////////for member 
	//insert member
	@RequestMapping(value="setmemberinfo", method = RequestMethod.POST)
	public @ResponseBody int setMemberinfo(@RequestBody JSONObject strMemberinfo){
		
		log.debug("Start to set member...");
		if(strMemberinfo == null){
			log.error("Failed to get member info from UI: " + strMemberinfo);
			return -1;
		}
		
		System.out.println("#################" + strMemberinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		MemberinfoWithBLOBs memberinfo = new MemberinfoWithBLOBs();
		
		String telnum = strMemberinfo.getString("memberinfotelnum");
		if(telnum != null && telnum.length() > 0){
			memberinfo.setName(telnum);
		}
		
		String titel = strMemberinfo.getString("memberinfotitle");
		if(titel != null && titel.length() > 0){
			memberinfo.setMbTitle(titel);
		}
		
		String mbname = strMemberinfo.getString("memberinfoname");
		if(mbname != null && mbname.length() > 0){
			memberinfo.setMbName(mbname);
		}
		
		String birthday = strMemberinfo.getString("memberinfobird");
		if(birthday != null && birthday.length() > 0){
			memberinfo.setMbBirthday(birthday);
		}
		
		String ifchild = strMemberinfo.getString("memberinfoifchild");
		if(ifchild != null && ifchild.length() > 0){
			memberinfo.setMbChild(ifchild);
		}
		
		String edulevel = strMemberinfo.getString("memberinfoedulevel");
		if(edulevel != null && edulevel.length() > 0){
			memberinfo.setMbEdu(edulevel);
		}
		
		String addr = strMemberinfo.getString("memberinfoaddr");
		if(addr != null && addr.length() > 0){
			memberinfo.setMbAddr(addr);
		}
		
		Followerinfo followerinfo = new Followerinfo();
		followerinfo.setId(strMemberinfo.getString("followid"));
		
		int result = memberService.insertMemberinfo(memberinfo, strMemberinfo.getString("followid"));
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	
	}
	//search member
	@RequestMapping(value="getmemberinfo", method = RequestMethod.GET)
	public @ResponseBody MemberinfoWithBLOBs findMemberinfo(String name){
		
		return memberService.getMemberinfobyname(new String(name));
		
	}
	//update member 
	@RequestMapping(value="updatememberinfo", method = RequestMethod.POST)
	public @ResponseBody int updateMemberinfo(@RequestBody JSONObject strMemberinfo){
		
		log.debug("Start to update member...");
		if(strMemberinfo == null){
			log.error("Failed to get member info from UI: " + strMemberinfo);
			return -1;
		}
		
		System.out.println("#################" + strMemberinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		MemberinfoWithBLOBs memberinfo = new MemberinfoWithBLOBs();
		
		
		String mid = strMemberinfo.getString("memberid1");
		if(mid != null && mid.length() > 0){
			memberinfo.setId(mid);
		}
		
		String telnum = strMemberinfo.getString("memberinfotelnum");
		if(telnum != null && telnum.length() > 0){
			memberinfo.setName(telnum);
		}
		
		String titel = strMemberinfo.getString("memberinfotitle");
		if(titel != null && titel.length() > 0){
			memberinfo.setMbTitle(titel);
		}
		
		String mbname = strMemberinfo.getString("memberinfoname");
		if(mbname != null && mbname.length() > 0){
			memberinfo.setMbName(mbname);
		}
		
		String birthday = strMemberinfo.getString("memberinfobird");
		if(birthday != null && birthday.length() > 0){
			memberinfo.setMbBirthday(birthday);
		}
		
		String ifchild = strMemberinfo.getString("memberinfoifchild");
		if(ifchild != null && ifchild.length() > 0){
			memberinfo.setMbChild(ifchild);
		}
		
		String edulevel = strMemberinfo.getString("memberinfoedulevel");
		if(edulevel != null && edulevel.length() > 0){
			memberinfo.setMbEdu(edulevel);
		}
		
		String addr = strMemberinfo.getString("memberinfoaddr");
		if(addr != null && addr.length() > 0){
			memberinfo.setMbAddr(addr);
		}
		
		
		int result = memberService.updateMemberinfo(memberinfo);
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;	
	}
	
	
	//for test data 
	@RequestMapping(value="gettestfollowerid", method = RequestMethod.POST)
	public @ResponseBody JSONObject getTestfollowerid(@RequestBody JSONObject strtestfollowerid){
		
		Map params = new HashMap();
		
		log.debug("Start to set member...");
		if(strtestfollowerid == null){
			log.error("Failed to get child info from UI: " + strtestfollowerid);
			
			params.put("id", "null");
			JSONObject result = JSONObject.fromObject(params);
			
			return result;
		}
		
		System.out.println("#################" + strtestfollowerid.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		Followerinfo follow = new Followerinfo();
		
		String flname = strtestfollowerid.getString("membertelnumname");
		if(flname != null && flname.length() > 0){
			follow.setName("openid-" + flname);
		}
				
		String flid = memberService.getTestFollowerinfo(follow);
		
		params.put("id", flid);
		JSONObject result = JSONObject.fromObject(params);
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		
		return result;		
	}

}
