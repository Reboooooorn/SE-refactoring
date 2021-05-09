package refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {
    private final String MOVIENAME = "Saw";
    private final int PRICECODE = 0;
    private final int DAYSRENTED = 7;

    private Movie movie;
    private Rental rental;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIENAME, PRICECODE);
        rental = new Rental(movie, DAYSRENTED);
    }

    @Test
    void getDaysRented() {
        assertEquals(DAYSRENTED, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        assertEquals(movie, rental.getMovie());
    }
}
