package BookMyShowLLD.Repository;

import BookMyShowLLD.Model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    Map<Integer, Booking> bookingRepository;
    public BookingRepository(){
        this.bookingRepository = new HashMap<>();
    }

    public Map<Integer, Booking> getBookingRepository() {
        return bookingRepository;
    }

    public void setBookingRepository(Map<Integer, Booking> bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public void addBooking(Booking booking){
        bookingRepository.put(booking.getId(), booking);
    }
    public void removeBooking(Booking booking){
        bookingRepository.remove(booking.getId());
    }
}
