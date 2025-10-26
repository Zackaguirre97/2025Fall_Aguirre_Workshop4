package com.pluralsight;

import java.util.List;
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

    /*
     * *** Const ***
     * */
    // No args
    public UserInterface() {

    }

    /*
     * *** Methods ***
     * */
    // *** Public ***
    // Display/Handle the main menu
    public void display() {
        Scanner sc = new Scanner(System.in);
        // Local variables
        boolean running = true;
        // Initialize the dealership object instance.
        init();
        // Loop the main menu
        while(running) {
            mainMenu();
            // Gather and store the user input
            String mainMenuChoice = sc.nextLine().trim();
            int convertedMainMenuChoice;
            // Make sure the input is a number.
            if(isInteger(mainMenuChoice)) {
                // Convert the user input to an int.
                convertedMainMenuChoice = Integer.parseInt(mainMenuChoice);
            }
            else {
                System.out.println("\nInvalid entry: Please enter a number (1, 2, 3, etc.)");
                break;
            }
            // Evaluate the input and direct the user to the relevant method.
            switch(convertedMainMenuChoice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("\nInvalid entry: Please enter a number from the list (1-9 & 99)");
            }
        }
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
        System.out.print("Select an option: ");
    }

    private void processGetByPriceRequest() {
        Scanner sc = new Scanner(System.in);
        double min = 0;
        double max = 0;

        // --- Get minimum price ---
        while (true) {
            System.out.print("Enter the minimum price (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isDouble(input)) {
                min = Double.parseDouble(input);
                if (min < 50000) {
                    System.out.println("Error: Please enter a value greater than 50,000!");
                    continue;
                }
                if (min > 5000000) {
                    System.out.println("Error: Min must be less than 5,000,000!");
                    continue;
                }
                break; // valid min entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 100000 or 249999.99)!");
            }
        }

        // --- Get maximum price ---
        while (true) {
            System.out.print("Enter the maximum price (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isDouble(input)) {
                max = Double.parseDouble(input);
                if (max <= min) {
                    System.out.println("Error: Max must be greater than min!");
                    continue;
                }
                if (max > 5000000) {
                    System.out.println("Error: Max must be less than 5,000,000!");
                    continue;
                }
                break; // valid max entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 100000 or 249999.99)!");
            }
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        if (results.isEmpty()) {
            System.out.println("No vehicles found in that price range.");
        } else {
            System.out.printf("Vehicles between $%.2f and $%.2f:%n", min, max);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of vehicles by make & model
    private void processGetByMakeModelRequest() {
        System.out.println("Make/model search");
    }

    // Handle the user requests to get a list of vehicles by year
    private void processGetByYearRequest() {
        System.out.println("Year search");
    }

    // Handle the user requests to get a list of vehicles by color
    private void processGetByColorRequest() {
        System.out.println("Color search");
    }

    // Handle the user requests to get a list of vehicles by mileage
    private void processGetByMileageRequest() {
        System.out.println("Mileage search");
    }

    // Handle the user requests to get a list of vehicles by vehicle type
    private void processGetByVehicleTypeRequest() {
        System.out.println("Vehicle Type search");
    }

    // Handle the user requests to get a list of all vehicles
    private void processGetAllVehiclesRequest() {
        List<Vehicle> displayList = dealership.getAllVehicles();
        displayVehicles(displayList);
    }

    // Handle the user requests to add a vehicle to the list
    private void processAddVehicleRequest() {
        System.out.println("Add vehicle");
    }

    // Handle the user requests to remove a vehicle from the list
    private void processRemoveVehicleRequest() {
        System.out.println("Remove a vehicle");
    }

    // Handle the printing of the vehicle data
    private void displayVehicles(List<Vehicle> vehiclesToDisplay) {
        for(Vehicle vehicle : vehiclesToDisplay) {
            System.out.printf("%s|%s|%s|%s|%s|%s|%d|%.2f\n",
                    vehicle.getVin(),           // Vin
                    vehicle.getYear(),          // Year
                    vehicle.getMake(),          // Make
                    vehicle.getModel(),         // Model
                    vehicle.getVehicleType(),   // Vehicle Type
                    vehicle.getColor(),         // Color
                    vehicle.getOdometer(),      // Odometer
                    vehicle.getPrice()          // Price
            );
        }
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
