package ParkingLotLLD.model;

import ParkingLotLLD.ParkingLot;

public class Ticket {
    String id;
    Vehicle vehicle;
    Slot slot;
    Floor floor;
    ParkingLot parkingLot;
    public Ticket(Vehicle vehicle, ParkingLot parkingLot, Slot slot, Floor floor){
        this.vehicle = vehicle;
        this.parkingLot = parkingLot;
        this.slot = slot;
        this.floor = floor;
        generateId();
    }

    private void generateId() {
        this.id = parkingLot.getParkingLotId() + "_" + floor.getFloorId() + "_" + slot.getSlotId();
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
