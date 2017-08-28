package com.bp.wei.dao;

import com.bp.wei.crm.model.AnswerOption;

public interface AnswerOptionDao {
    int deleteByPrimaryKey(String id);

    int insert(AnswerOption record);

    int insertSelective(AnswerOption record);

    AnswerOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AnswerOption record);

    int updateByPrimaryKeyWithBLOBs(AnswerOption record);

    int updateByPrimaryKey(AnswerOption record);
}