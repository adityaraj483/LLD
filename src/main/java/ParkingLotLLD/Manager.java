package ParkingLotLLD;

import ParkingLotLLD.Enum.VehicleType;
import ParkingLotLLD.Repository.TicketRepository;
import ParkingLotLLD.model.*;

public class Manager {
    ParkingLot parkingLot;
    TicketRepository ticketRepository;
    public Manager(){
        this.ticketRepository = new TicketRepository();
    }
    void createParkingLot(String parkingLotId){
        parkingLot = new ParkingLot(parkingLotId);
    }

    public String addFloor(){
        Floor floor = new Floor(String.valueOf(ParkingLot.getCurrFlootCount()));
        parkingLot.addFloor(floor);
        return floor.getFloorId();
    }
    void addSlot(String floorId){
        Floor floor = parkingLot.getFloor(floorId);
        if(Floor.getCurrSlotCount() == 1){
            Slot slot = new Slot("Truck", String.valueOf(Floor.getCurrSlotCount()), floorId);
            floor.addSlot(slot);
        }else if(Floor.getCurrSlotCount() <=3){
            Slot slot = new Slot("Bike", String.valueOf(Floor.getCurrSlotCount()), floorId);
            floor.addSlot(slot);
        }else{
            Slot slot = new Slot("Car", String.valueOf(Floor.getCurrSlotCount()), floorId);
            floor.addSlot(slot);
        }
    }
    public Slot findAvailableSlot(VehicleType type){
        for(Floor floor : parkingLot.floors){
            for(Slot slot1 : floor.getSlots()){
                if(slot1.getVehicleType().equals(type) && slot1.isAvailable()){
                    return slot1;
                }
            }
        }
        return null;
    }
    public Ticket generateTicket(Slot slot, Vehicle vehicle){
        return new Ticket(vehicle, parkingLot, slot, parkingLot.getFloor(slot.getFloorId()));
    }

    public Floor getFloor(String floorId){
        return parkingLot.getFloor(floorId);
    }


    public void displayFreeCount(VehicleType vehicleType) throws Exception {
        if(parkingLot == null)
            throw new Exception("Not a valid Command");
        int floorId =1;
        for(Floor floor : parkingLot.getFloors()){
            int cnt = 0;
            for(Slot slot : floor.getSlots()){
                if(slot.isAvailable() && slot.getVehicleType().equals(vehicleType)) {
                    cnt++;
                }
            }
            System.out.println("No. of free slots for "+ vehicleType.toString() +" on Floor "+ floorId+": "+cnt);
            floorId++;
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        int floorId =1;
        for(Floor floor : parkingLot.getFloors()){

            System.out.print("Occupied slots for "+ vehicleType+" on Floor "+ floorId+": ");
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(Slot slot : floor.getSlots()){
                if(!slot.isAvailable() && slot.getVehicleType().equals(vehicleType))
                    sb.append(cnt).append(", ");
                cnt++;
            }
            if(sb.length() <2)
                sb.append("  ");
            System.out.println(sb.substring(0, sb.length()-2));
            floorId++;
        }
    }
    public void displayFreeSlots(VehicleType vehicleType) {
        int floorId =1;
        for(Floor floor : parkingLot.getFloors()){

            System.out.print("Free slots for "+ vehicleType+ " on Floor "+ floorId+": ");
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(Slot slot : floor.getSlots()){
                if(slot.isAvailable()  && slot.getVehicleType().equals(vehicleType))
                    sb.append(cnt).append(", ");
                cnt++;
            }
            if(sb.length() <2)
                sb.append("  ");
            System.out.println(sb.substring(0, sb.length()-2));
            floorId++;
        }
    }

    public void createTicket(Vehicle vehicle, Slot slot) {
        Ticket ticket = new Ticket(vehicle, parkingLot,slot,  parkingLot.getFloor(slot.getFloorId()));
        slot.setAvailable(false);
        ticketRepository.addTicket(ticket);
        System.out.println("Parked vehicle. Ticket ID: "+ ticket.getId());
    }
    public void removeTicket(String ticketId){
        if(!ticketRepository.isValidTicket(ticketId)){
            System.out.println("Invalid Ticket");
            return;
        }
        Ticket ticket = ticketRepository.getTicket(ticketId);
        ticket.getSlot().setAvailable(true);
        ticketRepository.remove(ticket);
        System.out.println("Unparked vehicle with Registration Number:"+ ticket.getVehicle().getRegistrationNumber() +" and "+" Color: " +ticket.getVehicle().getColor());
    }
}
