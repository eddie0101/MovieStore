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

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                switch (action) {
                    case "sell": movies.remove(i); break;
                    case "rent": movies.get(i).setAvailable(false); break;
                    case "return": movies.get(i).setAvailable(true); break;
                    default: break;
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