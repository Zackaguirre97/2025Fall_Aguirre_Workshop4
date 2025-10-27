package com.pluralsight;

import java.util.ArrayList;
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
    private static Scanner sc = new Scanner(System.in);

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
                case 10 -> processPurchaseVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("\nInvalid entry: Please enter a number from the list (1-9 & 99)");
            }
        }
        sc.close();
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
        System.out.println("10. Purchase a vehicle");
        System.out.println("99. Quit");
        System.out.print("Select an option: ");
    }

    private void processGetByPriceRequest() {
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
        // Method variables
        String make = "";
        String model = "";
        while (true) {
            System.out.print("Enter the make (e.g. 'Porsche', 'Ferrari', 'Nissan', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }
            make = input;
            break;
        }

        while (true) {
            System.out.print("Enter the model (e.g. 'Portofino', 'M8 Competition', 'Huracán EVO', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }
            model = input;
            break;
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        if (results.isEmpty()) {
            System.out.println("No vehicles found with that make and model.");
        } else {
            System.out.printf("Vehicles matching %s %s:%n", make, model);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of vehicles by year
    private void processGetByYearRequest() {
        int min = 0;
        int max = 0;

        // --- Get minimum year ---
        while (true) {
            System.out.print("Enter the minimum year (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isInteger(input)) {
                min = Integer.parseInt(input);
                if (min < 1950) {
                    System.out.println("Error: Please enter a value greater than 1950!");
                    continue;
                }
                if (min > 2026) {
                    System.out.println("Error: Min must be less than 2027!");
                    continue;
                }
                break; // valid min entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 1990 or 2025)!");
            }
        }

        // --- Get maximum year ---
        while (true) {
            System.out.print("Enter the maximum year (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isInteger(input)) {
                max = Integer.parseInt(input);
                if (max <= min) {
                    System.out.println("Error: Max year must be greater than min year!");
                    continue;
                }
                if (max > 2026) {
                    System.out.println("Error: Max must be less than 2026!");
                    continue;
                }
                break; // valid max entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 1990 or 2025)!");
            }
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByYear(min, max);
        if (results.isEmpty()) {
            System.out.println("No vehicles found in that year range.");
        } else {
            System.out.printf("Vehicles between %d and %d:%n", min, max);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of vehicles by color
    private void processGetByColorRequest() {
        // Method variables
        String color = "";
        while (true) {
            System.out.print("Enter the color (e.g. 'Blue', 'Red', 'Black', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }
            color = input;
            break;
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByColor(color);
        if (results.isEmpty()) {
            System.out.println("No vehicles found with that color.");
        } else {
            System.out.printf("Vehicles with a color of: %s%n", color);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of vehicles by mileage
    private void processGetByMileageRequest() {
        int min = 0;
        int max = 0;

        // --- Get minimum year ---
        while (true) {
            System.out.print("Enter the minimum mileage (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isInteger(input)) {
                min = Integer.parseInt(input);
                if (min < 1) {
                    System.out.println("Error: Please enter a value greater than 0!");
                    continue;
                }
                if (min > 500000) {
                    System.out.println("Error: Min must be less than 150000!");
                    continue;
                }
                break; // valid min entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 50 or 125000)!");
            }
        }

        // --- Get maximum year ---
        while (true) {
            System.out.print("Enter the maximum mileage (or 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isInteger(input)) {
                max = Integer.parseInt(input);
                if (max <= min) {
                    System.out.println("Error: Max mileage must be greater than min mileage!");
                    continue;
                }
                if (max > 500000) {
                    System.out.println("Error: Max must be less than 500000!");
                    continue;
                }
                break; // valid max entered
            } else {
                System.out.println("Error: Please enter a valid number (e.g. 50 or 1250000)!");
            }
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        if (results.isEmpty()) {
            System.out.println("No vehicles found in that mileage range.");
        } else {
            System.out.printf("Vehicles between %d and %d:%n", min, max);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of vehicles by vehicle type
    private void processGetByVehicleTypeRequest() {
        // Method variables
        String type = "";
        while (true) {
            System.out.print("Enter the type (e.g. 'Coupe', 'Sedan', 'SUV', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }
            type = input;
            break;
        }

        // --- Display results ---
        List<Vehicle> results = dealership.getVehiclesByType(type);
        if (results.isEmpty()) {
            System.out.println("No vehicles found matching that type.");
        } else {
            System.out.printf("Vehicles with a type of: %s%n", type);
            displayVehicles(results);
        }
    }

    // Handle the user requests to get a list of all vehicles
    private void processGetAllVehiclesRequest() {
        List<Vehicle> displayList = dealership.getAllVehicles();
        displayVehicles(displayList);
    }

    // Handle the user requests to add a vehicle to the list
    private void processAddVehicleRequest() {
        // Temp variables to store the new vehicle data.
        String vin;
        String year;
        String make;
        String model;
        String type;
        String color;
        int odometer;
        double price;

        String input;
        while(true) {
            System.out.print("Enter the vin (e.g. '90008', '90010', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            vin = input;
            break;
        }

        while(true) {
            System.out.print("Enter the year (e.g. '1990', '2000', '2025', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            year = input;
            break;
        }

        while(true) {
            System.out.print("Enter the make (e.g. 'Porsche', 'Ferrari', 'Nissan', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            make = input;
            break;
        }

        while(true) {
            System.out.print("Enter the model (e.g. 'Portofino', 'M8 Competition', 'Huracán EVO', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            model = input;
            break;
        }

        while(true) {
            System.out.print("Enter the type (e.g. 'Coupe', 'Sedan', 'SUV', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            type = input;
            break;
        }

        while(true) {
            System.out.print("Enter the color (e.g. 'Blue', 'Red', 'Black', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            color = input;
            break;
        }

        while(true) {
            System.out.print("Enter the odometer (e.g. '50', '20000', '150000', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isInteger(input)) {
                odometer = Integer.parseInt(input);
                if (odometer < 0) {
                    System.out.println("Error: Please enter a positive number!");
                    continue;
                }
            } else {
                System.out.println("Error: Please enter a number!");
                continue;
            }
            break;
        }

        while(true) {
            System.out.print("Enter the price (e.g. '150000', '749999.99', '2500000', etc. OR 'X' to go back): ");
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            if (isDouble(input)) {
                price = Double.parseDouble(input);
                if (price < 0) {
                    System.out.println("Error: Please enter a positive number!");
                    continue;
                }
            } else {
                System.out.println("Error: Please enter a number!");
                continue;
            }
            break;
        }

        Vehicle vehicleToAdd = new Vehicle(vin, year, make, model, type, color, odometer, price);

        System.out.println("Adding vehicle...");
        dealership.addVehicle(vehicleToAdd);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Process completed!");
    }

    // Handle the user requests to remove a vehicle from the list
    private void processRemoveVehicleRequest() {
        while (true) {
            System.out.print("Enter the vin (e.g. '90008', '90010', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            Vehicle vehicleToRemove = dealership.getVehicleByVin(input);
            if (vehicleToRemove == null) {
                System.out.println("Error: No vehicle found matching that vin!");
            } else {
                System.out.printf("Removing vehicle with vin: %s%n", input);
                dealership.removeVehicle(vehicleToRemove);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Process completed!");
                return;
            }
        }
    }

    // Handle the user requests to remove a vehicle from the list
    private void processPurchaseVehicleRequest() {
        while (true) {
            System.out.print("Enter the vin (e.g. '90008', '90010', etc. OR 'X' to go back): ");
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {
                System.out.println("Going back...");
                return;
            }

            Vehicle vehicleToPurchase = dealership.getVehicleByVin(input);
            if (vehicleToPurchase == null) {
                System.out.println("Error: No vehicle found matching that vin!");
            } else {
                System.out.println("Purchase successful!");
                System.out.printf("Removing vehicle with vin: %s from the vehicle list.%n", input);
                dealership.removeVehicle(vehicleToPurchase);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Process completed!");
                return;
            }
        }
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
