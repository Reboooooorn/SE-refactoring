package refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String movieTitle;
    private int moviePriceCode;

    public Movie(String movieTitle, int moviePriceCode) {
        this.movieTitle = movieTitle;
        this.moviePriceCode = moviePriceCode;
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

    public int getMoviePriceCode() {
        return moviePriceCode;
    }

    public void setMoviePriceCode(int arg) {
        moviePriceCode = arg;
    }

    public String getTitle (){
        return movieTitle;
    };
}