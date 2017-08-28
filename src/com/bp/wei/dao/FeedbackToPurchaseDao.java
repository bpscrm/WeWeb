package com.bp.wei.dao;

import com.bp.wei.crm.model.FeedbackToPurchase;

public interface FeedbackToPurchaseDao {
    int deleteByPrimaryKey(String id);

    int insert(FeedbackToPurchase record);

    int insertSelective(FeedbackToPurchase record);

    FeedbackToPurchase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FeedbackToPurchase record);

    int updateByPrimaryKey(FeedbackToPurchase record);
}