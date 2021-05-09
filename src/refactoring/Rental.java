package refactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getAmount() {
        double currentAmount = 0;
        switch (this.getMovie().getMoviePriceCode()) {
            case Movie.REGULAR:
                currentAmount += 2;
                if (this.getDaysRented() > 2)
                    currentAmount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                currentAmount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                currentAmount += 1.5;
                if (this.getDaysRented() > 3)
                    currentAmount += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return currentAmount;
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