package com.bp.wei.crm.model;

import java.util.Date;

public class MemberToParticipate {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1MemberEc1Participateec1ParticipateIda;

    private String ec1MemberEc1Participateec1MemberIdb;

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

    public String getEc1MemberEc1Participateec1ParticipateIda() {
        return ec1MemberEc1Participateec1ParticipateIda;
    }

    public void setEc1MemberEc1Participateec1ParticipateIda(String ec1MemberEc1Participateec1ParticipateIda) {
        this.ec1MemberEc1Participateec1ParticipateIda = ec1MemberEc1Participateec1ParticipateIda == null ? null : ec1MemberEc1Participateec1ParticipateIda.trim();
    }

    public String getEc1MemberEc1Participateec1MemberIdb() {
        return ec1MemberEc1Participateec1MemberIdb;
    }

    public void setEc1MemberEc1Participateec1MemberIdb(String ec1MemberEc1Participateec1MemberIdb) {
        this.ec1MemberEc1Participateec1MemberIdb = ec1MemberEc1Participateec1MemberIdb == null ? null : ec1MemberEc1Participateec1MemberIdb.trim();
    }
}