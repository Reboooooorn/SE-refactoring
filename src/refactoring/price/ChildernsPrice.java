package refactoring.price;

import refactoring.Movie;

public class ChildernsPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
