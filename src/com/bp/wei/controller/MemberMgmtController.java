package com.bp.wei.controller;


import javax.servlet.http.HttpServletRequest;

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
import com.bp.wei.crm.model.Childinfo;
import com.bp.wei.crm.model.FeedbackWithBLOBs;
import com.bp.wei.crm.model.Purchaseinfo;
import com.bp.wei.service.CRMDBManageService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping
public class MemberMgmtController {
	public static Logger log = LoggerFactory.getLogger(MemberMgmtController.class);
	
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

	@RequestMapping(value="mypromotion", params = {"openid"}, method = RequestMethod.GET)
	public String mypromotion(){	
		return "mypromotion";
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
	
	@RequestMapping(value="getMemberchild", method = RequestMethod.GET)
	public @ResponseBody Memberinfo findMemberWithChildren(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		Memberinfo member = memberService.getMemberWithChildren(id);
		log.debug("###########" + member.toString());
		return member;
	}
	
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
	
	//insert child
	@RequestMapping(value="setchildinfo", method = RequestMethod.POST)
	public @ResponseBody int setChildinfo(@RequestBody JSONObject strChildinfo){
		
		log.debug("Start to set member...");
		if(strChildinfo == null){
			log.error("Failed to get child info from UI: " + strChildinfo);
			return -1;
		}
		
		System.out.println("#################" + strChildinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		Childinfo childinfo = new Childinfo();
		
		String cname = strChildinfo.getString("childname");
		if(cname != null && cname.length() > 0){
			childinfo.setName(cname);
		}
		
		String csex = strChildinfo.getString("childsex");
		if(csex != null && csex.length() > 0){
			childinfo.setChildSex(csex);
		}
		
		String cbird = strChildinfo.getString("childbird");
		if(cbird != null && cbird.length() > 0){
			childinfo.setChildBirthday(cbird);
		}
		
		String ceng = strChildinfo.getString("childeng");
		if(ceng != null && ceng.length() > 0){
			childinfo.setChildEng(ceng);
		}
		
		int result = memberService.insertChildinfo(childinfo, strChildinfo.getString("memberid1"));
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	}
	
	//search child
	@RequestMapping(value="getchildinfo", method = RequestMethod.GET)
	public @ResponseBody Childinfo findChildinfo(String id){
		
		return memberService.getchildinfo(new String(id));
		
	}
	
	//update child
	@RequestMapping(value="updatechildinfo", method = RequestMethod.POST)
	public @ResponseBody int updateChildinfo(@RequestBody JSONObject strChildinfo){
			
		log.debug("Start to set member...");
		if(strChildinfo == null){
			log.error("Failed to get child info from UI: " + strChildinfo);
			return -1;
		}
		
		System.out.println("#################" + strChildinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		Childinfo childinfo = new Childinfo();
		
		String cid = strChildinfo.getString("childid");
		if(cid != null && cid.length() > 0){
			childinfo.setId(cid);
		}
		
		String cname = strChildinfo.getString("childname");
		if(cname != null && cname.length() > 0){
			childinfo.setName(cname);
		}
		
		String csex = strChildinfo.getString("childsex");
		if(csex != null && csex.length() > 0){
			childinfo.setChildSex(csex);
		}
		
		String cbird = strChildinfo.getString("childbird");
		if(cbird != null && cbird.length() > 0){
			childinfo.setChildBirthday(cbird);
		}
		
		String ceng = strChildinfo.getString("childeng");
		if(ceng != null && ceng.length() > 0){
			childinfo.setChildEng(ceng);
		}
		
		int result = memberService.updateChildinfo(childinfo);
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	}
	
	//search purchase
	@RequestMapping(value="getPurchaselist", method = RequestMethod.GET)
	public @ResponseBody Memberinfo findMemberWithPurchase(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		Memberinfo member = memberService.getMemberWithPurchase(id);
		log.debug("###########" + member.toString());
		return member;
	}
	
	@RequestMapping(value="getPurchaseinfo", method = RequestMethod.GET)
	public @ResponseBody Purchaseinfo findPurchaseInfo(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		Purchaseinfo purinfo = memberService.getPurchaseInfo(id);
		log.debug("###########" + purinfo.toString());
		return purinfo;
	}
	
	
	//insert feedback
	@RequestMapping(value="setfeedbackinfo", method = RequestMethod.POST)
	public @ResponseBody int setfeedbackinfo(@RequestBody JSONObject strfeedbackinfo){
		
		log.debug("Start to set member...");
		if(strfeedbackinfo == null){
			log.error("Failed to get child info from UI: " + strfeedbackinfo);
			return -1;
		}
		
		System.out.println("#################" + strfeedbackinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		FeedbackWithBLOBs feedback = new FeedbackWithBLOBs();
		
		String fname = strfeedbackinfo.getString("feedbackname");
		if(fname != null && fname.length() > 0){
			feedback.setName(fname);
		}
		
		String fcontent = strfeedbackinfo.getString("feedbackcontent");
		if(fcontent != null && fcontent.length() > 0){
			feedback.setDescription(fcontent);
		}
		
		String ftime = strfeedbackinfo.getString("feedbacktime");
		if(ftime != null && ftime.length() > 0){
			feedback.setFdDt(ftime);
		}
		
		int result = memberService.insertFeedbackinfo(feedback, strfeedbackinfo.getString("purchaseid"));
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	}
	
	//search feedback
	@RequestMapping(value="getfeedbackinfo", method = RequestMethod.GET)
	public @ResponseBody FeedbackWithBLOBs findFeedbackinfo(String id){
		
		return memberService.getFeedbackinfobyid(new String(id));
		
	}
	
	@RequestMapping(value="getFeedbacklist", method = RequestMethod.GET)
	public @ResponseBody Purchaseinfo findFeedbacklist(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		Purchaseinfo purinfo = memberService.getFeedbacklist(id);
		log.debug("###########" + purinfo.toString());
		return purinfo;
	}
	
	//update feedback
	@RequestMapping(value="updatefeedbackinfo", method = RequestMethod.POST)
	public @ResponseBody int updatefeedbackinfo(@RequestBody JSONObject strfeedbackinfo){
		
		log.debug("Start to set member...");
		if(strfeedbackinfo == null){
			log.error("Failed to get child info from UI: " + strfeedbackinfo);
			return -1;
		}
		
		System.out.println("#################" + strfeedbackinfo.toString());
		
		//JSONObject jsonObject = JSONObject.fromObject(strMember);
		FeedbackWithBLOBs feedback = new FeedbackWithBLOBs();
		
		String fid = strfeedbackinfo.getString("feedbackid");
		if(fid != null && fid.length() > 0){
			feedback.setId(fid);
		}
		
		String fname = strfeedbackinfo.getString("feedbackname");
		if(fname != null && fname.length() > 0){
			feedback.setName(fname);
		}
		
		String fcontent = strfeedbackinfo.getString("feedbackcontent");
		if(fcontent != null && fcontent.length() > 0){
			feedback.setDescription(fcontent);
		}
		
		String ftime = strfeedbackinfo.getString("feedbacktime");
		if(ftime != null && ftime.length() > 0){
			feedback.setFdDt(ftime);
		}
				
		int result = memberService.updateFeedbackinfo(feedback);
		
		System.out.println("@@@@@@@@@@@@@@result: " + result);
		return result;		
	}

	
	/////////////////////////////////////////////////////////////////////for examples
	@RequestMapping(value="register", method = RequestMethod.GET)
	public String redirectRegister(){		
		return "register";
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
}
