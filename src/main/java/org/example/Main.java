package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void printUserMenu() {
        System.out.println("=== Hospital Billing System ===");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        ServiceFactory serviceFactory = new ServiceFactory();

        Scanner myObj = new Scanner(System.in); // scanner object for user input
        int userChoice = 0; // user choice for the menu
        Patient currentPatient = null; // holds the registered patient
        Service currentService = null; // holds the selected service

        // Loop user menu
        while (userChoice != 4) {
            printUserMenu();
            System.out.print("Enter choice: ");
            userChoice = myObj.nextInt();

            switch (userChoice){
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = myObj.next();

                    currentPatient = new Patient(name);
                    break;
                case 2:
                    if (currentPatient == null) {
                        System.out.println("\n=========================================");
                        System.out.println("Warning! Please register a patient first.");
                        System.out.println("=========================================\n");

                    } else {
                        System.out.println("Available Services: X-Ray (500), Surgery (12000), Consultation (700)");
                        String selectedService = "";
                        while (!selectedService.equalsIgnoreCase("xray") && !selectedService.equalsIgnoreCase("x-ray") && !selectedService.equalsIgnoreCase("surgery") && !selectedService.equalsIgnoreCase("consultation") ){
                            System.out.print("Select service to add: ");
                            selectedService = myObj.next();
                        }
                        currentService =  serviceFactory.getService(selectedService);
                        System.out.println("Service added to patient bill.");
                    }
                    break;
                case 3:
                    try {
                        computeBill(currentService.returnServiceAmount());
                    } catch (Exception err) {
                        System.out.println("\n=========================================");
                        System.out.println("Warning! Please add a service first.");
                        System.out.println("=========================================\n");
                    }

                    break;
                case 4:
                    break;
            }
        }
    }

    private static final String[] INSURANCE_TYPE = {"hmo", "cash", "senior"};

    public static void computeBill(double cost) {
        Scanner input = new Scanner(System.in);

        String insuranceType;
        while (true) {
            System.out.print("Insurance Type (hmo/cash/senior): ");
            insuranceType = input.nextLine();

            if (isValidInsuranceType(insuranceType)) {
                break;
            }

            System.out.println("Invalid Input. Please try again.");
        }

        System.out.println("\n=========================================");
        System.out.println("Discounted cost: " + Insurance.getFinalCost(insuranceType, cost));
        System.out.println("=========================================");
        System.out.println("Bill generated successfully!\n");
    }

    private static boolean isValidInsuranceType(String input) {
        for (String insurance : INSURANCE_TYPE) {
            if (insurance.equalsIgnoreCase(input)) return true;
        }

        return false;
    }
}