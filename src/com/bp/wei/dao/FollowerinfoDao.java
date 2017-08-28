package com.bp.wei.dao;

import com.bp.wei.crm.model.Followerinfo;

public interface FollowerinfoDao {
    int deleteByPrimaryKey(String id);

    int insert(Followerinfo record);

    int insertSelective(Followerinfo record);

    String selectByPrimaryOpenid(String wechatUserid);
    
    Followerinfo selectByPrimaryKey(String id);
    
    Followerinfo selectMyFollowerListByKey(String id);

    int updateByPrimaryKeySelective(Followerinfo record);

    int updateByPrimaryKeyWithBLOBs(Followerinfo record);

    int updateByPrimaryKey(Followerinfo record);
    
    int updateByFollowerID(Followerinfo record);
    
    //for get Follower id
    Followerinfo selectFollowerInfoByKey(String wechatUserid);
    
    //get follower QA Online List
    Followerinfo selectFollowerQAOnlineList(String id);
}