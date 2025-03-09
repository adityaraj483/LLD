package ParkingLotLLD;

import ParkingLotLLD.model.Floor;

import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<Floor> floors;
    static int currFlootCount = 1;

    public static int getCurrFlootCount() {
        return currFlootCount;
    }

    public static void setCurrFlootCount(int currFlootCount) {
        ParkingLot.currFlootCount = currFlootCount;
    }

    public ParkingLot(String parkingLotId){
        this.parkingLotId = parkingLotId;
        floors = new LinkedList<>();
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
        ParkingLot.currFlootCount++;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Floor getFloor(String floorId){
        for(Floor floor : floors){
            if(floor.getFloorId().equalsIgnoreCase(floorId))
                return floor;
        }
        return null;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
