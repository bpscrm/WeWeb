package com.bp.wei.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bp.wei.dao.ChildToMemberDao;
import com.bp.wei.dao.ChildinfoDao;
import com.bp.wei.dao.FeedbackDao;
import com.bp.wei.dao.FeedbackToPurchaseDao;
import com.bp.wei.dao.InteracDataToInteracAnswerDao;
import com.bp.wei.dao.InteracDataToInteracDao;
import com.bp.wei.dao.InteracDataToInteracTypeDao;
import com.bp.wei.dao.InteracDataToMemberDao;
import com.bp.wei.dao.InteractionDataDao;
import com.bp.wei.dao.MarketinginfoDao;
import com.bp.wei.dao.MemberDao;
import com.bp.wei.dao.MemberToInteractionDao;
import com.bp.wei.dao.MemberToParticipateDao;
import com.bp.wei.dao.MemberinfoDao;
import com.bp.wei.dao.FollowerinfoDao;
import com.bp.wei.dao.MemberToFollowerDao;
import com.bp.wei.dao.ParticDataToMemberDao;
import com.bp.wei.dao.ParticDataToParticDao;
import com.bp.wei.dao.ParticDataToParticTypeDao;
import com.bp.wei.dao.ParticipateDao;
import com.bp.wei.dao.ParticipateDataDao;
import com.bp.wei.dao.PurchaseinfoDao;
import com.bp.wei.dao.QAOnlineDao;
import com.bp.wei.dao.QAOnlineToFollowerDao;
import com.bp.wei.dao.QuestionnaireDao;
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
import com.bp.wei.crm.model.InteracDataToInterac;
import com.bp.wei.crm.model.InteracDataToInteracAnswer;
import com.bp.wei.crm.model.InteracDataToInteracType;
import com.bp.wei.crm.model.InteracDataToMember;
import com.bp.wei.crm.model.InteractionData;
import com.bp.wei.crm.model.Marketinginfo;
import com.bp.wei.crm.model.MarketinginfoWithBLOBs;
import com.bp.wei.crm.model.MemberToInteraction;
import com.bp.wei.crm.model.MemberToParticipate;
import com.bp.wei.crm.model.ParticDataToMember;
import com.bp.wei.crm.model.ParticDataToPartic;
import com.bp.wei.crm.model.ParticDataToParticType;
import com.bp.wei.crm.model.ParticipateData;
import com.bp.wei.crm.model.Questionnaire;
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
	
	@Resource
	private QuestionnaireDao qDao;
	
	@Resource
	private MarketinginfoDao mkDao;	
	
	//保存互动结果
	@Resource
	private InteractionDataDao idDao;
	
	@Resource
	private InteracDataToInteracAnswerDao idTarDao;
	
	@Resource
	private InteracDataToInteracTypeDao idTtyDao;
	
	@Resource
	private InteracDataToInteracDao idTitDao;
	
	@Resource
	private InteracDataToMemberDao idTmbDao;
	
	@Resource
	private MemberToInteractionDao mbTitDao;	
	
	//保存体验结果
	@Resource
	private ParticipateDao pcDao;	
	
	@Resource
	private ParticipateDataDao pdDao;
	
	@Resource
	private ParticDataToParticTypeDao pdTptDao;
	
	@Resource
	private ParticDataToParticDao pdTpcDao;
	
	@Resource
	private ParticDataToMemberDao pdTmbDao;
	
	@Resource
	private MemberToParticipateDao mbTpcDao;
	
	////////////////for follower
	//my follower
	public Followerinfo getFollowerlist(String id) {
		Followerinfo followerinfo = fldao.selectMyFollowerListByKey(id);
		return followerinfo;
	}

	//search follower
	public Followerinfo getFollowerInfo(String wechatUserid) {
		Followerinfo followerinfo = fldao.selectFollowerInfoByKey(wechatUserid);
		return followerinfo;
	}
	
	
	/////////////////////////////////////////////////////////////你问我答
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
	//search follower
	public MemberinfoWithBLOBs getMemberInfo(String followid){
		MemberinfoWithBLOBs memberinfo = mbdao.selectMemberInfoByFLID(followid);
		return memberinfo;
	}
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
	public MemberinfoWithBLOBs getMemberinfobyMBID(String id) {
		if(id.length() <= 0){
			log.error("Invalid member name: " + id);
			return null;
		}
		MemberinfoWithBLOBs memberinfo = mbdao.selectByMemberID(new String(id));
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
	

	/////////////////////////////////////////////////////////////////////for 营销活动
	//search 
	@Override
	public Marketinginfo getMarketinglist() {
		Marketinginfo marketing = mkDao.selecAllMarketingList();
		System.out.println("@@@@@@@@@@@@@@marketing : " + marketing.getId());
		return marketing;
	}
	@Override
	public MarketinginfoWithBLOBs getMarketing(String id){
		MarketinginfoWithBLOBs marketing = mkDao.selectMarketingInfo(id);
		System.out.println("@@@@@@@@@@@@@@marketing : " + marketing.getId());
		return marketing;
	}
	@Override
	public Questionnaire getQuestionnaireById(String id) {
		if(id == null || id.length() <= 0){
			log.error("Invalid questionnaire id： " + id);
			return null;
		}
		Questionnaire questionnaire = qDao.selectByPrimaryKeyWithQA(id);
		if(questionnaire == null){
			log.error("Questionnaire with id :" + id + " does not exist.");
		}
		return questionnaire;
	}	

	//save Interaction Data
	@Override
	public boolean setInteractionData(HttpServletRequest request) {
		
		String mkid = request.getParameter("mkname");
		String surveryId = request.getParameter("sid");
		String mbid = "ed354dcd-7980-11e7-9bd6-201a06c68160";
		System.out.println("mkkkkkkkkkkkkkkkkk id: " + mkid);
		
		int i = 1;
		boolean hasnext = true;
		while(hasnext){
			String questionId = request.getParameter("qid_" + i);
			System.out.println("question id: " + questionId);
			if(questionId != null && questionId.length() > 0){
				String answer = request.getParameter(questionId);
				System.out.println("answer id:。。。。。。。。。。 " + answer);
				
				//insert Interaction Data
				InteractionData iddata = new InteractionData();
				iddata.setName("互动资料");
				
				int result = idDao.insertInteractionData(iddata);
				
				String interactionDataID = iddata.getId();
				System.out.println("interactionData id:。。。。。。。。。。 " + interactionDataID);
				
				//Interaction Data 关联 问卷答案
				InteracDataToInteracAnswer idTar = new InteracDataToInteracAnswer();
				idTar.setEc1InteractionDataEc1InteractionAskec1InteractionDataIdb(interactionDataID);
				idTar.setEc1InteractionDataEc1InteractionAskec1InteractionAskIda(answer);				
				
				result = idTarDao.insertInteractionDataToAnswer(idTar);
				
				//Interaction Data 关联 问卷问题
				InteracDataToInteracType idTty = new InteracDataToInteracType();
				idTty.setEc1Intera3de5onDataIdb(interactionDataID);
				idTty.setEc1Interab268onTypeIda(questionId);				
				
				result = idTtyDao.insertInteractionDataToQuestion(idTty);
				
				//Interaction Data 关联 问卷
				InteracDataToInterac idTit = new InteracDataToInterac();
				idTit.setEc1InteractionDataEc1Interactionec1InteractionDataIdb(interactionDataID);
				idTit.setEc1InteractionDataEc1Interactionec1InteractionIda(surveryId);	
				
				result = idTitDao.insertInteractionDataToInteraction(idTit);
				
				//Interaction Data 关联 会员
				InteracDataToMember idTmb = new InteracDataToMember();
				idTmb.setEc1InteractionDataEc1Memberec1InteractionDataIdb(interactionDataID);
				idTmb.setEc1InteractionDataEc1Memberec1MemberIda(mbid);	
				
				result = idTmbDao.insertInteractionDataToMember(idTmb);
				
				i ++;
			}else{
				hasnext = false;
			}
		}
		
		//会员 关联 互动（参与此互动的会员清单）
		MemberToInteraction mbTit = new MemberToInteraction();
		mbTit.setEc1MemberEc1Interactionec1MemberIdb(mbid);
		mbTit.setEc1MemberEc1Interactionec1InteractionIda(surveryId);			
		
		int result = mbTitDao.insertMemberToInteraction(mbTit);
		
		return true;
		
	}
	
	//get marketing info for sign in	
	@Override
	public MarketinginfoWithBLOBs getMarketingForSignin(String id){
		System.out.println("@@@@@@@@@@@@@@marketing : " + id);
		MarketinginfoWithBLOBs marketing = mkDao.selectMarketingInfoForSignin(id);
		System.out.println("@@@@@@@@@@@@@@marketing : " + marketing.getId());
		return marketing;
	}
	//save 体验  Data
	@Override
	public boolean setParticipateData(HttpServletRequest request) {
		
		String marketingId = request.getParameter("mkname");		
		String memberId = request.getParameter("mbname");
		String particId = request.getParameter("particname");

		//get participate type
		String particTypeId = pcDao.selectParticipateInfo(particId);
		System.out.println("@@@@@@@@@@@@@@ Participate type ID : " + particTypeId);
		
		//insert participate data
		ParticipateData pddata = new ParticipateData();
		pddata.setName("体验资料");
		
		int result = pdDao.insertParticipateData(pddata);	
		String particDataId = pddata.getId();
		System.out.println("@@@@@@@@@@@@@@ Participate data ID : " + particDataId);
		
		//participate Data 关联  participate type
		ParticDataToParticType pdTpt = new ParticDataToParticType();
		pdTpt.setEc1Partic0cbeteTypeIda(particTypeId);
		pdTpt.setEc1Partic180eteDataIdb(particDataId);				
		
		result = pdTptDao.insertParticDataToParticType(pdTpt);
		
		//participate Data 关联  participate 
		ParticDataToPartic pdTpc = new ParticDataToPartic();
		pdTpc.setEc1ParticipateDataEc1Participateec1ParticipateIda(particId);
		pdTpc.setEc1ParticipateDataEc1Participateec1ParticipateDataIdb(particDataId);				
		
		result = pdTpcDao.insertParticDataToPartic(pdTpc);		
		
		//participate Data 关联  member
		ParticDataToMember pdTmb = new ParticDataToMember();
		pdTmb.setEc1ParticipateDataEc1Memberec1MemberIda(memberId);
		pdTmb.setEc1ParticipateDataEc1Memberec1ParticipateDataIdb(particDataId);				
		
		result = pdTmbDao.insertParticDataToMember(pdTmb);		
		
		//member 关联  participate 
		MemberToParticipate mbTpc = new MemberToParticipate();
		mbTpc.setEc1MemberEc1Participateec1ParticipateIda(particId);
		mbTpc.setEc1MemberEc1Participateec1MemberIdb(memberId);				
		
		result = mbTpcDao.insertMemberToParticipate(mbTpc);		
		 		 
		return true;
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
