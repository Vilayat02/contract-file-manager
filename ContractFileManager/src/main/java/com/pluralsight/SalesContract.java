package com.pluralsight;

public class SalesContract extends Contract{
    protected double saleTaxAmount;
    protected double recordingFee;
    protected double processingFee;
    protected boolean financeNeeded;

    public SalesContract(String date, String customerName, String customerEmail, boolean vehicleSold, double saleTaxAmount, double recordingFee, double processingFee, boolean financeNeeded) {
        super(date, customerName, customerEmail, vehicleSold);
        this.saleTaxAmount = saleTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
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
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
