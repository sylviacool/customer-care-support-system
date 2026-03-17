package com.ogechi.customercare;

import java.util.ArrayList;
import java.util.List;
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
        List<String> allIssues = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("  ELECTRONIC GADGETS SUPPORT SYSTEM");
        System.out.println("==================================");

        while (true) {

            System.out.println("\nSelect an option:");
            System.out.println("1. Register a customer issue");
            System.out.println("2. View all issues");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int mainChoice = Integer.parseInt(scanner.nextLine());

            switch (mainChoice) {

                case 1:
                    System.out.print("\nEnter your name: ");
                    String customerName = scanner.nextLine();

                    System.out.println("\nSelect Department:");
                    System.out.println("1. Payment Department");
                    System.out.println("2. Query Department");
                    System.out.println("3. Sales Department");
                    System.out.print("Your choice: ");

                    int choice = Integer.parseInt(scanner.nextLine());

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
                        default:
                            System.out.println("\nInvalid department choice. Try again.");
                            continue;
                    }

                    CustomerCare customer = context.getBean(beanId, CustomerCare.class);

                    customer.setCustomerName(customerName);
                    customer.getService();

                    System.out.print("Describe your issue: ");
                    String issue = scanner.nextLine();

                    customer.setProblem(issue);
                    customer.getProblem();

                    allIssues.add(customerName + " - " + customer.getDepartment() + " - " + issue);

                    System.out.println("Thank you. Your issue has been recorded.");
                    break;

                case 2:
                    System.out.println("\n========== ALL REGISTERED ISSUES ==========");

                    if (allIssues.isEmpty()) {
                        System.out.println("No issues have been registered yet.");
                    } else {
                        for (int i = 0; i < allIssues.size(); i++) {
                            System.out.println((i + 1) + ". " + allIssues.get(i));
                        }
                    }

                    System.out.println("Total issues logged: " + allIssues.size());
                    break;

                case 3:
                    System.out.println("\nExiting system...");
                    scanner.close();
                    context.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }
}