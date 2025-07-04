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

        Scanner myObj = new Scanner(System.in); // scanner object for user input
        int userChoice = 0; // user choice for the menu
        Patient currentPatient = null; // holds the registered patient

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}