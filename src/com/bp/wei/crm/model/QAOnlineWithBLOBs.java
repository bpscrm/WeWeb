package com.bp.wei.crm.model;

public class QAOnlineWithBLOBs extends QAOnline {
    private String description;

    private String ask;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }
}