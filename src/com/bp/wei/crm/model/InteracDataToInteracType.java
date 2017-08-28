package com.bp.wei.crm.model;

import java.util.Date;

public class InteracDataToInteracType {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1Interab268onTypeIda;

    private String ec1Intera3de5onDataIdb;

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

    public String getEc1Interab268onTypeIda() {
        return ec1Interab268onTypeIda;
    }

    public void setEc1Interab268onTypeIda(String ec1Interab268onTypeIda) {
        this.ec1Interab268onTypeIda = ec1Interab268onTypeIda == null ? null : ec1Interab268onTypeIda.trim();
    }

    public String getEc1Intera3de5onDataIdb() {
        return ec1Intera3de5onDataIdb;
    }

    public void setEc1Intera3de5onDataIdb(String ec1Intera3de5onDataIdb) {
        this.ec1Intera3de5onDataIdb = ec1Intera3de5onDataIdb == null ? null : ec1Intera3de5onDataIdb.trim();
    }
}