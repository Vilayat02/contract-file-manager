package com.pluralsight;

import java.util.ArrayList;

public class SalesContract extends Contract{
    Vehicle v = new Vehicle();
    protected double saleTaxAmount;
    protected double recordingFee = 100;
    protected double processingFee;
    protected boolean financeNeeded;
    private static ArrayList<Contract> contracts;

    public SalesContract(String date, String customerName, String customerEmail, boolean vehicleSold, boolean financeNeeded) {
        super(date, customerName, customerEmail, vehicleSold);
        this.saleTaxAmount = v.getPrice() * 0.5;
        this.processingFee = (v.getPrice() < 10000) ? 295.0 : 495.0;
        this.financeNeeded = financeNeeded;
    }

    public double getSaleTaxAmount() {
        return saleTaxAmount;
    }

    public void setSaleTaxAmount(double saleTaxAmount) {
        this.saleTaxAmount = saleTaxAmount;
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

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceNeeded() {
        return financeNeeded;
    }

    public void setFinanceNeeded(boolean financeNeeded) {
        this.financeNeeded = financeNeeded;
    }

    @Override
    public double getTotalPrice() {
        return v.getPrice() + saleTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeNeeded) {
            return 0;
        }
        double totalPrice = getTotalPrice();
        double annualRate = (v.getPrice() < 10000) ? 0.0525 : 0.0425;
        int months = (v.getPrice() < 10000) ? 24 : 48;
        double monthlyRate = annualRate / 12;

        return totalPrice * (monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }
    
    public static boolean isVehicleSoldCheck (int a){
        boolean b = false;
        if (a == 1){
            b = true;
        } else if (a == 2) {
            b = false;
        }
        else {
            System.out.println("Wrong option!");
        }
        return b;
    }

    public void addVehicle(Contract contract) {
        this.contracts.add(contract);
    }

}
