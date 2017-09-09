package com.bp.wei.dao;

import com.bp.wei.crm.model.ContactUS;

public interface ContactUSDao {
    int deleteByPrimaryKey(String id);

    int insert(ContactUS record);

    int insertSelective(ContactUS record);

    ContactUS selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContactUS record);

    int updateByPrimaryKeyWithBLOBs(ContactUS record);

    int updateByPrimaryKey(ContactUS record);
    
    //insert contact us Info
    int insertContactUSInfo(ContactUS record);
    
    //select QA Online info
    ContactUS selectContactUSInfoByKey(String id);
}