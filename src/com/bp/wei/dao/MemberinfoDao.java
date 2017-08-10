package com.bp.wei.dao;

import com.bp.wei.crm.model.Memberinfo;
import com.bp.wei.crm.model.MemberinfoWithBLOBs;

public interface MemberinfoDao {
    int deleteByPrimaryKey(String id);

    int insert(MemberinfoWithBLOBs record);

    int insertSelective(MemberinfoWithBLOBs record);

    MemberinfoWithBLOBs selectByPrimaryKey(String id);
    
    MemberinfoWithBLOBs selectByMemberName(String name);
    
    String selectIDByMember(String name);

    int updateByPrimaryKeySelective(MemberinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MemberinfoWithBLOBs record);

    int updateByPrimaryKey(Memberinfo record);
    
    Memberinfo selectChildrenByKey(String id);
    
    Memberinfo selectPurchaseByKey(String id);
}