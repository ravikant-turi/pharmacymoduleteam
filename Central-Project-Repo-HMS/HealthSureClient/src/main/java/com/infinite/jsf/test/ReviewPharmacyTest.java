package com.infinite.jsf.test;

import com.infinite.jsf.pharmacy.controller.ReviewPharmacyController;

public class ReviewPharmacyTest {
	public static void main(String[] args) {
		
		ReviewPharmacyController controller=new ReviewPharmacyController();
		
		controller.showPharmacyAll().forEach(System.out::println);
	System.out.println(controller.showPharmacyAll().get(0).getStatus());
	}

}
