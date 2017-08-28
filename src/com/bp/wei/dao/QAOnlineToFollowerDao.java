package com.bp.wei.dao;

import com.bp.wei.crm.model.QAOnlineToFollower;

public interface QAOnlineToFollowerDao {
    int deleteByPrimaryKey(String id);

    int insert(QAOnlineToFollower record);

    int insertSelective(QAOnlineToFollower record);

    QAOnlineToFollower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QAOnlineToFollower record);

    int updateByPrimaryKey(QAOnlineToFollower record);
    
    //insert relation to follower
    int insertQAOnlineToFollower(QAOnlineToFollower record);
}