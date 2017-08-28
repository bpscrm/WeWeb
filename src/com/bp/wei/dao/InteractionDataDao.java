package com.bp.wei.dao;

import com.bp.wei.crm.model.InteractionData;

public interface InteractionDataDao {
    int deleteByPrimaryKey(String id);

    int insert(InteractionData record);

    int insertSelective(InteractionData record);

    InteractionData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InteractionData record);

    int updateByPrimaryKeyWithBLOBs(InteractionData record);

    int updateByPrimaryKey(InteractionData record);
    
    //
    int insertInteractionData(InteractionData iddata);
}