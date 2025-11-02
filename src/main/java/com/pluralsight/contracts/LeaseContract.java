package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;


public class LeaseContract extends Contract{
    /*
    * *** Properties/Fields ***
    * */
    private double expectedEndingValue;
    private double leaseFee;
    public static final int TERM = 36;
    /*
     * *** Constructor ***
     * */
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, false, vehicle);
        this.expectedEndingValue = calculateExpectedEndingValue();
        this.leaseFee = calculateLeaseFee();
    }
    /*
     * *** Getters/Setters ***
     * */
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    /*
     * *** Methods ***
     * */
    public double calculateExpectedEndingValue() {
        return vehicle.getPrice() * .5;
    }

    public double calculateLeaseFee() {
        return vehicle.getPrice() * .07;
    }

    @Override
    public double getTotalPrice() {
        return getMonthlyPayment() * TERM;
    }

    @Override
    public double getMonthlyPayment() {
        double price = vehicle.getPrice();
        double rate = .04 / 12;
        double baseAmount = (price - expectedEndingValue) + leaseFee;
        return (baseAmount * rate) / (1 - Math.pow(1 + rate, -TERM));
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                ", monthlyPayment=" + getMonthlyPayment() +
                ", TotalPrice=" + getTotalPrice() +
                '}';
    }
}