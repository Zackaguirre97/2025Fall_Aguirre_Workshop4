package com.pluralsight;

import java.util.Scanner;

/*
* UserInterface contains the following fields:
* - Dealership
* UserInterface contains the following methods:
* - display()
* - processGetByPriceRequest()
* - processGetByMakeModelRequest()
* - processGetByYearRequest()
* - processGetByColorRequest()
* - processGetByMileageRequest()
* - processGetByVehicleTypeRequest()
* - processGetAllVehiclesRequest()
* - processAddVehicleRequest()
* - processRemoveVehicleRequest()
* UserInterface handles user interactions and executing the requested processes.
*/
public class UserInterface {
    /*
    * *** Props ***
    * */
    // Dealership instance
    private Dealership dealership;
    private Scanner sc;

    /*
     * *** Const ***
     * */
    // No args
    public UserInterface() {
        this.sc = new Scanner(System.in);
    }

    /*
     * *** Methods ***
     * */
    // *** Public ***
    // Display/Handle the main menu
    public void display() {
    }

    // *** Private ***
    // Handle initializing the Dealership
    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    // Print the main menu to the console
    private void mainMenu() {
        System.out.println("========== Dealership Menu ==========");
        System.out.println("1. Find vehicle within a price range");
        System.out.println("2. Find vehicles by make / model");
        System.out.println("3. Find vehicles by year range");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage range");
        System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7. List ALL vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("99. Quit");
        System.out.println("Select an option: ");
    }

    // Handle the user requests to get a list of vehicles by price
    private void processGetByPriceRequest() {

    }

    // Handle the user requests to get a list of vehicles by make & model
    private void processGetByMakeModelRequest() {

    }

    // Handle the user requests to get a list of vehicles by year
    private void processGetByYearRequest() {

    }

    // Handle the user requests to get a list of vehicles by color
    private void processGetByColorRequest() {

    }

    // Handle the user requests to get a list of vehicles by mileage
    private void processGetByMileageRequest() {

    }

    // Handle the user requests to get a list of vehicles by vehicle type
    private void processGetByVehicleTypeRequest() {

    }

    // Handle the user requests to get a list of all vehicles
    private void processGetAllVehiclesRequest() {

    }

    // Handle the user requests to add a vehicle to the list
    private void processAddVehicleRequest() {

    }

    // Handle the user requests to remove a vehicle from the list
    private void processRemoveVehicleRequest() {

    }

    // Check if the passed string is an integer.
    private boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        } // Done
    }

    // Check if the passed string is a double.
    private boolean isDouble(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        } // Done
    }
}
