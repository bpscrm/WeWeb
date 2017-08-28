package com.bp.wei.crm.model;

import java.util.Date;

public class ChildToMember {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1ChildDataEc1Memberec1MemberIda;

    private String ec1ChildDataEc1Memberec1ChildDataIdb;

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

    public String getEc1ChildDataEc1Memberec1MemberIda() {
        return ec1ChildDataEc1Memberec1MemberIda;
    }

    public void setEc1ChildDataEc1Memberec1MemberIda(String ec1ChildDataEc1Memberec1MemberIda) {
        this.ec1ChildDataEc1Memberec1MemberIda = ec1ChildDataEc1Memberec1MemberIda == null ? null : ec1ChildDataEc1Memberec1MemberIda.trim();
    }

    public String getEc1ChildDataEc1Memberec1ChildDataIdb() {
        return ec1ChildDataEc1Memberec1ChildDataIdb;
    }

    public void setEc1ChildDataEc1Memberec1ChildDataIdb(String ec1ChildDataEc1Memberec1ChildDataIdb) {
        this.ec1ChildDataEc1Memberec1ChildDataIdb = ec1ChildDataEc1Memberec1ChildDataIdb == null ? null : ec1ChildDataEc1Memberec1ChildDataIdb.trim();
    }
}