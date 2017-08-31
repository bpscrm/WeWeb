package com.bp.wei.service;


import javax.servlet.http.HttpServletRequest;

import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.crm.model.Childinfo;
import com.bp.wei.crm.model.FeedbackWithBLOBs;
import com.bp.wei.crm.model.Purchaseinfo;
import com.bp.wei.crm.model.Marketinginfo;
import com.bp.wei.crm.model.MarketinginfoWithBLOBs;
import com.bp.wei.crm.model.Questionnaire;

public interface CRMDBManageService {
	
	///////////////////for follower
	//search my follower
	Followerinfo getFollowerlist(String id);
	
	//search follower
	Followerinfo getFollowerInfo(String wechatUserid);
	

	////////////////////////////////////////////////////////////for 你问我答
	//search follower QA online
	Followerinfo getFollowerQAOnlineList(String id);
	
	//set QA online
	int setQAOnlineinfo(QAOnlineWithBLOBs record, String followerid);
	
	//get QA Online info for view
	QAOnlineWithBLOBs getQAOnlineInfo(String id);
	
	
	////////////////////////////////////////////////////////////for member
	//search follower
	String getMemberInfo(String followid);
	//insert
	int insertMemberinfo(MemberinfoWithBLOBs memberinfowithblogs, String openid);
	//search
	MemberinfoWithBLOBs getMemberinfobyname(String name);
	//update
	int updateMemberinfo(MemberinfoWithBLOBs memberinfowithblogs);

	///////////////////for child
	//insert
	int insertChildinfo(Childinfo childinfo, String mbid);
	//search
	Memberinfo getMemberWithChildren(String memberId);
	Childinfo getchildinfo(String id);
	//update
	int updateChildinfo(Childinfo childinfo);
	
	///////////////////for Purchase
	//search
	Memberinfo getMemberWithPurchase(String id);
	Purchaseinfo getPurchaseInfo(String id);
	
	///////////////////for feedback
	//insert
	int insertFeedbackinfo(FeedbackWithBLOBs feedbackinfo, String purchaseid);
	//search
	FeedbackWithBLOBs getFeedbackinfobyid(String id);
	Purchaseinfo getFeedbacklist(String id);
	//update
	int updateFeedbackinfo(FeedbackWithBLOBs feedbackinfo);
	

	/////////////////////////////////////////////////////////////////for 营销活动
	Marketinginfo getMarketinglist();
	
	MarketinginfoWithBLOBs getMarketing(String id);
	
	Questionnaire getQuestionnaireById(String id);
	
	boolean setInteractionData(HttpServletRequest request);
	
	boolean setParticipateData(HttpServletRequest request);
	
	MarketinginfoWithBLOBs getMarketingForSignin(String id);
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////for examples
	Member getMemberById(int memberId);
	int setMember(Member member);
	
	
}
