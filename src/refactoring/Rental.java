package refactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getAmount() {
        return this.getMovie().getAmount((this.daysRented));
    }

    public int getFrequentRenterPoints() {
        if ((movie.getMoviePriceCode() == Movie.NEW_RELEASE) && daysRented > 1){
            return 2;
        } else {
            return 1;
        }
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}