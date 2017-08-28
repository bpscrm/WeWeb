package com.bp.wei.crm.model;

public class MarketinginfoWithBLOBs extends Marketinginfo {
    private String description;

    private String descSignup;

    private String descSurvey;

    private String descPresent;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDescSignup() {
        return descSignup;
    }

    public void setDescSignup(String descSignup) {
        this.descSignup = descSignup == null ? null : descSignup.trim();
    }

    public String getDescSurvey() {
        return descSurvey;
    }

    public void setDescSurvey(String descSurvey) {
        this.descSurvey = descSurvey == null ? null : descSurvey.trim();
    }

    public String getDescPresent() {
        return descPresent;
    }

    public void setDescPresent(String descPresent) {
        this.descPresent = descPresent == null ? null : descPresent.trim();
    }
}