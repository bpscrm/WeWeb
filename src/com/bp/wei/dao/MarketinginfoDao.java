package com.bp.wei.dao;

import com.bp.wei.crm.model.Marketinginfo;
import com.bp.wei.crm.model.MarketinginfoWithBLOBs;

public interface MarketinginfoDao {
    int deleteByPrimaryKey(String id);

    int insert(MarketinginfoWithBLOBs record);

    int insertSelective(MarketinginfoWithBLOBs record);

    MarketinginfoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MarketinginfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MarketinginfoWithBLOBs record);

    int updateByPrimaryKey(Marketinginfo record);
    
    
    Marketinginfo selecAllMarketingList();
    
    MarketinginfoWithBLOBs selectMarketingInfo(String id);
    
    MarketinginfoWithBLOBs selectMarketingInfoForSignin(String id);
    
}