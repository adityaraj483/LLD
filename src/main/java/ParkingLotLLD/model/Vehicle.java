package ParkingLotLLD.model;


import ParkingLotLLD.Enum.VehicleType;

public class Vehicle {
    VehicleType type;
    String registrationNumber;
    String color;
    public Vehicle(String type, String registrationNumber, String color){
        this.type = VehicleType.getVehicleType(type);
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = VehicleType.getVehicleType(type);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
