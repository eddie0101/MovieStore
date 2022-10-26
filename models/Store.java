package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    public Store() {
        movies = new ArrayList<Movie>();
    }
    
    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(Movie movie, int index) {
        movies.set(index, new Movie(movie));
    }

    
}
