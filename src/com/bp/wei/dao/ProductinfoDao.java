package com.bp.wei.dao;

import com.bp.wei.crm.model.Productinfo;

public interface ProductinfoDao {
    int deleteByPrimaryKey(String id);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKeyWithBLOBs(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}