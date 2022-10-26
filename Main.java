import models.Movie;
import models.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addMovie(new Movie("Drive", "Blue-Ray", 8.7, 8.99, 3.29, true));
        store.addMovie(new Movie("Avatar", "dvd", 7.9, 12.99, 5.79, true));
        System.out.println(store);
        store.action("Avatar", "sell");
        System.out.println(store);
        store.action("Drive", "rent");
        System.out.println(store);
        store.action("Drive", "return");
        System.out.println(store);
    }
}