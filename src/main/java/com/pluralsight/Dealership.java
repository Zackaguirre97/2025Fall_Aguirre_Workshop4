package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/*
* Dealership contains the following fields: name, address, and phone number.
* Dealership contains a list of all the vehicles on its lot (vehicles in the file).
* Dealership MUST be created with all fields aside from the list of vehicles.
* Dealership can return multiple filtered lists based on different search conditions.
* Dealership can return a list of all its vehicles.
* Dealership can ADD and REMOVE vehicles to and from the list of vehicles.
*/
public class Dealership {
    /*
     * *** Props ***
     */
    private String name;
    private String address;
    private String phone;
    // List property
    private List<Vehicle> vehicleList;

    /*
     * *** Const ***
     */
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        vehicleList  = new ArrayList<>();
    }

    /*
     * *** Getters/Setters ***
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*
     * *** Methods ***
     */
    // Return a list of vehicles filtered by min and max price.
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        // List to be filled with only the filtered vehicles and then returned.
        List<Vehicle> filteredVehicleList = new ArrayList<>();
        // Loop through all vehicles and add the relevant ones to the return list.
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getPrice() > min && vehicle.getPrice() < max) {
                filteredVehicleList.add(vehicle);
            }
        }
        // Return the filtered list of vehicles.
        return filteredVehicleList;
    }

    // Return a list of vehicles filtered by vehicle make and model.
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // List to be filled with only the filtered vehicles and then returned.
        List<Vehicle> filteredVehicleList = new ArrayList<>();
        // Loop through all vehicles and add the relevant ones to the return list.
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicleList.add(vehicle);
            }
        }
        // Return the filtered list of vehicles.
        return filteredVehicleList;
    }

    // Return a list of vehicles filtered by min and max year.
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        // List to be filled with only the filtered vehicles and then returned.
        List<Vehicle> filteredVehicleList = new ArrayList<>();
        // Loop through all vehicles and add the relevant ones to the return list.
        for(Vehicle vehicle : vehicleList) {
            if(Integer.parseInt( vehicle.getYear()) > min && Integer.parseInt(vehicle.getYear()) < max) {
                filteredVehicleList.add(vehicle);
            }
        }
        // Return the filtered list of vehicles.
        return filteredVehicleList;
    }

    // Return a list of vehicles filtered by vehicle color.
    public List<Vehicle> getVehiclesByColor(String color) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by minimum and maximum mileage.
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by vehicle type.
    public List<Vehicle> getVehiclesByType(String type) {
        return new ArrayList<>();
    }

    // Return a list of all vehicles.
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>();
    }

    // Add a vehicle to the list.
    public void addVehicle(Vehicle vehicle) {

    }

    // Remove a vehicle from the list of vehicles.
    public void removeVehicle(Vehicle vehicle) {

    }
}
