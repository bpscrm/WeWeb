package com.bp.wei.crm.model;

public class FeedbackWithBLOBs extends Feedback {
    private String description;

    private String fdAsk;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFdAsk() {
        return fdAsk;
    }

    public void setFdAsk(String fdAsk) {
        this.fdAsk = fdAsk == null ? null : fdAsk.trim();
    }
}