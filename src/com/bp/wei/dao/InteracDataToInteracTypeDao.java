package com.bp.wei.dao;

import com.bp.wei.crm.model.InteracDataToInteracType;

public interface InteracDataToInteracTypeDao {
    int deleteByPrimaryKey(String id);

    int insert(InteracDataToInteracType record);

    int insertSelective(InteracDataToInteracType record);

    InteracDataToInteracType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InteracDataToInteracType record);

    int updateByPrimaryKey(InteracDataToInteracType record);
    
    //
    int insertInteractionDataToQuestion(InteracDataToInteracType idTty);
}