package refactoring.price;

import refactoring.Movie;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
