package ParkingLotLLD.Repository;

import ParkingLotLLD.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<String, Ticket> ticketIdVSTicket;
    public TicketRepository(){
        ticketIdVSTicket = new HashMap<>();
    }

    public void addTicket(Ticket ticket){
        ticketIdVSTicket.put(ticket.getId(), ticket);
    }
    public void remove(Ticket ticket){
        ticketIdVSTicket.remove(ticket.getId());
    }
    public boolean isValidTicket(String ticketId){
        return ticketIdVSTicket.containsKey(ticketId);
    }
    public Ticket getTicket(String ticketId){
        return ticketIdVSTicket.get(ticketId);
    }
}
