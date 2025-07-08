package com.infinite.jsf.provider.model;

import java.io.Serializable;
import java.util.Date;

public class ClaimHistory implements Serializable{

    private String claimHistoryId;

    private Claims claim;  // Many-to-one relationship with Claims

    private String description;

    private Date actionDate;

    // Getters and Setters

    public String getClaimHistoryId() {
        return claimHistoryId;
    }

    public void setClaimHistoryId(String claimHistoryId) {
        this.claimHistoryId = claimHistoryId;
    }

    public Claims getClaim() {
        return claim;
    }

    public void setClaim(Claims claim) {
        this.claim = claim;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
