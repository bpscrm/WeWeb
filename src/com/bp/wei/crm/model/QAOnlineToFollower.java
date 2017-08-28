package com.bp.wei.crm.model;

import java.util.Date;

public class QAOnlineToFollower {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1QaOnlineEc1Followerec1FollowerIda;

    private String ec1QaOnlineEc1Followerec1QaOnlineIdb;

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

    public String getEc1QaOnlineEc1Followerec1FollowerIda() {
        return ec1QaOnlineEc1Followerec1FollowerIda;
    }

    public void setEc1QaOnlineEc1Followerec1FollowerIda(String ec1QaOnlineEc1Followerec1FollowerIda) {
        this.ec1QaOnlineEc1Followerec1FollowerIda = ec1QaOnlineEc1Followerec1FollowerIda == null ? null : ec1QaOnlineEc1Followerec1FollowerIda.trim();
    }

    public String getEc1QaOnlineEc1Followerec1QaOnlineIdb() {
        return ec1QaOnlineEc1Followerec1QaOnlineIdb;
    }

    public void setEc1QaOnlineEc1Followerec1QaOnlineIdb(String ec1QaOnlineEc1Followerec1QaOnlineIdb) {
        this.ec1QaOnlineEc1Followerec1QaOnlineIdb = ec1QaOnlineEc1Followerec1QaOnlineIdb == null ? null : ec1QaOnlineEc1Followerec1QaOnlineIdb.trim();
    }
}