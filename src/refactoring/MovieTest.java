package refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    private final String MOVIENAME = "Saw";
    private final int PRICECODE = 0;

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIENAME, PRICECODE);
    }

    @Test
    void getPriceCode() {
        assertEquals(PRICECODE, movie.getMoviePriceCode());
    }

    @Test
    void setPriceCode() {
        movie.setMoviePriceCode(0);
        assertEquals(0, movie.getMoviePriceCode());
    }

    @Test
    void getTitle() {
        assertEquals(MOVIENAME, movie.getTitle());
    }
}
