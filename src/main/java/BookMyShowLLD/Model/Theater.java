package BookMyShowLLD.Model;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    List<Screen> screens;
    List<Show> shows;
    int theaterId;
    String city;
    public Theater(int theaterId, String city, List<Screen> screens, List<Show> shows){
        this.theaterId = theaterId;
        this.screens = screens;
        this.shows = shows;
        this.city = city;
    }


    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
