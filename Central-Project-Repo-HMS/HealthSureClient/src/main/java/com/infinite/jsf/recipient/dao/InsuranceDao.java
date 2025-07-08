package com.infinite.jsf.recipient.dao;

import java.util.List;

import com.infinite.jsf.recipient.model.PatientInsuranceDetails;

public interface InsuranceDao {
    
    //  Return all insurances for a recipient
    public List<PatientInsuranceDetails> showInsuranceOfRecipient(String recipientId);

    //  Return only active insurances
    public List<PatientInsuranceDetails> showActiveInsuranceOfRecipient(String recipientId);

    //  Return only expired insurances
    public List<PatientInsuranceDetails> showExpiredInsuranceOfRecipient(String recipientId);
}
