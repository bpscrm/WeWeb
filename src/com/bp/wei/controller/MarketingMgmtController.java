package com.bp.wei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bp.wei.crm.model.Marketinginfo;
import com.bp.wei.crm.model.MarketinginfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.crm.model.Questionnaire;
import com.bp.wei.service.CRMDBManageService;

@Controller
@RequestMapping
public class MarketingMgmtController {
	public static Logger log = LoggerFactory.getLogger(MarketingMgmtController.class);
	
	@Autowired
	CRMDBManageService  marktingService;
	//营销活动入口
	@RequestMapping(value="marketingentry", method = RequestMethod.GET)
	public String redirectGomarketingentry(){		
		return "marketingentry";
	}	
	//活动首页
	@RequestMapping(value="marketingindex", method = RequestMethod.GET)
	public String redirectMarketingindex(){	
		return "marketingindex";
	}
	//活动报名
	@RequestMapping(value="marketingsignup", method = RequestMethod.GET)
	public String redirectMarketingsignup(){		
		return "marketingsignup";
	}
	//签到
	@RequestMapping(value="signinpage", method = RequestMethod.GET)
	public String redirectSigninpage(){	
		return "marketingsigninpage";
	}
	//调查反馈
	@RequestMapping(value="feedbacksurvey", method = RequestMethod.GET)
	public String redirectFeedbacksurvey(){	
		return "feedbacksurvey";
	}
	//进入报名调查页面
	@RequestMapping(value="signupsurvey", method = RequestMethod.GET)
	public String redirectSignupsurvey(){	
		return "marketingsignupsurvey";
	}
	//进入取消报名页面
	@RequestMapping(value="signupcancel", method = RequestMethod.GET)
	public String redirectSignupcancel(){	
		return "marketingsignupcancel";
	}
	//获得在用的营销活动
	@RequestMapping(value="getMarketinglist", method = RequestMethod.GET)
	public @ResponseBody Marketinginfo findMarketinglist(){
		
		Marketinginfo result = marktingService.getMarketinglist();
		
		System.out.println("@@@@@@@@@@@result: " + result.toString());
		
		return result;
	}
	//search marketing info
	@RequestMapping(value="getmarketing", method = RequestMethod.GET)
	public @ResponseBody MarketinginfoWithBLOBs findMarketing(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		MarketinginfoWithBLOBs marketing = marktingService.getMarketing(id);
		log.debug("###########" + marketing.getName());
		return marketing;
	}	
	//获取问题列表
	@RequestMapping(value="getQuestionnaire", method = RequestMethod.GET)
	public @ResponseBody Questionnaire getQuestionnaire(String id){
		if(id == null || id.length() <= 0){
			log.error("Invalid questionnaire id from UI.");
			return null;
		}
		Questionnaire result = marktingService.getQuestionnaireById(id);
		if(result == null){
			log.error("No questionnaire definition.");
			return null;
		}
		System.out.println("@@@@@@@@@@@result: " + result.toString());
		return result;
	}
	//提交答案
	@RequestMapping(value="submitSurvey", method = RequestMethod.POST)
	public String submitSurvey(HttpServletRequest request, RedirectAttributes attr){	
		log.debug("setSurveryResult start...");
		String surveryId = request.getParameter("sid");
		String openId = request.getParameter("openid_name");
		String nickName = request.getParameter("nick_name");
		String mkid = request.getParameter("mkname");
		System.out.println("mkid id---------------------: " + mkid);
		int i = 1;
		

		boolean hasnext = true;
		while(hasnext){
			String questionId = request.getParameter("qid_" + i);
			System.out.println("question id: " + questionId);
			if(questionId != null && questionId.length() > 0){
				String answer = request.getParameter(questionId);
				System.out.println("answer id:。。。。。。。。。。 " + answer);
				i ++;
			}else{
				hasnext = false;
			}
		}
		
		
		//if(hasnext){
			
			boolean blResult = marktingService.setInteractionData(request);
		//}
		
			
		attr.addAttribute("openid", openId);
		attr.addAttribute("nickname", nickName);
		attr.addAttribute("mkid", mkid);
		return "redirect:marketingindex";
		
	
	}	
		
	
	//search marketing info for 签到
	@RequestMapping(value="getmarketingforsignin", method = RequestMethod.GET)
	public @ResponseBody MarketinginfoWithBLOBs findmMarketingForSignin(String id){
		log.debug("###########memberid: " + id);
		if(id == null || id.length() == 0){
			return null;
		}
		log.debug("###########memberid: " + id);
		MarketinginfoWithBLOBs marketing = marktingService.getMarketingForSignin(id);
		log.debug("###########" + marketing.getName());
		return marketing;
	}
	//提交签到
	@RequestMapping(value="submitSignin", method = RequestMethod.POST)
	public ModelAndView submitSignin(HttpServletRequest request){	
		log.debug("submitSignin start...");
		String marketingId = request.getParameter("mkname");
		System.out.println("marketing................... id: " + marketingId);
		
		String memberId = request.getParameter("mbname");
		System.out.println("member................... id: " + memberId);
		
		String particId = request.getParameter("particname");
		System.out.println("partic................... id: " + particId);		
		
		boolean blResult = marktingService.setParticipateData(request);
		
		
		ModelAndView result = new ModelAndView();
		result.setViewName("marketingentry");		
		return result;
	}

}
