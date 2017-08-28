package com.bp.wei.service;


import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.crm.model.Childinfo;
import com.bp.wei.crm.model.FeedbackWithBLOBs;
import com.bp.wei.crm.model.Purchaseinfo;

public interface CRMDBManageService {
	
	///////////////////for follower
	//search myfollower
	Followerinfo getFollowerlist(String id);
	

	////////////////////////////////////////////////////////////for 你问我答
	//search follower
	Followerinfo getFollowerInfo(String wechatUserid);
	
	//search follower QA online
	Followerinfo getFollowerQAOnlineList(String id);
	
	//set QA online
	int setQAOnlineinfo(QAOnlineWithBLOBs record, String followerid);
	
	//get QA Online info for view
	QAOnlineWithBLOBs getQAOnlineInfo(String id);
	
	////////////////////////////////////////////////////////////////////////
	///////////////////for member
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

	//for examples
	Member getMemberById(int memberId);
	int setMember(Member member);
	
	
}
