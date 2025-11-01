package com.pluralsight.contracts;

import com.pluralsight.models.Vehicle;

public class SalesContract extends Contract{
    /*
     * *** Properties/Fields ***
     * */
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;
    private Vehicle vehicle;
    /*
     * *** Constructor ***
     * */
    public SalesContract(// Parameters
                         String date,
                         String customerName,
                         String customerEmail,
                         boolean isFinanced,
                         Vehicle vehicle){
        // Contract properties/fields
        super(date, customerName, customerEmail, true);
        // SalesContract properties/fields
        this.vehicle = vehicle;
        this.salesTax = .05;
        this.recordingFee = 100;
        this.isFinanced = isFinanced;
        this.processingFee = calculateProcessingFee();
    }
    /*
     * *** Getters/Setters ***
     * */
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
    /*
     * *** Methods ***
     * */
    private double calculateProcessingFee() {
        return (vehicle.getPrice() <= 10000) ? 295 : 495;
    }
    /*
     * *** Overrides ***
     * */
    @Override
    public double getMonthlyPayment() {
        double paymentAmount = 0;
        if(isFinanced) {
            if(vehicle.getPrice() >= 10000) {
                paymentAmount = (vehicle.getPrice() * (0.0425 / 12)) / (1 - Math.pow((1 + (0.0425 / 12)), -48));
            }
            else {
                paymentAmount = (vehicle.getPrice() * (0.0525 / 12)) / (1 - Math.pow((1 + (0.0525 / 12)), -24));
            }
        }
        return paymentAmount;
    }

    @Override
    public double getTotalPrice() {
        double basePrice = vehicle.getPrice();
        double total = basePrice + (basePrice * salesTax) + recordingFee + getProcessingFee();
        if (isFinanced) {
            int term = basePrice >= 10000 ? 48 : 24;
            total = getMonthlyPayment() * term; // finance includes interest, so this overrides base total
        }
        return total;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTax=" + salesTax +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", isFinanced=" + isFinanced +
                ", monthlyPayment=" + getMonthlyPayment() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
