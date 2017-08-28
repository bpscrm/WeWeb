package com.bp.wei.crm.model;

import java.util.Date;

public class MemberToInteraction {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1MemberEc1Interactionec1InteractionIda;

    private String ec1MemberEc1Interactionec1MemberIdb;

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

    public String getEc1MemberEc1Interactionec1InteractionIda() {
        return ec1MemberEc1Interactionec1InteractionIda;
    }

    public void setEc1MemberEc1Interactionec1InteractionIda(String ec1MemberEc1Interactionec1InteractionIda) {
        this.ec1MemberEc1Interactionec1InteractionIda = ec1MemberEc1Interactionec1InteractionIda == null ? null : ec1MemberEc1Interactionec1InteractionIda.trim();
    }

    public String getEc1MemberEc1Interactionec1MemberIdb() {
        return ec1MemberEc1Interactionec1MemberIdb;
    }

    public void setEc1MemberEc1Interactionec1MemberIdb(String ec1MemberEc1Interactionec1MemberIdb) {
        this.ec1MemberEc1Interactionec1MemberIdb = ec1MemberEc1Interactionec1MemberIdb == null ? null : ec1MemberEc1Interactionec1MemberIdb.trim();
    }
}