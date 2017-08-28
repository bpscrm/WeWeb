package com.bp.wei.crm.model;

import java.util.Date;

public class InteracDataToInteracAnswer {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1InteractionDataEc1InteractionAskec1InteractionAskIda;

    private String ec1InteractionDataEc1InteractionAskec1InteractionDataIdb;

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

    public String getEc1InteractionDataEc1InteractionAskec1InteractionAskIda() {
        return ec1InteractionDataEc1InteractionAskec1InteractionAskIda;
    }

    public void setEc1InteractionDataEc1InteractionAskec1InteractionAskIda(String ec1InteractionDataEc1InteractionAskec1InteractionAskIda) {
        this.ec1InteractionDataEc1InteractionAskec1InteractionAskIda = ec1InteractionDataEc1InteractionAskec1InteractionAskIda == null ? null : ec1InteractionDataEc1InteractionAskec1InteractionAskIda.trim();
    }

    public String getEc1InteractionDataEc1InteractionAskec1InteractionDataIdb() {
        return ec1InteractionDataEc1InteractionAskec1InteractionDataIdb;
    }

    public void setEc1InteractionDataEc1InteractionAskec1InteractionDataIdb(String ec1InteractionDataEc1InteractionAskec1InteractionDataIdb) {
        this.ec1InteractionDataEc1InteractionAskec1InteractionDataIdb = ec1InteractionDataEc1InteractionAskec1InteractionDataIdb == null ? null : ec1InteractionDataEc1InteractionAskec1InteractionDataIdb.trim();
    }
}