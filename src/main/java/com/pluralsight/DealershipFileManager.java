package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
* DealershipFileManager is responsible for all file operations for the program.
* DealershipFileManager contains the following methods:
* - getDealership(): Dealership
*   - can create a new Dealership object by reading a file.
* - saveDealership(dealership)
*   - can save a passed dealership object to a file.
* */
public class DealershipFileManager {
    // Path to the file containing all the Elite Motor Exotics dealership vehicles.
    public static final String FILE_PATH = "src/main/resources/inventory.csv";
    // Create a new Dealership object by reading data from a file.
    public static Dealership getDealership() {
        Dealership dealership = null;
        // Try to read the file.
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line; // String to hold the entire line being read.
            while((line = bufferedReader.readLine()) != null) {
                // Split the line up by pipes ("|") and store in an array.
                String[] parts = line.split("\\|");
                // Set the database properties.
                if (parts.length == 3) {
                    dealership = new Dealership(
                            parts[0].trim(), // Name
                            parts[1].trim(), // Address
                            parts[2].trim()  // Phone
                    );
                } // Set the Vehicle properties.
                if(parts.length == 8 && dealership != null) {
                    Vehicle vehicle = new Vehicle(
                            parts[0].trim(),                       // Vin
                            parts[1].trim(),                       // Year
                            parts[2].trim(),                       // Make
                            parts[3].trim(),                       // Model
                            parts[4].trim(),                       // Vehicle Type
                            parts[5].trim(),                       // Color
                            Integer.parseInt(parts[6].trim()),     // Odometer
                            Double.parseDouble(parts[7].trim())    // Price
                    );
                    // Add the newly created vehicle to the Dealership vehicleList.
                    dealership.addVehicle(vehicle);
                }
            }
        } // Catch the following exceptions.
        catch (FileNotFoundException ex) {
            System.err.println("Error: File not found!");
        } catch (IOException ex) {
            System.err.println("Error: IOException encountered");
        } catch (Exception ex) {
            System.err.println("Error: Uh oh... How did we even get here?");
        }
        // Send/return the dealership created from the file
        return dealership;
    }
}
