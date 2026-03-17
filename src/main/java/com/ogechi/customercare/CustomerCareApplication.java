package com.ogechi.customercare;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerCareApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println(" Electronic Gadgets Support");
        System.out.println("==================================");

        while (true) {

            System.out.println("\nEnter your name:");
            String customerName = scanner.nextLine();

            System.out.println("\nSelect Department:");
            System.out.println("1. Payment Department");
            System.out.println("2. Query Department");
            System.out.println("3. Sales Department");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String beanId = "";

            switch (choice) {

                case 1:
                    beanId = "paymentDepartment";
                    break;

                case 2:
                    beanId = "queryDepartment";
                    break;

                case 3:
                    beanId = "salesDepartment";
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    context.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue; // go back to loop
            }

            CustomerCare customer =
                    context.getBean(beanId, CustomerCare.class);

            customer.setCustomerName(customerName);
            customer.getService();

            System.out.println("Describe your issue:");
            String issue = scanner.nextLine();

            customer.setProblem(issue);
            customer.getProblem();
        }
    }
}