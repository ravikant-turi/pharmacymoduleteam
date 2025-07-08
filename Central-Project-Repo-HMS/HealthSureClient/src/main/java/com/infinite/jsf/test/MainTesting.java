package com.infinite.jsf.test;

import com.infinite.jsf.recipient.controller.SubscriptionController;
import com.infinite.jsf.recipient.daoImpl.SubscriptionDAOImpl;
import com.infinite.jsf.recipient.model.Subscription;

import java.util.List;

public class MainTesting {

    public static void main(String[] args) {
    	
        // Instantiate controller manually for testing
        SubscriptionController controller = new SubscriptionController();

        // Inject DAO manually for testing (JSF does it via faces-config in real run)
        controller.setDao(new SubscriptionDAOImpl());

        // Set test recipient ID
        controller.setRecipientId("REC001");

        System.out.println("=== All Subscriptions ===");
        controller.fetchAllPlansForRecipient();
        printList(controller.getSubscriptionList());

        System.out.println("\n=== Active Subscriptions ===");
        controller.fetchActivePlansForRecipient();
        printList(controller.getSubscriptionList());

        System.out.println("\n=== Expired Subscriptions ===");
        controller.fetchExpiredPlansForRecipient();
        printList(controller.getSubscriptionList());
        
    }

    // Utility to print a list of subscriptions
    private static void printList(List<Subscription> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Subscription s : list) {
            System.out.printf("'%s', '%s', '%s', '%s', '%s', '%s', '%.2f', '%.2f'%n",
                    s.getSubscriptionId(),
                    s.getRecipient().gethId(),
                    s.getCoverage().getCoverageId(),
                    s.getSubscribeDate(),
                    s.getExpiryDate(),
                    s.getStatus(),
                    s.getTotalPremium(),
                    s.getAmountPaid());
        }
    }
}
