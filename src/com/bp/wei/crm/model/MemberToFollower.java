package com.bp.wei.crm.model;

import java.util.Date;

public class MemberToFollower {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1MemberEc1Followerec1MemberIda;

    private String ec1MemberEc1Followerec1FollowerIdb;

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

    public String getEc1MemberEc1Followerec1MemberIda() {
        return ec1MemberEc1Followerec1MemberIda;
    }

    public void setEc1MemberEc1Followerec1MemberIda(String ec1MemberEc1Followerec1MemberIda) {
        this.ec1MemberEc1Followerec1MemberIda = ec1MemberEc1Followerec1MemberIda == null ? null : ec1MemberEc1Followerec1MemberIda.trim();
    }

    public String getEc1MemberEc1Followerec1FollowerIdb() {
        return ec1MemberEc1Followerec1FollowerIdb;
    }

    public void setEc1MemberEc1Followerec1FollowerIdb(String ec1MemberEc1Followerec1FollowerIdb) {
        this.ec1MemberEc1Followerec1FollowerIdb = ec1MemberEc1Followerec1FollowerIdb == null ? null : ec1MemberEc1Followerec1FollowerIdb.trim();
    }
}