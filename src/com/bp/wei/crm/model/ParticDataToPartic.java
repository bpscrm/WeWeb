package com.bp.wei.crm.model;

import java.util.Date;

public class ParticDataToPartic {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1ParticipateDataEc1Participateec1ParticipateIda;

    private String ec1ParticipateDataEc1Participateec1ParticipateDataIdb;

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

    public String getEc1ParticipateDataEc1Participateec1ParticipateIda() {
        return ec1ParticipateDataEc1Participateec1ParticipateIda;
    }

    public void setEc1ParticipateDataEc1Participateec1ParticipateIda(String ec1ParticipateDataEc1Participateec1ParticipateIda) {
        this.ec1ParticipateDataEc1Participateec1ParticipateIda = ec1ParticipateDataEc1Participateec1ParticipateIda == null ? null : ec1ParticipateDataEc1Participateec1ParticipateIda.trim();
    }

    public String getEc1ParticipateDataEc1Participateec1ParticipateDataIdb() {
        return ec1ParticipateDataEc1Participateec1ParticipateDataIdb;
    }

    public void setEc1ParticipateDataEc1Participateec1ParticipateDataIdb(String ec1ParticipateDataEc1Participateec1ParticipateDataIdb) {
        this.ec1ParticipateDataEc1Participateec1ParticipateDataIdb = ec1ParticipateDataEc1Participateec1ParticipateDataIdb == null ? null : ec1ParticipateDataEc1Participateec1ParticipateDataIdb.trim();
    }
}