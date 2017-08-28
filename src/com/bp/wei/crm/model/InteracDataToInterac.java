package com.bp.wei.crm.model;

import java.util.Date;

public class InteracDataToInterac {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1InteractionDataEc1Interactionec1InteractionIda;

    private String ec1InteractionDataEc1Interactionec1InteractionDataIdb;

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

    public String getEc1InteractionDataEc1Interactionec1InteractionIda() {
        return ec1InteractionDataEc1Interactionec1InteractionIda;
    }

    public void setEc1InteractionDataEc1Interactionec1InteractionIda(String ec1InteractionDataEc1Interactionec1InteractionIda) {
        this.ec1InteractionDataEc1Interactionec1InteractionIda = ec1InteractionDataEc1Interactionec1InteractionIda == null ? null : ec1InteractionDataEc1Interactionec1InteractionIda.trim();
    }

    public String getEc1InteractionDataEc1Interactionec1InteractionDataIdb() {
        return ec1InteractionDataEc1Interactionec1InteractionDataIdb;
    }

    public void setEc1InteractionDataEc1Interactionec1InteractionDataIdb(String ec1InteractionDataEc1Interactionec1InteractionDataIdb) {
        this.ec1InteractionDataEc1Interactionec1InteractionDataIdb = ec1InteractionDataEc1Interactionec1InteractionDataIdb == null ? null : ec1InteractionDataEc1Interactionec1InteractionDataIdb.trim();
    }
}