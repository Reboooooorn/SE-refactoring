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
       return movie.getFrequentRenterPoints(daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}