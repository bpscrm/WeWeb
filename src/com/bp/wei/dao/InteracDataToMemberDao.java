package com.bp.wei.dao;

import com.bp.wei.crm.model.InteracDataToMember;

public interface InteracDataToMemberDao {
    int deleteByPrimaryKey(String id);

    int insert(InteracDataToMember record);

    int insertSelective(InteracDataToMember record);

    InteracDataToMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InteracDataToMember record);

    int updateByPrimaryKey(InteracDataToMember record);
    
    //
    int insertInteractionDataToMember(InteracDataToMember idTmb);
}