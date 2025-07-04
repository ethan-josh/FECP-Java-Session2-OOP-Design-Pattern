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
            /*
            Create services with Service Factory here
             */
        ServiceFactory serviceFactory = new ServiceFactory();

        Scanner myObj = new Scanner(System.in); // scanner object for user input
        int userChoice = 0; // user choice for the menu
        Patient currentPatient = null; // holds the registered patient
        Service currentService = null; // holds the selected service

        // Loop user menu
        while (userChoice != 4) {
            printUserMenu();
            userChoice = myObj.nextInt();

            switch (userChoice){
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = myObj.nextLine();

                    currentPatient = new Patient(name);
                    break;
                case 2:
                    System.out.println("Available Services: X-Ray (500), Surgery (12000), Consultation (700)");
                    String selectedService = "";
                    while (!selectedService.equalsIgnoreCase("xray") && !selectedService.equalsIgnoreCase("x-ray") && !selectedService.equalsIgnoreCase("surgery") && !selectedService.equalsIgnoreCase("consultation") ){
                        System.out.print("Select service to add: ");
                        selectedService = myObj.nextLine();
                    }
                    currentService =  serviceFactory.getService(selectedService);
                    System.out.println("Service added to patient bill.");
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}