package com.infinite.jsf.recipient.dao;
import java.util.List;

import com.infinite.jsf.provider.model.Doctor;

public interface SearchDoctorDao {
	List<Doctor> searchDoctors(String searchBy, String value);
}
