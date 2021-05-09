package refactoring;

import refactoring.price.ChildernsPrice;
import refactoring.price.NewReleasePrice;
import refactoring.price.Price;
import refactoring.price.RegularPrice;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String movieTitle;
    private Price price;

    public Movie(String movieTitle, int moviePriceCode) {
        this.movieTitle = movieTitle;
        setMoviePriceCode(moviePriceCode);
    }

    public double getAmount(int daysRented){
        double currentAmount = 0;
        switch (this.getMoviePriceCode()) {
            case Movie.REGULAR:
                currentAmount += 2;
                if (daysRented > 2)
                    currentAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                currentAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                currentAmount += 1.5;
                if (daysRented > 3)
                    currentAmount += (daysRented - 3) * 1.5;
                break;
        }
        return currentAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((this.getMoviePriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public int getMoviePriceCode() {
        return price.getPriceCode();
    }

    public void setMoviePriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildernsPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle (){
        return movieTitle;
    };
}