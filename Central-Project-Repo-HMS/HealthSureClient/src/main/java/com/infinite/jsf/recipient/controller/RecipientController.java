package com.infinite.jsf.recipient.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import com.infinite.jsf.provider.model.MedicalProcedure;
import com.infinite.jsf.recipient.daoImpl.InsuranceDaoImpl;
import com.infinite.jsf.recipient.model.PatientInsuranceDetails;

public class RecipientController {

//	private ProviderEjbImpl providerEjb;
	private MedicalProcedure medicalProcedure;
	private InsuranceDaoImpl insuranceDaoImpl; // Let JSF inject it

	private List<PatientInsuranceDetails> patientInsuranceList = new ArrayList<>();
	private PatientInsuranceDetails selectedItem;
	private String hId; // to persist entered ID across requests

	// Getter/Setter
	public PatientInsuranceDetails getSelectedItem() {
		return selectedItem;
	}
	public void setSelectedItem(PatientInsuranceDetails selectedItem) {
		this.selectedItem = selectedItem;
	}
	public List<PatientInsuranceDetails> getPatientInsuranceList() {
		return patientInsuranceList;
	}
	public void setPatientInsuranceList(List<PatientInsuranceDetails> patientInsuranceList) {
		this.patientInsuranceList = patientInsuranceList;
	}
	public InsuranceDaoImpl getInsuranceDaoImpl() {
		return insuranceDaoImpl;
	}
	public void setInsuranceDaoImpl(InsuranceDaoImpl insuranceDaoImpl) {
		this.insuranceDaoImpl = insuranceDaoImpl;
	}
	public MedicalProcedure getMedicalProcedure() {
		return medicalProcedure;
	}
	public void setMedicalProcedure(MedicalProcedure medicalProcedure) {
		this.medicalProcedure = medicalProcedure;
	}
//	public ProviderEjbImpl getProviderEjb() {
//		return providerEjb;
//	}
//	public void setProviderEjb(ProviderEjbImpl providerEjb) {
//		this.providerEjb = providerEjb;
//	}
	public String gethId() {
		return hId;
	}
	public void sethId(String hId) {
		this.hId = hId;
	}

	//  Show all insurance
	public List<PatientInsuranceDetails> showInsuranceDetailsController(String hId) {
		this.hId = hId;
		patientInsuranceList = insuranceDaoImpl.showInsuranceOfRecipient(hId);
		return patientInsuranceList;
	}

	//  Show only ACTIVE insurance (based on current date < coverageEndDate)
	public List<PatientInsuranceDetails> showActiveInsuranceDetailsController(String hId) {
		this.hId = hId;
		List<PatientInsuranceDetails> all = insuranceDaoImpl.showInsuranceOfRecipient(hId);
		List<PatientInsuranceDetails> activeList = new ArrayList<>();
		Date today = new Date();

		for (PatientInsuranceDetails detail : all) {
			if (detail.getCoverageEndDate() != null && detail.getCoverageEndDate().after(today)) {
				activeList.add(detail);
			}
		}
		patientInsuranceList = activeList;
		return activeList;
	}

	//  Show only EXPIRED insurance (coverageEndDate < today)
	public List<PatientInsuranceDetails> showExpiredInsuranceDetailsController(String hId) {
		this.hId = hId;
		List<PatientInsuranceDetails> all = insuranceDaoImpl.showInsuranceOfRecipient(hId);
		List<PatientInsuranceDetails> expiredList = new ArrayList<>();
		Date today = new Date();

		for (PatientInsuranceDetails detail : all) {
			if (detail.getCoverageEndDate() != null && detail.getCoverageEndDate().before(today)) {
				expiredList.add(detail);
			}
		}
		patientInsuranceList = expiredList;
		return expiredList;
	}

	//  Navigation
	public String redirect(PatientInsuranceDetails insurance) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("selectedInsurance", insurance);
		return "viewMembers?faces-redirect=true";
	}

	public PatientInsuranceDetails loadSubscribedMembers() {
		Object obj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selectedInsurance");
		return (PatientInsuranceDetails) obj;
	}

	// 💊 Prescription logic
//	public String addMedicalProcedureControllerPrescription(MedicalProcedure medicalProcedure)
//			throws ClassNotFoundException, SQLException {
//		providerEjb.addMedicalProcedure(medicalProcedure);
//		return "AddPrescription?faces-redirect=true";
//	}
//
//	public String addMedicalProcedureControllerTest(MedicalProcedure medicalProcedure)
//			throws ClassNotFoundException, SQLException {
//		providerEjb.addMedicalProcedure(medicalProcedure);
//		return "AddTest?faces-redirect=true";
//	}
//
//	public String addPrescriptionController(Prescription prescription) throws ClassNotFoundException, SQLException {
//		return providerEjb.addPrescription(prescription);
//	}
//
//	public String addTestController(ProcedureTest procedureTest) throws ClassNotFoundException, SQLException {
//		return providerEjb.addTest(procedureTest);
//	}
}
