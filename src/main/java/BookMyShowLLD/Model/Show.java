package BookMyShowLLD.Model;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

public class Show {
    List<Integer> bookedSeats;
    int showId;
    int showTime;
    Movie movie;
    Screen screen;
    public Show(int showId, int showTime, Movie movie, Screen screen){
        this.bookedSeats = new ArrayList<>();
        this.showId = showId;
        this.showTime = showTime;
        this.movie = movie;
        this.screen = screen;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeat(Integer seatId){
        bookedSeats.add(seatId);
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
