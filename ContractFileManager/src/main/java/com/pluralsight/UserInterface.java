package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner sc = new Scanner(System.in);
    private Dealership dealership;
    private List<Vehicle> vehicles;
    private DealershipFileManager fileManager = new DealershipFileManager();

    public UserInterface() {
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership(); // загружаем дилершип с файла
    }

    public void display() {
        init();
        boolean run = true;
        while (run) {
            System.out.println("\nChoose an option:\n1-Find vehicles within a price range\n2-Find vehicles by make/model\n3-Find vehicles by year range\n4-Find vehicles by color\n5-Find vehicles by mileage range\n6-Find vehicles by type (car,truck,SUV,van)\n7-List ALL vehicles\n8-Add a vehicle\n9-Remove a vehicle\n10-Lease Contract\n11-SalesContract\n99-Quit");
            int choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                case 1:
                processGetByPriceRequest();
                    break;
                case 2:
                processGetByModelrequest();
                    break;
                case 3:
                processGetByYearRequest();
                    break;
                case 4:
                processGetByColorRequest();
                    break;
                case 5:
                processGetByMileageRequest();
                    break;
                case 6:
                processGetByVehicleTypeRequest();
                    break;
                case 7:
                processGetAllVehiclesRequest();
                    break;
                case 8:
                processAddVehicleRequest();
                    break;
                case 9:
                processRemoveVehicleRequest();
                    break;
                case 10:

                    break;
                case 11:
                    processSalesContract();
                    break;
                case 99:
                    run = false;
                    break;
            }
        }
    }

        public void processGetByPriceRequest () {
            System.out.print("Enter min range:");
            int min = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter max range: ");
            int max = sc.nextInt();
            sc.nextLine();
            vehicles = Dealership.getVehiclesByPrice(min, max);
            displayFormat(vehicles);
        }
        public void processGetByModelrequest () {
            System.out.print("Enter make:");
            String make = sc.nextLine();
            System.out.print("Enter model: ");
            String model = sc.nextLine();
            vehicles = Dealership.getVehiclesByMakeModel(make, model);
            displayFormat(vehicles);
        }
        public void processGetByYearRequest () {
            System.out.print("Enter min range:");
            int minYear = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter max range: ");
            int maxYear = sc.nextInt();
            sc.nextLine();
            vehicles = Dealership.getVehiclesByYear(minYear, maxYear);
            displayFormat(vehicles);
        }
        public void processGetByColorRequest () {
            System.out.print("Enter color:");
            String color = sc.nextLine();
            vehicles = Dealership.getVehiclesByColor(color);
            displayFormat(vehicles);
        }
        public void processGetByMileageRequest () {
            System.out.print("Enter min mileage range: ");
            int minMileage = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter max mileage range: ");
            int maxMileage = sc.nextInt();
            sc.nextLine();
            vehicles = Dealership.getVehiclesByMileage(minMileage, maxMileage);
            displayFormat(vehicles);
        }
        public void processGetByVehicleTypeRequest () {
            System.out.print("Enter type of car:");
            String type = sc.nextLine();
            vehicles = Dealership.getVehiclesByType(type);
            displayFormat(vehicles);
        }
        public void processGetAllVehiclesRequest () {
            vehicles = Dealership.getAllVehicles();
            displayFormat(vehicles);
        }
        public void processAddVehicleRequest () {
            dealership.addVehicle(processAddVehicleProcess());
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle added succesfully!");
        }
        public void processSalesContract(){
            System.out.print("Please enter date (yearMonthDay like (20250515)): ");
            String date = sc.nextLine();
            System.out.print("Customer name: ");
            String customerName = sc.nextLine();
            System.out.print("Customer E-mail: ");
            String customerEmail = sc.nextLine();
            Vehicle veh = processAddVehicleProcess();
            System.out.print("Is vehicle sold? 1.Yes  2.No : ");
            int vehicleSold = sc.nextInt();
            sc.nextLine();
            boolean check1 = SalesContract.isVehicleSoldCheck(vehicleSold);
            System.out.print("Finance needed? 1.Yes 2.No : ");
            int financeNeeded = sc.nextInt();
            sc.nextLine();
            boolean check2 = SalesContract.isVehicleSoldCheck(financeNeeded);
            SalesContract salesContract = new SalesContract(date, customerName, customerEmail, check1, check2);
            ContractDataManager.saveContract(salesContract,veh);
        }

    public Vehicle processAddVehicleProcess () {
        System.out.print("Please enter vehicle data:\nVin: ");
        int vin = sc.nextInt();
        sc.nextLine();
        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Make: ");
        String make1 = sc.nextLine();
        System.out.print("Model: ");
        String model1 = sc.nextLine();
        System.out.print("Vehicle Type (car,truck,SUV,van): ");
        String vehicleType = sc.nextLine();
        System.out.print("Color: ");
        String color1 = sc.nextLine();
        System.out.print("Odometer: ");
        int odo = sc.nextInt();
        sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        return new Vehicle(vin, year, make1, model1, vehicleType, color1, odo, price);

    }

        public void processRemoveVehicleRequest () {
            System.out.print("Enter VIN of the vehicle to remove: ");
            int vin = sc.nextInt();
            sc.nextLine();

            List<Vehicle> inventory = dealership.getInventory();
            Vehicle vehicleToRemove = null;

            for (Vehicle v : inventory) {
                if (v.getVin() == vin) {
                    vehicleToRemove = v;
                    break;
                }
            }

            if (vehicleToRemove != null) {
                dealership.removeVehicle(vehicleToRemove);
                fileManager.saveDealership(dealership); // перезапись файла без удалённой машины
                System.out.println("Vehicle removed from inventory");
            } else {
                System.out.println("Vehicle not found");
            }
        }

        public void displayFormat (List < Vehicle > vehicle) {
            if (vehicle.isEmpty()) {
                System.out.println("No vehicles in inventory.");
            } else {
                for (Vehicle v : vehicle) {
                    System.out.println("VIN: " + v.getVin() + "| Year: " + v.getYear() + "| Make: " + v.getMake() + "| Model: " + v.getModel() + "| Type: " + v.getVehicleType() + "| Color: " + v.getColor() + "| Odometer: " + v.getOdometer() + "| Price: $" + v.getPrice());
                }
            }
        }
    }
