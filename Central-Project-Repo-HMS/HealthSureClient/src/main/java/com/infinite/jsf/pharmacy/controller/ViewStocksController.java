package com.infinite.jsf.pharmacy.controller;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import com.infinite.jsf.pharmacy.daoImpl.MedicinesDaoImpl;
import com.infinite.jsf.pharmacy.model.Medicines;

public class ViewStocksController {

	 /**
     * Medicines
     */
    
    private MedicinesDaoImpl medicinesDao;
    private List<Medicines> medicinesList;

    public void setMedicinesDao(MedicinesDaoImpl medicinesDao) {
        this.medicinesDao = medicinesDao;
    }

    public List<Medicines> getMedicinesList() {
        if (medicinesList == null) {
           // medicinesList = medicinesDao.getAllMedicines();
        	String pharmacyId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pharmacy_id");
        	medicinesList = medicinesDao.getMedicinesByPharmacyId(pharmacyId);
        }
        return medicinesList;
    }

 // Search related fields
    private String searchText;
    private String searchMode = "starts"; // default

    // Getter and Setter for searchText
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    // Getter and Setter for searchMode
    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }

    // Search method
//    public String searchMedicines() {
//        if (searchText == null || searchText.trim().isEmpty()) {
//            medicinesList = medicinesDao.getAllMedicines();
//        } else if ("starts".equals(searchMode)) {
//            medicinesList = medicinesDao.searchMedicinesStartingWith(searchText);
//        } else if ("contains".equals(searchMode)) {
//            medicinesList = medicinesDao.searchMedicinesContaining(searchText);
//        }
//        currentPage = 1; // Reset to first page after search
//        return null;
//    }
    
//    public String searchMedicines() {
//        String pharmacyId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pharmacy_id");
//
//        if (searchText == null || searchText.trim().isEmpty()) {
//            medicinesList = medicinesDao.getMedicinesByPharmacyId(pharmacyId);
//        } else if ("starts".equals(searchMode)) {
//            medicinesList = medicinesDao.searchMedicinesStartingWith(searchText, pharmacyId);
//        } else if ("contains".equals(searchMode)) {
//            medicinesList = medicinesDao.searchMedicinesContaining(searchText, pharmacyId);
//        }
//
//        currentPage = 1; // Reset to first page
//        return null;
//    }


    
    public String searchMedicines() {
        String pharmacyId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pharmacy_id");

        if (searchText != null) {
        	// Trim leading and trailing spaces
            searchText = searchText.trim(); 
        }

        if (searchText == null || searchText.isEmpty()) {
            medicinesList = medicinesDao.getMedicinesByPharmacyId(pharmacyId);
        } else if ("starts".equals(searchMode)) {
            medicinesList = medicinesDao.searchMedicinesStartingWith(searchText, pharmacyId);
        } else if ("contains".equals(searchMode)) {
            medicinesList = medicinesDao.searchMedicinesContaining(searchText, pharmacyId);
        }

        currentPage = 1; // Reset to first page
        return null;
    }
    // page 
 // Pagination Support
    private int currentPage = 1;
    private int pageSize = 10;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    // reset to first page when page size changes
    public void setPageSize(int pageSize) {
    	
    	this.pageSize = pageSize;
    	currentPage = 1;
    }
    
    public int getTotalPages() {
        int total = (medicinesList != null) ? medicinesList.size() : 0;
        return (int) Math.ceil((double) total / pageSize);
    }

    public List<Medicines> getPaginatedMedicines() {
        if (medicinesList == null) {
            return new java.util.ArrayList<>(); // return empty list if null
        }
        int fromIndex = (currentPage - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, medicinesList.size());
        return medicinesList.subList(fromIndex, toIndex);
    }

    // Navigation
    public void nextPage() {
        if (currentPage < getTotalPages()) {
            currentPage++;
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    // pagination.............
    
    private String sortBy = "medicineName"; // default
    private boolean ascending = true;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void toggleSort(String column) {
        if (column.equals(sortBy)) {
            ascending = !ascending; // toggle
        } else {
            sortBy = column;
            ascending = true; // reset to ascending for new column
        }
        sortMedicines();
    }

    private void sortMedicines() {
        if (medicinesList == null) return;
        medicinesList.sort((a, b) -> {
            int result = 0;
            switch (sortBy) {
                case "medicineName":
                    result = a.getMedicineName().compareToIgnoreCase(b.getMedicineName()); break;
                case "unitPrice":
                    result = Double.compare(a.getUnitPrice(), b.getUnitPrice()); break;
                case "expiryDate":
                    result = a.getExpiryDate().compareTo(b.getExpiryDate()); break;
                default: return 0;
            }
            return ascending ? result : -result;
        });
    }
// maling expired medicines
    public String getExpiryStyle(Date expiryDate) {
        if (expiryDate != null && expiryDate.before(new Date())) {
            return "color:red; white-space: nowrap;";
        }
        return "white-space: nowrap;";
    }
  
//to call in home pharmacy page
    public String ViewMedicineStocks() {
    	return "ViewMedicines.jsf?faces-redirect=true";
    }
	
}
