package BookMyShowLLD;

import BookMyShowLLD.Model.Movie;
import BookMyShowLLD.Model.Show;
import BookMyShowLLD.Model.Theater;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
    Map<String, List<Theater>> cityVSTheater;
    public TheaterController(){
        this.cityVSTheater = new HashMap<>();
    }

    public void addTheater(Theater theater, String city){
        List<Theater> list =  cityVSTheater.getOrDefault(city, new ArrayList<>());
        list.add(theater);
        cityVSTheater.put(city, list);
    }

    public Map<String, List<Theater>> getCityVSTheater() {
        return cityVSTheater;
    }

    public void setCityVSTheater(Map<String, List<Theater>> cityVSTheater) {
        this.cityVSTheater = cityVSTheater;
    }

    Map<Theater, List<Show>> getAllShow(Movie movie, String city) {


        Map<Theater, List<Show>> theatreVsShows = new HashMap<>();

        List<Theater> theatres = cityVSTheater.get(city);


        for(Theater theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

}
