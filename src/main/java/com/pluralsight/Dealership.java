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
}
