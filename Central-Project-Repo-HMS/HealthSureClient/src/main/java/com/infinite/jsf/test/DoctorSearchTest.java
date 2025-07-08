package com.infinite.jsf.test;

import java.util.List;
import java.util.Scanner;

import com.infinite.jsf.provider.model.Doctor;
import com.infinite.jsf.recipient.controller.DoctorSearchController;

public class DoctorSearchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoctorSearchController controller = new DoctorSearchController();

        System.out.println("=== Doctor Search Tester ===");

        System.out.print("Enter Search By (name/specialization/address): ");
        String searchBy = scanner.nextLine();

        System.out.print("Enter Search Value: ");
        String searchValue = scanner.nextLine();

        controller.setSearchBy(searchBy);
        controller.setSearchValue(searchValue);

        controller.executeSearch();

        List<Doctor> resultList = controller.getSearchResults();

        if (resultList.isEmpty()) {
            System.out.println("No doctors found for your criteria.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Doctor doc : resultList) {
                System.out.println("Name        : " + doc.getDoctorName());
                System.out.println("Specialization : " + doc.getSpecialization());
//                System.out.println("Address     : " + doc.getAddress());
//                System.out.println("Status      : " + doc.getStatusString());
//                System.out.println("Gender      : " + doc.getGenderString());
                System.out.println("------------------------------");
            }
        }

        scanner.close();
    }
}
