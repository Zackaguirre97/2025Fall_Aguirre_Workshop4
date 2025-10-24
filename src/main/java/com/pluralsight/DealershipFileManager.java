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
