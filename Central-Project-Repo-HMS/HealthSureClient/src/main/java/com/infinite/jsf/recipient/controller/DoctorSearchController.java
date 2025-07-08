package com.infinite.jsf.recipient.controller;

import java.util.List;

import com.infinite.jsf.provider.model.Doctor;
import com.infinite.jsf.recipient.dao.SearchDoctorDao;
import com.infinite.jsf.recipient.daoImpl.SearchDoctorDaoImpl;

public class DoctorSearchController {

	private String searchBy;
	private String searchValue;

	private List<Doctor> searchResults;

	private SearchDoctorDao doctorDAO = new SearchDoctorDaoImpl();

	// 🔍 Renamed action method for clarity
	public void executeSearch() {
		if (searchBy != null && searchValue != null && !searchValue.trim().isEmpty()) {
			searchResults = doctorDAO.searchDoctors(searchBy, searchValue);
		}
	}

	// 🧭 Getters and Setters
	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Doctor> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Doctor> searchResults) {
		this.searchResults = searchResults;
	}
}
