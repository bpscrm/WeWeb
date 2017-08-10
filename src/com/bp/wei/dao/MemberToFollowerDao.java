package com.bp.wei.dao;

import com.bp.wei.crm.model.MemberToFollower;

public interface MemberToFollowerDao {
    int deleteByPrimaryKey(String id);

    int insert(MemberToFollower record);

    int insertSelective(MemberToFollower record);

    MemberToFollower selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberToFollower record);

    int updateByPrimaryKey(MemberToFollower record);
}