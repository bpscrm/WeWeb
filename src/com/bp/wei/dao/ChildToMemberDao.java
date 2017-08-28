package com.bp.wei.dao;

import com.bp.wei.crm.model.ChildToMember;

public interface ChildToMemberDao {
    int deleteByPrimaryKey(String id);

    int insert(ChildToMember record);

    int insertSelective(ChildToMember record);

    ChildToMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChildToMember record);

    int updateByPrimaryKey(ChildToMember record);
}