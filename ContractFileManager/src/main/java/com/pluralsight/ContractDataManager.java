package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public static void saveContract(Contract contract, Vehicle vehicle) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true))) {
                String line;
                if (contract instanceof SalesContract) {
                    SalesContract salesContract = (SalesContract) contract;
                    line = "SALES|" +
                            salesContract.getDate() + "|" +
                            salesContract.getCustomerName() + "|" +
                            salesContract.getCustomerEmail() + "|" + vehicle.getVin() + "|" +vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" +
                            salesContract.isVehicleSold() + "|" +
                            salesContract.getTotalPrice() + "|" +
                            salesContract.getMonthlyPayment() + "|" +
                            salesContract.isFinanceNeeded() + "|" +
                            salesContract.getRecordingFee() + "|" +
                            salesContract.getProcessingFee();
                } else if (contract instanceof LeaseContract) {
                    LeaseContract leaseContract = (LeaseContract) contract;
                    line = "LEASE|" +
                            leaseContract.getDate() + "|" +
                            leaseContract.getCustomerName() + "|" +
                            leaseContract.getCustomerEmail() + "|" +
                            leaseContract.isVehicleSold() + "|" +
                            leaseContract.getTotalPrice() + "|" +
                            leaseContract.getMonthlyPayment() + "|" +
                            leaseContract.getExpectedEndingValue() + "|" +
                            leaseContract.getLeaseFee();
                } else {
                    System.out.println("Unknown contract type. Cannot save.");
                    return;
                }

                bf.write(line);
                bf.newLine();
                bf.close();
                System.out.println("Contract saved successfully!");

            }


        catch(IOException e){
            System.out.println("Error writing contract to file: " + e.getMessage());
        }

    }
}
