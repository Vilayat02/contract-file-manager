package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership(){
        Dealership dealership = new Dealership("My Dealership", "123 Main St", "123-456-7890");
        try (BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            bufReader.readLine();
            String line;
            while ((line = bufReader.readLine()) != null){
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.getInventory().add(vehicle);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;

    }
    public void saveDealership(Dealership dealership){
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"))) {
            for (Vehicle vehicle : dealership.getInventory()) {
                bufWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                bufWriter.newLine();
            }
            bufWriter.flush();
            System.out.println("Dealership inventory saved successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
