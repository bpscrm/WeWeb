package com.bp.wei.dao;

import com.bp.wei.crm.model.ParticDataToPartic;

public interface ParticDataToParticDao {
    int deleteByPrimaryKey(String id);

    int insert(ParticDataToPartic record);

    int insertSelective(ParticDataToPartic record);

    ParticDataToPartic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ParticDataToPartic record);

    int updateByPrimaryKey(ParticDataToPartic record);
    
    int insertParticDataToPartic(ParticDataToPartic record);
}