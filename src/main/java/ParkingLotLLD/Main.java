package ParkingLotLLD;

import ParkingLotLLD.Enum.Command;
import ParkingLotLLD.Enum.VehicleType;
import ParkingLotLLD.model.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Manager manager = new Manager();

        while(scn.hasNext()){
            String command = scn.nextLine();
            process(command, manager);
        }
    }

    private static void process(String command, Manager manager) throws Exception {
        String[] cmd = command.split(" ");

        Command command1 = Command.getCommand(cmd[0]);
        switch (command1){
            case create_parking_lot:
                createParkingLot(manager, cmd);
                break;
            case display:
                display(manager, cmd);
                break;
            case park_vehicle:
                parkVehicle(manager, cmd);
                break;
            case unpark_vehicle:
                unParkVehicle(manager, cmd);
                break;
            case exit:
                System.exit(0);
        }
    }

    private static void unParkVehicle(Manager manager, String[] cmd) {
        String ticketId = cmd[1];
        manager.removeTicket(ticketId);
    }

    private static void parkVehicle(Manager manager, String[] cmd) {
        String vehicleType = cmd[1];
        String registrationNo = cmd[2];
        String color = cmd[3];
        Vehicle vehicle = new Vehicle(vehicleType, registrationNo, color);
        Slot slot = manager.findAvailableSlot(VehicleType.getVehicleType(vehicleType));
        if(slot == null) {
            System.out.println("ParkingLot is full");
            return ;
        }
        manager.createTicket(vehicle, slot);
    }

    private static void display(Manager manager, String[] cmd) throws Exception {
        Command command = Command.getCommand(cmd[1]);
        VehicleType vehicleType = VehicleType.getVehicleType(cmd[2]);

        switch (command){
            case free_count:
                displayFreeCount(vehicleType, manager);
                break;
            case free_slots:
                displayFreeSlot(vehicleType, manager);
                break;
            case occupied_slots:
                displayOccupiedSlot(vehicleType, manager);
        }
    }

    private static void displayOccupiedSlot(VehicleType vehicleType, Manager manager) throws Exception {
        manager.displayOccupiedSlots(vehicleType);
    }

    private static void displayFreeSlot(VehicleType vehicleType, Manager manager) {
        manager.displayFreeSlots(vehicleType);
    }

    private static void displayFreeCount(VehicleType vehicleType, Manager manager) throws Exception {
        manager.displayFreeCount(vehicleType);
    }

    private static void createParkingLot(Manager manager, String[] cmd) {
        String parkingLotId = cmd[1];
        int noOfFloors = Integer.parseInt(cmd[2]);
        int noOfSlotsAtEachFloor = Integer.parseInt(cmd[3]);

        manager.createParkingLot(parkingLotId);

        for(int i=0;i<noOfFloors;i++){
            String floorId = manager.addFloor();
            for (int j=0;j<noOfSlotsAtEachFloor;j++){
                manager.addSlot(floorId);
            }
        }
        System.out.println("Created parking lot with "+ noOfFloors+" floors and "+noOfSlotsAtEachFloor+" slots per floor");
    }
}
