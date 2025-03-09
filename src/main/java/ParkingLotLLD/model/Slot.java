package ParkingLotLLD.model;

import ParkingLotLLD.Enum.VehicleType;

public class Slot {
    VehicleType vehicleType;
    String slotId;
    Boolean isAvailable;
    String floorId;
    public Slot(String vehicleType, String slotId, String floorId){
        this.vehicleType = VehicleType.getVehicleType(vehicleType);
        this.slotId = slotId;
        this.floorId = floorId;
        isAvailable = true;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
