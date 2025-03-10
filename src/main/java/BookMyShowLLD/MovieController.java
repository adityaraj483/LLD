package BookMyShowLLD;

import BookMyShowLLD.Model.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieController {
    Map<String, List<Movie>> cityVSMovie;
    Set<Movie> allMovies;
    public MovieController(){
        cityVSMovie = new HashMap<>();
        allMovies = new HashSet<>();
    }

    public void addMovie(Movie movie, String city){

        List<Movie> movies = cityVSMovie.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVSMovie.put(city, movies);
        allMovies.add(movie);
    }

    public List<Movie> getMovieByCity(String city){
        return cityVSMovie.get(city);
    }
    Movie getMovieByName(String movieName) {

        for(Movie movie : allMovies) {
            if((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

}
