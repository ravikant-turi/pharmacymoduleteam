package com.infinite.jsf.recipient.controller;

import java.util.List;

import com.infinite.jsf.recipient.dao.SubscriptionDAO;
import com.infinite.jsf.recipient.model.Recipient;
import com.infinite.jsf.recipient.model.Subscription;

public class SubscriptionController {

    private String recipientId;
    private List<Subscription> subscriptionList;
    private Subscription subscription;
    private Recipient recipient;

    private SubscriptionDAO dao;

    public SubscriptionController() {}

    
    //Fetching All the plans the Patient has enrolled in.
    public String fetchAllPlansForRecipient() {
        subscriptionList = dao.getAllByRecipientId(recipientId);
        return null;
    }
    
    //Fetching only the Active plans the Patients has.
    public String fetchActivePlansForRecipient() {
        subscriptionList = dao.getActiveByRecipientId(recipientId);
        return null;
    }

    //Fetching only the Expired plans the Patient has.
    public String fetchExpiredPlansForRecipient() {
        subscriptionList = dao.getExpiredByRecipientId(recipientId);
        return null;
    }

    
    //Getter and Setters
    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public SubscriptionDAO getDao() {
        return dao;
    }

    public void setDao(SubscriptionDAO dao) {
        this.dao = dao;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
