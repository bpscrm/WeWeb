package com.bp.wei.dao;

import com.bp.wei.crm.model.ContactUSToMember;

public interface ContactUSToMemberDao {
    int deleteByPrimaryKey(String id);

    int insert(ContactUSToMember record);

    int insertSelective(ContactUSToMember record);

    ContactUSToMember selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContactUSToMember record);

    int updateByPrimaryKey(ContactUSToMember record);
    
    //insert relation to member
    int insertContactUSToMember(ContactUSToMember record);
}