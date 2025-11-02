package com.pluralsight.fileManagers;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.io.*;
import java.util.Comparator;

/*
* DealershipFileManager is responsible for all dealership/inventory file operations for the program.
* DealershipFileManager contains the following methods:
* - getDealership(): Dealership
*   - can create a new Dealership object by reading a file.
* - saveDealership(dealership)
*   - can save a passed dealership object to a file.
*/
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
                // Split the line by pipes ("|") and store in an array.
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
            System.err.println("\nError: File not found!\n");
        } catch (IOException ex) {
            System.err.println("\nError: IOException encountered\n");
        } catch (Exception ex) {
            System.err.println("\nError: Uh oh... How did we even get here?\n");
        }
        // Send/return the dealership created from the file
        return dealership;
    }

    // Save a dealership object (and its List of Vehicle objects) to a file.
    public static void saveDealership(Dealership dealership) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.format("%s|%s|%s%n",
                    dealership.getName(),       // Dealership name
                    dealership.getAddress(),    // Dealership address
                    dealership.getPhone()       // Dealership phone
            ));
            dealership.getVehicleList().sort(Comparator.comparing(Vehicle::getVin));
            for (Vehicle vehicle : dealership.getVehicleList()) {
                writer.write(String.format("%s|%s|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(),           // Vin
                        vehicle.getYear(),          // Year
                        vehicle.getMake(),          // Make
                        vehicle.getModel(),         // Model
                        vehicle.getVehicleType(),   // Vehicle Type
                        vehicle.getColor(),         // Color
                        vehicle.getOdometer(),      // Odometer
                        vehicle.getPrice()          // Price
                ));
            }
        }
        catch(IOException e) {
            System.out.println("Error: IOException");
        }
        catch(Exception e) {
            System.out.println("Error: File Writer error");
        }
    }
}
