package com.bp.wei.dao;

import com.bp.wei.crm.model.QAOnline;
import com.bp.wei.crm.model.QAOnlineWithBLOBs;

public interface QAOnlineDao {
    int deleteByPrimaryKey(String id);

    int insert(QAOnlineWithBLOBs record);

    int insertSelective(QAOnlineWithBLOBs record);

    QAOnlineWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QAOnlineWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QAOnlineWithBLOBs record);

    int updateByPrimaryKey(QAOnline record);
    
    //insert QA Online Info
    int insertQAOnlineInfo(QAOnlineWithBLOBs record);
    
    //select QA Online info
    QAOnlineWithBLOBs selectQAOnlineByKey(String id);
}