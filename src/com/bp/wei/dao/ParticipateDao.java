package com.bp.wei.dao;

import com.bp.wei.crm.model.Participate;

public interface ParticipateDao {
    int deleteByPrimaryKey(String id);

    int insert(Participate record);

    int insertSelective(Participate record);

    Participate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Participate record);

    int updateByPrimaryKeyWithBLOBs(Participate record);

    int updateByPrimaryKey(Participate record);
    
    String selectParticipateInfo(String id);
}