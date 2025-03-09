package ParkingLotLLD.Enum;

public enum VehicleType {
    Car("Car"),
    Bike("Bike"),
    Truck("Truck");

    public final String type;
    VehicleType(String vehicleType){
        this.type = vehicleType;
    }
    public static VehicleType getVehicleType(String type){
        for(VehicleType vehicleType : VehicleType.values()){
            if(vehicleType.type.equalsIgnoreCase(type))
                return vehicleType;
        }
        return null;
    }
}
