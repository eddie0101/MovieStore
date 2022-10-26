package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating, double sellingPrice, double rentalPrice, boolean isAvailable) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))) {
            throw new IllegalArgumentException("format must be DVD or Blue-Ray");
        }
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("format cannot be null/blank");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
        this.name = name;
        if (format.equalsIgnoreCase("Blue-Ray")) {
            this.format = "Blue-Ray";
        } else if (format.equalsIgnoreCase("DVD")) {
            this.format = "DVD";
        }
        this.rating = rating;
        this.sellingPrice = sellingPrice;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))) {
            throw new IllegalArgumentException("format must be DVD or Blue-Ray");
        }
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("format cannot be null/blank");
        }
        if (format.equalsIgnoreCase("Blue-Ray")) {
            this.format = "Blue-Ray";
        } else if (format.equalsIgnoreCase("DVD")) {
            this.format = "DVD";
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
        this.rating = rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        String availability = isAvailable ? "in stock" : "rented";
        return "\t Name: " + name + "\n" +

                "\t Format: " + format + "\n" +

                "\t Rating: " + rating + "\n" +

                "\t Selling Price: " + sellingPrice + " $" + "\n" +

                "\t Rental Price: " + rentalPrice + " $" + "\n" +

                "\t Availability: " + availability + "\n";
    }    

    
}
