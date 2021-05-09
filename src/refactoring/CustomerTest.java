package refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CustomerTest {
    private final String NAME = "Henning Kunz";
    private final String MOVIENAME = "Saw";

    private final int PRICECODE = 0;
    private final int DAYSRENTED = 7;

    private Movie movie;
    private Rental rental;
    private Customer customer;

    @BeforeEach
    void setUp() {
        movie = new Movie(MOVIENAME, PRICECODE);
        rental = new Rental(movie, DAYSRENTED);
        customer = new Customer(NAME);
    }

    @Test
    void addRental() {
        try {
            customer.addRental(rental);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getName() {
        assertEquals(NAME, customer.getName());
    }

    @Test
    void statement() {
        customer.addRental(rental);
        String correctStatement = "Rental Record for " + NAME + "\n"
                                + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n"
                                + "\t" + MOVIENAME + "\t" + "\t" + DAYSRENTED + "\t" + 9.5 + "\n"
                                + "Amount owed is " + 9.5 + "\n"
                                + "You earned " + 1 + " frequent renter points";

        assertEquals(correctStatement, customer.statement());
    }

    @Test
    void htmlStatement() {
        customer.addRental(rental);
        String statement = "<h1>Rentals for <em>" + customer.getName() + "</em></h1><p>\n"
                + "Saw: 9.5<br>\n"
                + "</p>You owed <em>9.5</em><p>\n"
                + "On this rental you earned <em>1</em> frequent renter points</p>";
        assertEquals(statement, customer.htmlStatement());
    }
}
