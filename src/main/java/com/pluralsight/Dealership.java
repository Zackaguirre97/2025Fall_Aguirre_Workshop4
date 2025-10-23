package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/*
* Dealership contains the following fields: name, address, and phone number.
* Dealership contains a list of all the vehicles on its lot.
* Dealership MUST be created with all fields aside from the list of vehicles.
* Dealership can return multiple filtered lists based on different search conditions.
* Dealership can return a list of all its vehicles.
* Dealership can ADD and REMOVE vehicles to and from the list of vehicles.
*/
public class Dealership {
    // *** Props ***
    private String name;
    private String address;
    private String phone;

    private List<Vehicle> vehicleList;

    // *** Const ***
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        vehicleList  = new ArrayList<>();
    }

    // *** Getters/Setters
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

    // *** Methods ***
    // Return a list of vehicles filtered by min and max price.
    public List<Vehicle> getVehicleByPrice(double min, double max) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by vehicle make and model.
    public List<Vehicle> getVehicleByMake(String make, String model) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by min and max year.
    public List<Vehicle> getVehicleByYear(int min, int max) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by vehicle color.
    public List<Vehicle> getVehicleByColor(String color) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by minimum and maximum mileage.
    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return new ArrayList<>();
    }

    // Return a list of vehicles filtered by vehicle type.
    public List<Vehicle> getVehicleByType(String type) {
        return new ArrayList<>();
    }
}
