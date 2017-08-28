package com.bp.wei.service;


import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;

public interface CRMDBManageService {
	
	///////////////////for follower
	//search myfollower
	Followerinfo getFollowerlist(String id);
	
	///////////////////for member
	//insert
	int insertMemberinfo(MemberinfoWithBLOBs memberinfowithblogs, String openid);
	//search
	MemberinfoWithBLOBs getMemberinfobyname(String name);
	//update
	int updateMemberinfo(MemberinfoWithBLOBs memberinfowithblogs);
	
	
    ///////////////////for test follower  
	String getTestFollowerinfo(Followerinfo follow);

	//for examples
	Member getMemberById(int memberId);
	int setMember(Member member);
	
	////////////////////////////////////////////////////////////for 你问我答
	//search follower
	Followerinfo getFollowerInfo(String wechatUserid);
	
	//search follower QA online
	Followerinfo getFollowerQAOnlineList(String id);
	
	//set QA online
	int setQAOnlineinfo(QAOnlineWithBLOBs record, String followerid);
	
	//get QA Online info for view
	QAOnlineWithBLOBs getQAOnlineInfo(String id);
	
		
	
	
}
