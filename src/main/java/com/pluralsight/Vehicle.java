package com.pluralsight;

/*
* Vehicle contains the following fields:
* - vin
* - year
* - make
* - model
* - vehicleType
* - color
* - odometer
* - price.
* Vehicle MUST be created with all fields.
* Vehicle contains all relevant data about and represents a single vehicle.
* */
public class Vehicle {
    /*
     * *** Props ***
     */
    private String vin;
    private String year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    /*
     * *** Const ***
     */
    // All args
    public Vehicle(String vin, String year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
}
