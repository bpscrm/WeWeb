package com.bp.wei.dao;

import com.bp.wei.crm.model.InteracDataToInteracAnswer;

public interface InteracDataToInteracAnswerDao {
    int deleteByPrimaryKey(String id);

    int insert(InteracDataToInteracAnswer record);

    int insertSelective(InteracDataToInteracAnswer record);

    InteracDataToInteracAnswer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InteracDataToInteracAnswer record);

    int updateByPrimaryKey(InteracDataToInteracAnswer record);
    
    //
    int insertInteractionDataToAnswer(InteracDataToInteracAnswer idTar);
}