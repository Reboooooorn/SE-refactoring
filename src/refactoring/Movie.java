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