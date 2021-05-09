package refactoring;

import java.lang.*;
import java.util.*;

class Customer {
    private String customerName;
    private Vector rentals = new Vector();

    public Customer (String newCustomerName){
        customerName = newCustomerName;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName (){
        return customerName;
    }

    public String statement() {
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n"
                      + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalsEnum.hasMoreElements()) {
            Rental currentRental = (Rental) rentalsEnum.nextElement();
            //show figures for this rental
            result += "\t" + currentRental.getMovie().getTitle() + "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentRental.getAmount()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalsEnum.nextElement();
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        Enumeration rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalsEnum.nextElement();
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    public String htmlStatement() {
        //To Do
        return "";
    }
}
    