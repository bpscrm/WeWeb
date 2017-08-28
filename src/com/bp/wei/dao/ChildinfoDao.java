package com.bp.wei.dao;

import com.bp.wei.crm.model.Childinfo;

public interface ChildinfoDao {
    int deleteByPrimaryKey(String id);

    int insert(Childinfo record);

    int insertSelective(Childinfo record);

    Childinfo selectByPrimaryKey(String id);
    
    Childinfo selectByChildName(String name);

    int updateByPrimaryKeySelective(Childinfo record);

    int updateByPrimaryKeyWithBLOBs(Childinfo record);

    int updateByPrimaryKey(Childinfo record);
}