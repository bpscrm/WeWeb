package com.bp.wei.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.dao.MemberDao;
import com.bp.wei.dao.MemberinfoDao;
import com.bp.wei.dao.FollowerinfoDao;
import com.bp.wei.dao.MemberToFollowerDao;
import com.bp.wei.dao.QAOnlineDao;
import com.bp.wei.dao.QAOnlineToFollowerDao;
import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.MemberToFollower;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineToFollower;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.service.CRMDBManageService;

@Service
public class CRMDBManageServiceImpl implements CRMDBManageService {
	
	public static Logger log = LoggerFactory.getLogger(CRMDBManageService.class);
	
	
	@Resource
	private FollowerinfoDao fldao;
	
	@Resource
	private QAOnlineDao qadao;
	
	@Resource
	private QAOnlineToFollowerDao qatofldao;	
	
	@Resource
	private MemberinfoDao mbdao;
	
	@Resource
	private MemberToFollowerDao mtfdao;
	
	////////////////for follower
	//myfollower
	public Followerinfo getFollowerlist(String id) {
		Followerinfo followerinfo = fldao.selectMyFollowerListByKey(id);
		return followerinfo;
	}
		
	////////////////for member
	//insert
	@Override
	public int insertMemberinfo(MemberinfoWithBLOBs memberinfowithblogs, String openid) {
		
		int result = mbdao.insert(memberinfowithblogs);
		//System.out.println("@@@@@@@@@@@@@@member id: " + memberinfowithblogs.getId());
		
		String followerID = fldao.selectByPrimaryOpenid(openid);
		
		MemberToFollower mbTofl = new MemberToFollower();
		mbTofl.setEc1MemberEc1Followerec1MemberIda(memberinfowithblogs.getId());
		mbTofl.setEc1MemberEc1Followerec1FollowerIdb(followerID);
		
		result = mtfdao.insert(mbTofl);
		
		return result;
	}
	//search
	@Override
	public MemberinfoWithBLOBs getMemberinfobyname(String name) {
		if(name.length() <= 0){
			log.error("Invalid member name: " + name);
			return null;
		}
		MemberinfoWithBLOBs memberinfo = mbdao.selectByMemberName(new String(name));
		return memberinfo;
	}
	//update
	public int updateMemberinfo(MemberinfoWithBLOBs memberinfowithblogs) {
		
		int result = mbdao.updateByPrimaryKeyWithBLOBs(memberinfowithblogs);
		
		return result;
	}
	

	///////////////////for test follower  
	public String getTestFollowerinfo(Followerinfo follow) {
		
		System.out.println("@@@@@@@@@@@@@@follower open id: " + follow.getName());
		if(follow.getName().length() <= 0){
			log.error("Invalid member name: " + follow.getName());
			return "null";
		}
		
		String FollowerID = fldao.selectByPrimaryOpenid(follow.getName());
		
		if(FollowerID != null && FollowerID.length() > 0){
			return FollowerID;
		} else {
			
			int result = fldao.insert(follow);
			if(result == 1){
				return follow.getId();
			} else {
				return "null";
			}
			
		}
	}
		
	
	/////////////////////////////////////////////////////////////你问我答
	//search follower
		public Followerinfo getFollowerInfo(String wechatUserid) {
			Followerinfo followerinfo = fldao.selectFollowerInfoByKey(wechatUserid);
			return followerinfo;
		}
		
		//search follower QA online
		public Followerinfo getFollowerQAOnlineList(String id) {
			Followerinfo followerinfo = fldao.selectFollowerQAOnlineList(id);
			return followerinfo;
		}
		
		//set QA online
		public int setQAOnlineinfo(QAOnlineWithBLOBs record, String followerid) {
			//insert QA Online
			int result = qadao.insertQAOnlineInfo(record);
			
			//insert relation to follower
			QAOnlineToFollower qatofl = new QAOnlineToFollower();
			qatofl.setEc1QaOnlineEc1Followerec1FollowerIda(followerid);
			qatofl.setEc1QaOnlineEc1Followerec1QaOnlineIdb(record.getId());
			
			result = qatofldao.insertQAOnlineToFollower(qatofl);
			
			return result;
		}	
		
		//get QA Online info for view
		@Override
		public QAOnlineWithBLOBs getQAOnlineInfo(String id) {
			QAOnlineWithBLOBs qaonline = qadao.selectQAOnlineByKey(id);
			return qaonline;
		}	

	//for examples
	@Resource
	private MemberDao dao;

	@Override
	public Member getMemberById(int memberId) {
		if(memberId <= 0){
			log.error("Invalid member id: " + memberId);
			return null;
		}
		Member member = dao.selectByPrimaryKey(new Integer(memberId));
		return member;
	}

	@Override
	public int setMember(Member member) {
		int result = dao.insertSelective(member);
		return result;
	}

}
