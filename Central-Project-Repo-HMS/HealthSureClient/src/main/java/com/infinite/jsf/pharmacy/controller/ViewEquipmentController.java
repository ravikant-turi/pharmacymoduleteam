package com.infinite.jsf.pharmacy.controller;

import java.util.List;
import java.util.Date;

import javax.faces.context.FacesContext;

import com.infinite.jsf.pharmacy.daoImpl.EquipmentDaoImpl;
import com.infinite.jsf.pharmacy.model.Equipment;

public class ViewEquipmentController {

    private EquipmentDaoImpl equipmentDao;
    private List<Equipment> equipmentList;

    public void setEquipmentDao(EquipmentDaoImpl equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    public List<Equipment> getEquipmentList() {
        if (equipmentList == null) {
            String pharmacyId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pharmacy_id");
            equipmentList = equipmentDao.getEquipmentByPharmacyId(pharmacyId);
        }
        return equipmentList;
    }

    // Search
    private String searchText;
    private String searchMode = "starts";

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }

    public String searchEquipment() {
        String pharmacyId = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pharmacy_id");

        if (searchText == null || searchText.trim().isEmpty()) {
            equipmentList = equipmentDao.getEquipmentByPharmacyId(pharmacyId);
        } else if ("starts".equals(searchMode)) {
            equipmentList = equipmentDao.searchEquipmentStartingWith(searchText, pharmacyId);
        } else if ("contains".equals(searchMode)) {
            equipmentList = equipmentDao.searchEquipmentContaining(searchText, pharmacyId);
        }

        currentPage = 1;
        sortEquipment(); // Re-sort after search
        return null;
    }

    // Pagination
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

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        currentPage = 1;
    }

    public int getTotalPages() {
        int total = (equipmentList != null) ? equipmentList.size() : 0;
        return (int) Math.ceil((double) total / pageSize);
    }

    public List<Equipment> getPaginatedEquipment() {
        if (equipmentList == null) {
            return new java.util.ArrayList<>();
        }
        int fromIndex = (currentPage - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, equipmentList.size());
        return equipmentList.subList(fromIndex, toIndex);
    }

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

    // Sorting
    private String sortBy = "equipmentName";
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
            ascending = !ascending;
        } else {
            sortBy = column;
            ascending = true;
        }
        sortEquipment();
    }

    private void sortEquipment() {
        if (equipmentList == null) return;

        equipmentList.sort((a, b) -> {
            int result = 0;
            switch (sortBy) {
                case "equipmentName":
                    result = a.getEquipmentName().compareToIgnoreCase(b.getEquipmentName());
                    break;
                case "unitPrice":
                    result = Double.compare(a.getUnitPrice(), b.getUnitPrice());
                    break;
                case "quantity":
                    result = Integer.compare(a.getQuantity(), b.getQuantity());
                    break;
                default:
                    return 0;
            }
            return ascending ? result : -result;
        });
    }

    // Date highlighting for expired items
    public String getExpiryStyle(Date purchaseDate) {
        if (purchaseDate == null) return "";
        Date today = new Date();
        return purchaseDate.before(today) ? "color: red;" : "";
    }

    public String ViewPharmacyStocks() {
        return "ViewEquipments.jsf?faces-redirect=true";
    }
}