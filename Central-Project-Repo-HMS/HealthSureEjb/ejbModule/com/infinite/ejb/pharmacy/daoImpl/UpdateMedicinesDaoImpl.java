package com.infinite.ejb.pharmacy.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.infinite.ejb.pharmacy.dao.UpdateMedicinesDao;
import com.infinite.ejb.pharmacy.model.Medicines;
import com.infinite.ejb.util.ConnectionHelper;

public class UpdateMedicinesDaoImpl implements UpdateMedicinesDao {

	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean updateMedicineDetails(Medicines med) {
		try {
            connection = ConnectionHelper.getConnection(); // Your JDBC connection helper
            String sql = "UPDATE Medicines SET medicine_name = ?, description = ?, quantity_in_stock = ?, unit_price = ?, purpose = ? WHERE medicine_id = ?";
            pst = connection.prepareStatement(sql);

            pst.setString(1, med.getMedicineName());
            pst.setString(2, med.getDescription());
            pst.setInt(3, med.getQuantityInStock());
            pst.setDouble(4, med.getUnitPrice());
            pst.setString(5, med.getPurpose());
            pst.setString(6, med.getMedicineId());

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
}
