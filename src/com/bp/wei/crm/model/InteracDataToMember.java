package com.bp.wei.crm.model;

import java.util.Date;

public class InteracDataToMember {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1InteractionDataEc1Memberec1MemberIda;

    private String ec1InteractionDataEc1Memberec1InteractionDataIdb;

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

    public String getEc1InteractionDataEc1Memberec1MemberIda() {
        return ec1InteractionDataEc1Memberec1MemberIda;
    }

    public void setEc1InteractionDataEc1Memberec1MemberIda(String ec1InteractionDataEc1Memberec1MemberIda) {
        this.ec1InteractionDataEc1Memberec1MemberIda = ec1InteractionDataEc1Memberec1MemberIda == null ? null : ec1InteractionDataEc1Memberec1MemberIda.trim();
    }

    public String getEc1InteractionDataEc1Memberec1InteractionDataIdb() {
        return ec1InteractionDataEc1Memberec1InteractionDataIdb;
    }

    public void setEc1InteractionDataEc1Memberec1InteractionDataIdb(String ec1InteractionDataEc1Memberec1InteractionDataIdb) {
        this.ec1InteractionDataEc1Memberec1InteractionDataIdb = ec1InteractionDataEc1Memberec1InteractionDataIdb == null ? null : ec1InteractionDataEc1Memberec1InteractionDataIdb.trim();
    }
}