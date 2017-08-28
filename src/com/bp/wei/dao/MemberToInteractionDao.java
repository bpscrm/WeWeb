package com.bp.wei.dao;

import com.bp.wei.crm.model.MemberToInteraction;

public interface MemberToInteractionDao {
    int deleteByPrimaryKey(String id);

    int insert(MemberToInteraction record);

    int insertSelective(MemberToInteraction record);

    MemberToInteraction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberToInteraction record);

    int updateByPrimaryKey(MemberToInteraction record);
    
    //
    int insertMemberToInteraction(MemberToInteraction mbTit);
}