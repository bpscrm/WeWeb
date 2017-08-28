package com.bp.wei.crm.model;

import java.util.Date;

public class ParticDataToParticType {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1Partic0cbeteTypeIda;

    private String ec1Partic180eteDataIdb;

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

    public String getEc1Partic0cbeteTypeIda() {
        return ec1Partic0cbeteTypeIda;
    }

    public void setEc1Partic0cbeteTypeIda(String ec1Partic0cbeteTypeIda) {
        this.ec1Partic0cbeteTypeIda = ec1Partic0cbeteTypeIda == null ? null : ec1Partic0cbeteTypeIda.trim();
    }

    public String getEc1Partic180eteDataIdb() {
        return ec1Partic180eteDataIdb;
    }

    public void setEc1Partic180eteDataIdb(String ec1Partic180eteDataIdb) {
        this.ec1Partic180eteDataIdb = ec1Partic180eteDataIdb == null ? null : ec1Partic180eteDataIdb.trim();
    }
}