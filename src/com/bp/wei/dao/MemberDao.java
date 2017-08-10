package com.bp.wei.dao;

import com.bp.wei.crm.model.Member;

public interface MemberDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}
