package com.infinite.jsf.recipient.dao;

import java.util.List;

import com.infinite.jsf.recipient.model.Subscription;

public interface SubscriptionDAO {
	
	
	public List<Subscription> getAllByRecipientId(String recipientId);
	public List<Subscription> getActiveByRecipientId(String recipientId);
	public List<Subscription> getExpiredByRecipientId(String recipientId);


}
