package BookMyShowLLD.Model;

import BookMyShowLLD.Enum.SeatType;

public class Seat {
    int id;
    SeatType seatType;
    int cost;
    public Seat(int id, SeatType seatType, int cost){
        this.id = id;
        this.seatType = seatType;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
