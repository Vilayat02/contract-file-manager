package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

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

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public static List<Vehicle> getVehiclesByPrice(double min, double max) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getMake().trim().equalsIgnoreCase(make) && vehicle.getModel().trim().equalsIgnoreCase(model)) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> getVehiclesByYear(int min, int max) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> getVehiclesByColor(String color) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getColor().trim().equalsIgnoreCase(color)) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> getVehiclesByMileage(int min, int max) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> getVehiclesByType(String type) {
        try {
            List<Vehicle> veh = Dealership.getAllVehicles();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : veh) {
                if (vehicle.getVehicleType().trim().equalsIgnoreCase(type)) {
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> getAllVehicles() {
        DealershipFileManager dfm = new DealershipFileManager();
        Dealership dealership = dfm.getDealership();
        return dealership.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
