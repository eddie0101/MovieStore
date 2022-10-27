import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {

    static Store store = new Store();

    public static void main(String[] args) {

        try {
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process Complete");
        }
        System.out.println(store);
        // store.action("Avatar", "sell");
        // System.out.println(store);
        // store.action("Drive", "rent");
        // System.out.println(store);
        // store.action("Drive", "return");
        // System.out.println(store);
    }

    public static void loadMovies(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String[] data = new String[3];
        while (scan.hasNextLine()) {
            data = scan.nextLine().split("--");
            store.addMovie(new Movie(data[0], data[1], Double.parseDouble(data[2])));
        }
        scan.close();
    }
}