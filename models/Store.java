package models;

import java.nio.channels.IllegalSelectorException;
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

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("Empty store");
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                if (action.equalsIgnoreCase("sell")) {
                    if (!movies.get(i).isAvailable()) {
                        throw new IllegalStateException("cannot sell a rented movie");
                    }
                    movies.remove(i);
                } else if (action.equalsIgnoreCase("rent") {
                    movies.get(i).setAvailable(false);
                } else if (action.equalsIgnoreCase("return") {
                    movies.get(i).setAvailable(true);
                } else {
                    throw new IllegalArgumentException("action must be 'sell'/'rent'/'return'");
                }
            }
        }
    }

    public String toString() {
        String temp = "\n********** JAVA VIDEO STORE **********\n\n";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i) + "\n";
        }
        temp += "********** JAVA VIDEO STORE **********\n";
        return temp;
    }

}