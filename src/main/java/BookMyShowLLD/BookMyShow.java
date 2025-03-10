package BookMyShowLLD;


import BookMyShowLLD.Enum.PaymentStatus;
import BookMyShowLLD.Enum.PaymentType;
import BookMyShowLLD.Enum.SeatType;
import BookMyShowLLD.Model.*;
import BookMyShowLLD.Repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheaterController theatreController;
    BookingRepository repository;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheaterController();
        repository = new BookingRepository();
    }


    public static void main(String args[]) {

        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking("PATNA", "BAAHUBALI");
        //user2
        bookMyShow.createBooking("PATNA", "BAAHUBALI");

    }

    private void createBooking(String userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMovieByCity(userCity);

        //2. select the movie which you want to see. i want to see Baahubali
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theater, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theater,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        Booking booking = new Booking();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment

            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeats(myBookedSeats);
            booking.setShow(interestedShow);
            booking.setPayment(new Payment(1, PaymentType.UPI));
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }
        booking.getPayment().setPaymentStatus(PaymentStatus.SUCCESS);
        repository.addBooking(booking);
        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    private void createTheatre() {
        List<Seat> seats1 = new ArrayList<>();
        seats1 = creteSeats(100);
        Screen screen1 = new Screen(1, seats1);
        List<Show> shows1 = createShows(screen1, "DELHI");

        Theater theater1 = new Theater(1, "DELHI", List.of(screen1),shows1);


        List<Seat> seats2 = new ArrayList<>();
        seats1 = creteSeats(120);
        Screen screen2 = new Screen(1, seats2);
        List<Show> shows2 = createShows(screen2, "PATNA");

        Theater theater2 = new Theater(1, "PATNA", List.of(screen1),shows2);

        theatreController.addTheater(theater1, "DELHI");
        theatreController.addTheater(theater2, "PATNA");
    }

    private List<Show> createShows(Screen screen, String city) {
        List<Show> shows = new ArrayList<>();
        Movie movie1 = movieController.getMovieByCity(city).get(0);
        Show show1 = new Show(1,10, movie1, screen);

        Movie movie2 = movieController.getMovieByCity(city).get(1);
        Show show2 = new Show(2,14, movie2, screen);
        shows.add(show1);
        shows.add(show2);
        return shows;
    }

    private List<Seat> creteSeats(int count) {
        List<Seat> seats = new ArrayList<>();
        for(int i=0;i<count;i++){
            if( i < 40){
                seats.add(new Seat(i, SeatType.PLATINUM, 50));
            }else if( i < 80){
                seats.add(new Seat(i, SeatType.GOLD, 70));
            }else{
                seats.add(new Seat(i, SeatType.DIAMOND, 100));
            }
        }
        return seats;
    }

    private void createMovies(){
        Movie movie1 = new Movie(1, "BAAHUBALI");
        Movie movie2 = new Movie(2, "BAAHUBALI");
        Movie movie3 = new Movie(3, "ROBIN HOOD");
        Movie movie4 = new Movie(4, "ROBIN HOOD");

        movieController.addMovie(movie1, "DELHI");
        movieController.addMovie(movie2, "PATNA");
        movieController.addMovie(movie3, "DELHI");
        movieController.addMovie(movie4, "PATNA");
    }
}
