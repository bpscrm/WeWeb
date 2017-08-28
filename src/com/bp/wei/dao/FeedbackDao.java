package com.bp.wei.dao;

import com.bp.wei.crm.model.Feedback;
import com.bp.wei.crm.model.FeedbackWithBLOBs;

public interface FeedbackDao {
    int deleteByPrimaryKey(String id);

    int insert(FeedbackWithBLOBs record);

    int insertSelective(FeedbackWithBLOBs record);

    FeedbackWithBLOBs selectByPrimaryKey(String id);
    
    FeedbackWithBLOBs selectFeedbackByid(String id);

    int updateByPrimaryKeySelective(FeedbackWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FeedbackWithBLOBs record);

    int updateByPrimaryKey(Feedback record);
}