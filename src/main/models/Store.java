package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    private ArrayList<Movie> movies;

    public Store() {
        movies = new ArrayList<Movie>();
    }
    
    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public Movie getMovie(String movieName) {
        for (int i = 0; i < movies.size(); i++) {
            if (movieName.equalsIgnoreCase(movies.get(i).getName())) {
                return new Movie(movies.get(i));
            }
        }
        return null;
    }

    public void setMovie(Movie movie, int index) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    private int getMovieIndex(String name) {
        return IntStream.range(0, movies.size())
                .filter(i -> movies.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);
    }

    public void sellMovie(String movieName) {
        //action(movieName, "sell");
        if (!movies.get(getMovieIndex(movieName)).isAvailable()) {
            throw new IllegalStateException("cannot sell a rented movie");
        }
        movies.removeIf((movie) -> movie.getName().equals(movieName));
    }

    public void rentMovie(String movieName) {
        //action(movieName, "rent");
        movies.get(getMovieIndex(movieName)).setAvailable(false);
    }

    public void returnMovie(String movieName) {
        //action(movieName, "return");
        movies.get(getMovieIndex(movieName)).setAvailable(true);
    }

    // private void action(String movieName, String action) {
    //     if (movies.isEmpty()) {
    //         throw new IllegalStateException("Empty store");
    //     }
    //     if (movieName == null || movieName.isBlank()) {
    //         throw new IllegalArgumentException("movie name cannot be null/blank");
    //     }
    //     for (int i = 0; i < movies.size(); i++) {
    //         if (movies.get(i).getName().equals(movieName)) {
    //             if (action.equalsIgnoreCase("sell")) {
    //                 if (!movies.get(i).isAvailable()) {
    //                     throw new IllegalStateException("cannot sell a rented movie");
    //                 }
    //                 movies.remove(i);
    //             } else if (action.equalsIgnoreCase("rent")) {
    //                 movies.get(i).setAvailable(false);
    //             } else if (action.equalsIgnoreCase("return")) {
    //                 movies.get(i).setAvailable(true);
    //             } else {
    //                 throw new IllegalArgumentException("action must be 'sell'/'rent'/'return'");
    //             }
    //         }
    //     }
    // }

    public String toString() {
        String temp = "\n********** JAVA VIDEO STORE **********\n\n";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i) + "\n";
        }
        temp += "********** JAVA VIDEO STORE **********\n";
        return temp;
    }

}