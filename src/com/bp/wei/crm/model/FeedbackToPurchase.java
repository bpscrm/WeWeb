package com.bp.wei.crm.model;

import java.util.Date;

public class FeedbackToPurchase {
    private String id;

    private Date dateModified;

    private Boolean deleted;

    private String ec1FeedbackEc1PurchaseDataec1PurchaseDataIda;

    private String ec1FeedbackEc1PurchaseDataec1FeedbackIdb;

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

    public String getEc1FeedbackEc1PurchaseDataec1PurchaseDataIda() {
        return ec1FeedbackEc1PurchaseDataec1PurchaseDataIda;
    }

    public void setEc1FeedbackEc1PurchaseDataec1PurchaseDataIda(String ec1FeedbackEc1PurchaseDataec1PurchaseDataIda) {
        this.ec1FeedbackEc1PurchaseDataec1PurchaseDataIda = ec1FeedbackEc1PurchaseDataec1PurchaseDataIda == null ? null : ec1FeedbackEc1PurchaseDataec1PurchaseDataIda.trim();
    }

    public String getEc1FeedbackEc1PurchaseDataec1FeedbackIdb() {
        return ec1FeedbackEc1PurchaseDataec1FeedbackIdb;
    }

    public void setEc1FeedbackEc1PurchaseDataec1FeedbackIdb(String ec1FeedbackEc1PurchaseDataec1FeedbackIdb) {
        this.ec1FeedbackEc1PurchaseDataec1FeedbackIdb = ec1FeedbackEc1PurchaseDataec1FeedbackIdb == null ? null : ec1FeedbackEc1PurchaseDataec1FeedbackIdb.trim();
    }
}