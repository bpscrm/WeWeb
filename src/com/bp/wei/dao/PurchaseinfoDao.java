package com.bp.wei.dao;

import com.bp.wei.crm.model.Purchaseinfo;

public interface PurchaseinfoDao {
    int deleteByPrimaryKey(String id);

    int insert(Purchaseinfo record);

    int insertSelective(Purchaseinfo record);

    Purchaseinfo selectByPrimaryKey(String id);
    
    Purchaseinfo selectPurchaseinfoByKey(String id);
    
    Purchaseinfo selectFeedbacklistByKey(String id);
    
    String selectIDByMember(String name);

    int updateByPrimaryKeySelective(Purchaseinfo record);

    int updateByPrimaryKeyWithBLOBs(Purchaseinfo record);

    int updateByPrimaryKey(Purchaseinfo record);

}