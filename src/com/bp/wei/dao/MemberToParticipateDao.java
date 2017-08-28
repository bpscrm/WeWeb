package com.bp.wei.dao;

import com.bp.wei.crm.model.MemberToParticipate;

public interface MemberToParticipateDao {
    int deleteByPrimaryKey(String id);

    int insert(MemberToParticipate record);

    int insertSelective(MemberToParticipate record);

    MemberToParticipate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberToParticipate record);

    int updateByPrimaryKey(MemberToParticipate record);
    
    int insertMemberToParticipate(MemberToParticipate record);
}