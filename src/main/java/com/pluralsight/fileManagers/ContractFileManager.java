package com.pluralsight.fileManagers;

import com.pluralsight.contracts.LeaseContract;
import com.pluralsight.contracts.SalesContract;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.io.*;

/*
 * ContractFileManager is responsible for all contract/contracts file operations for the program.
 * ContractFileManager contains the following methods:
 * - getContracts(): List<Contract>
 *   - can create a new list of contracts by reading a file.
 * - saveContract(contract)
 *   - can append a passed contract object to a file.
 */

public class ContractFileManager {
    // Path to the file containing all the Elite Motor Exotics dealership vehicles.
    public static final String CONTRACTS_FILE_PATH = "src/main/resources/contracts.csv";
    // Create a new Dealership object by reading data from a file.
//    public static Dealership getDealership() {
//        Dealership dealership = null;
//        // Try to read the file.
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(CONTRACTS_FILE_PATH))) {
//            String line; // String to hold the entire line being read.
//            while((line = bufferedReader.readLine()) != null) {
//                // Split the line by pipes ("|") and store in an array.
//                String[] parts = line.split("\\|");
//                // Set the database properties.
//                if (parts.length == 3) {
//                    dealership = new Dealership(
//                            parts[0].trim(), // Name
//                            parts[1].trim(), // Address
//                            parts[2].trim()  // Phone
//                    );
//                } // Set the Vehicle properties.
//                if(parts.length == 8 && dealership != null) {
//                    Vehicle vehicle = new Vehicle(
//                            parts[0].trim(),                       // Vin
//                            parts[1].trim(),                       // Year
//                            parts[2].trim(),                       // Make
//                            parts[3].trim(),                       // Model
//                            parts[4].trim(),                       // Vehicle Type
//                            parts[5].trim(),                       // Color
//                            Integer.parseInt(parts[6].trim()),     // Odometer
//                            Double.parseDouble(parts[7].trim())    // Price
//                    );
//                    // Add the newly created vehicle to the Dealership vehicleList.
//                    dealership.addVehicle(vehicle);
//                }
//            }
//        } // Catch the following exceptions.
//        catch (FileNotFoundException ex) {
//            System.err.println("\nError: File not found!\n");
//        } catch (IOException ex) {
//            System.err.println("\nError: IOException encountered\n");
//        } catch (Exception ex) {
//            System.err.println("\nError: Uh oh... How did we even get here?\n");
//        }
//        // Send/return the dealership created from the file
//        return dealership;
//    }

    // Save a contract object to the contracts file.
    public static void addContractToFile(SalesContract contract) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) {
            Vehicle vehicle = contract.getVehicle();
            String contractType = "SALE";
            writer.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f%n",
                    contractType,                           // Contract Type
                    contract.getDate(),                     // Date
                    contract.getCustomerName(),             // Customer Name
                    contract.getCustomerEmail(),            // Customer Email
                    vehicle.getVin(),                       // Vin
                    vehicle.getYear(),                      // Year
                    vehicle.getMake(),                      // Make
                    vehicle.getModel(),                     // Model
                    vehicle.getVehicleType(),               // Vehicle Type
                    vehicle.getColor(),                     // Color
                    vehicle.getOdometer(),                  // Odometer
                    vehicle.getPrice(),                     // Price
                    contract.getSalesTax(),                 // Sales Tax
                    contract.getRecordingFee(),             // Recording Fee
                    contract.getProcessingFee(),            // Processing Fee
                    contract.getTotalPrice(),               // Total Price
                    contract.isFinanced() ? "YES" : "NO",   // Finance Option
                    contract.getMonthlyPayment()            // Monthly Payment
            ));
        }
        catch(IOException e) {
            System.out.println("Error: IOException");
        }
        catch(Exception e) {
            System.out.println("Error: File Writer error");
        }
    }

    // Save a contract object to the contracts file.
    public static void addContractToFile(LeaseContract contract) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) {
            Vehicle vehicle = contract.getVehicle();
            String contractType = "LEASE";
            writer.write(String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f%n",
                    contractType,                       // Contract Type
                    contract.getDate(),                 // Date
                    contract.getCustomerName(),         // Customer Name
                    contract.getCustomerEmail(),        // Customer Email
                    vehicle.getVin(),                   // Vin
                    vehicle.getYear(),                  // Year
                    vehicle.getMake(),                  // Make
                    vehicle.getModel(),                 // Model
                    vehicle.getVehicleType(),           // Vehicle Type
                    vehicle.getColor(),                 // Color
                    vehicle.getOdometer(),              // Odometer
                    vehicle.getPrice(),                 // Price
                    contract.getExpectedEndingValue(),  // Expected Ending Value
                    contract.getLeaseFee(),             // Lease Fee
                    contract.getTotalPrice(),           // Total Price
                    contract.getMonthlyPayment()        // Monthly Payment
            ));
        }
        catch(IOException e) {
            System.out.println("Error: IOException");
        }
        catch(Exception e) {
            System.out.println("Error: File Writer error");
        }
    }
}
