package com.bp.wei.crm.model;

import java.util.Date;

public class ParticDataToMember {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1ParticipateDataEc1Memberec1MemberIda;

    private String ec1ParticipateDataEc1Memberec1ParticipateDataIdb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getEc1ParticipateDataEc1Memberec1MemberIda() {
        return ec1ParticipateDataEc1Memberec1MemberIda;
    }

    public void setEc1ParticipateDataEc1Memberec1MemberIda(String ec1ParticipateDataEc1Memberec1MemberIda) {
        this.ec1ParticipateDataEc1Memberec1MemberIda = ec1ParticipateDataEc1Memberec1MemberIda == null ? null : ec1ParticipateDataEc1Memberec1MemberIda.trim();
    }

    public String getEc1ParticipateDataEc1Memberec1ParticipateDataIdb() {
        return ec1ParticipateDataEc1Memberec1ParticipateDataIdb;
    }

    public void setEc1ParticipateDataEc1Memberec1ParticipateDataIdb(String ec1ParticipateDataEc1Memberec1ParticipateDataIdb) {
        this.ec1ParticipateDataEc1Memberec1ParticipateDataIdb = ec1ParticipateDataEc1Memberec1ParticipateDataIdb == null ? null : ec1ParticipateDataEc1Memberec1ParticipateDataIdb.trim();
    }
}