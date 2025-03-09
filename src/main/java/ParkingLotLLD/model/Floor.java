package ParkingLotLLD.model;

import java.util.LinkedList;
import java.util.List;

public class Floor {
    List<Slot> slots;
    String floorId;
    static int currSlotCount = 1;

    public static int getCurrSlotCount() {
        return currSlotCount;
    }

    public static void setCurrSlotCount(int currSlotCount) {
        Floor.currSlotCount = currSlotCount;
    }

    public Floor(String floorId){
        this.floorId = floorId;
        this.slots = new LinkedList<>();
        currSlotCount = 0;
    }

    public void addSlot(Slot slot){
        this.slots.add(slot);
        Floor.currSlotCount++;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

}
