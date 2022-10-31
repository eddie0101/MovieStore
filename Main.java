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
        }
        // } finally {
        //     System.out.println("Process Complete");
        // }
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
            if (input.equalsIgnoreCase("d")) {
                break;
            } else if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c")) {
                System.out.print("\nEnter the name of the movie: ");
                String movieName = scan.nextLine();
                if (movieName == null || movieName.isBlank()) {
                    System.out.println("\n\nThe input you provided is not valid. Please try again.\n");
                } else {
                    if (input.equalsIgnoreCase("a")) {
                        if (!store.getMovie(movieName).isAvailable()) {
                            System.out.println("\n\nThe movie is not available for purchase. Please try again.\n");
                            continue;
                        }
                        store.sellMovie(movieName);
                    } else if (input.equalsIgnoreCase("b")) {
                        store.rentMovie(movieName);
                    } else if (input.equalsIgnoreCase("c")) {
                        store.returnMovie(movieName);
                    }
                    System.out.println(store);
                }
            } else {
                System.out.println("\n\nThe input you provided is not valid. Please try again.\n");
            }

        }
        scan.close();
    }
}