package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;

public abstract class Contract {
    /*
    * *** Properties/Fields ***
    * */
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected boolean vehicleSold;
    protected Vehicle vehicle;
    /*
     * *** Constructor ***
     * */
    public Contract(String date, String customerName, String customerEmail, boolean vehicleSold, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }
    /*
     * *** Getters/Setters ***
     * */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    /*
     * *** Abstract Methods ***
     * */
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}
