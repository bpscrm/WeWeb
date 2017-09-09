package com.bp.wei.crm.model;

import java.util.Date;

public class ContactUSToMember {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1ContactusEc1Memberec1MemberIda;

    private String ec1ContactusEc1Memberec1ContactusIdb;

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

    public String getEc1ContactusEc1Memberec1MemberIda() {
        return ec1ContactusEc1Memberec1MemberIda;
    }

    public void setEc1ContactusEc1Memberec1MemberIda(String ec1ContactusEc1Memberec1MemberIda) {
        this.ec1ContactusEc1Memberec1MemberIda = ec1ContactusEc1Memberec1MemberIda == null ? null : ec1ContactusEc1Memberec1MemberIda.trim();
    }

    public String getEc1ContactusEc1Memberec1ContactusIdb() {
        return ec1ContactusEc1Memberec1ContactusIdb;
    }

    public void setEc1ContactusEc1Memberec1ContactusIdb(String ec1ContactusEc1Memberec1ContactusIdb) {
        this.ec1ContactusEc1Memberec1ContactusIdb = ec1ContactusEc1Memberec1ContactusIdb == null ? null : ec1ContactusEc1Memberec1ContactusIdb.trim();
    }
}