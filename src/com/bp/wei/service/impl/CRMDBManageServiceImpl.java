package com.bp.wei.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.dao.ChildToMemberDao;
import com.bp.wei.dao.ChildinfoDao;
import com.bp.wei.dao.FeedbackDao;
import com.bp.wei.dao.FeedbackToPurchaseDao;
import com.bp.wei.dao.MemberDao;
import com.bp.wei.dao.MemberinfoDao;
import com.bp.wei.dao.FollowerinfoDao;
import com.bp.wei.dao.MemberToFollowerDao;
import com.bp.wei.dao.PurchaseinfoDao;
import com.bp.wei.dao.QAOnlineDao;
import com.bp.wei.dao.QAOnlineToFollowerDao;
import com.bp.wei.crm.model.Followerinfo;
import com.bp.wei.crm.model.Member;
import com.bp.wei.crm.model.MemberToFollower;
import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;
import com.bp.wei.crm.model.QAOnlineToFollower;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;
import com.bp.wei.crm.model.ChildToMember;
import com.bp.wei.crm.model.Childinfo;
import com.bp.wei.crm.model.FeedbackToPurchase;
import com.bp.wei.crm.model.FeedbackWithBLOBs;
import com.bp.wei.crm.model.Purchaseinfo;
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
	
	@Resource
	private ChildinfoDao cdao;
	
	@Resource
	private ChildToMemberDao ctmdao;
	
	@Resource
	private FeedbackDao fdao;
	
	@Resource
	private PurchaseinfoDao pdao;
	
	@Resource
	private FeedbackToPurchaseDao ftpdao;
	
	////////////////for follower
	//myfollower
	public Followerinfo getFollowerlist(String id) {
		Followerinfo followerinfo = fldao.selectMyFollowerListByKey(id);
		return followerinfo;
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

	//////////////////////////////////////////////////////////for member
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
	
	////////////////for child
	//insert
	public int insertChildinfo(Childinfo childinfo, String mbid) {
	
		int result = cdao.insert(childinfo);
		
		String mbID = mbid;
		
		ChildToMember cdTomb = new ChildToMember();
		cdTomb.setEc1ChildDataEc1Memberec1MemberIda(mbID);
		cdTomb.setEc1ChildDataEc1Memberec1ChildDataIdb(childinfo.getId());
		
		result = ctmdao.insert(cdTomb);
		
		return result;
	}
	//search
	public Memberinfo getMemberWithChildren(String memberId) {
		Memberinfo member = mbdao.selectChildrenByKey(memberId);
		return member;
	}
	public Childinfo getchildinfo(String id) {
		if(id.length() <= 0){
			log.error("Invalid child id: " + id);
			return null;
		}
		Childinfo childinfo = cdao.selectByPrimaryKey(new String(id));
		return childinfo;
	}
	//update
	public int updateChildinfo(Childinfo childinfo) {
		int result = cdao.updateByPrimaryKeyWithBLOBs(childinfo);
		
		return result;
	}

	////////////////for Purchase
	//search
	public Memberinfo getMemberWithPurchase(String id) {
		Memberinfo member = mbdao.selectPurchaseByKey(id);
		return member;
	}
	public Purchaseinfo getPurchaseInfo(String id) {
		Purchaseinfo purinfo = pdao.selectPurchaseinfoByKey(id);
		return purinfo;
	}
	
	////////////////for feedbacks
	//insert
	public int insertFeedbackinfo(FeedbackWithBLOBs feedbackinfo, String purchaseid) {
	
		int result = fdao.insert(feedbackinfo);
		
		String purID = purchaseid;
		
		FeedbackToPurchase fdToPCH = new FeedbackToPurchase();
		
		fdToPCH.setEc1FeedbackEc1PurchaseDataec1PurchaseDataIda(purID);
		fdToPCH.setEc1FeedbackEc1PurchaseDataec1FeedbackIdb(feedbackinfo.getId());
		
		result = ftpdao.insert(fdToPCH);
		
		return result;
	}
	//search
	public Purchaseinfo getFeedbacklist(String id) {
		Purchaseinfo purinfo = pdao.selectFeedbacklistByKey(id);
		return purinfo;
	}
	public FeedbackWithBLOBs getFeedbackinfobyid(String id) {
		System.out.println("@@@@@@@@@@@@@@feedback id: " + id);
		if(id.length() <= 0){
			log.error("Invalid fb id: " + id);
			return null;
		}
		FeedbackWithBLOBs feedbackinfo = fdao.selectFeedbackByid(new String(id));
		return feedbackinfo;
	}
	//update
	public int updateFeedbackinfo(FeedbackWithBLOBs feedbackinfo) {
		
		System.out.println("@@@@@@@@@@@@@@feedback: " + feedbackinfo.getName());
		
		int result = fdao.updateByPrimaryKeyWithBLOBs(feedbackinfo);
		
		return result;
	}
	

	/////////////////////////////////////////////////////////////////////for examples
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
