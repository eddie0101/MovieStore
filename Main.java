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

        manageMovies();
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

    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return \n\td) exit");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("a")) {
                System.out.print("\nEnter the name of the movie: ");
                String movieName = scan.nextLine();
                store.sellMovie(movieName);
            } else if (input.equalsIgnoreCase("b")) {
                System.out.print("\nEnter the name of the movie: ");
                String movieName = scan.nextLine();
                store.rentMovie(movieName);
            } else if (input.equalsIgnoreCase("c")) {
                System.out.print("\nEnter the name of the movie: ");
                String movieName = scan.nextLine();
                store.returnMovie(movieName);
            } else if (input.equalsIgnoreCase("d")) {
                break;
            }
            System.out.println(store);
        }
        scan.close();
    }
}