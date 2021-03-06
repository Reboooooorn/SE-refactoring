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
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
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