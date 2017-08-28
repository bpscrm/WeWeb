package com.bp.wei.dao;

import com.bp.wei.crm.model.InteracDataToInterac;

public interface InteracDataToInteracDao {
    int deleteByPrimaryKey(String id);

    int insert(InteracDataToInterac record);

    int insertSelective(InteracDataToInterac record);

    InteracDataToInterac selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InteracDataToInterac record);

    int updateByPrimaryKey(InteracDataToInterac record);
    
    //
    int insertInteractionDataToInteraction(InteracDataToInterac idTit);
}