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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n"
                      + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalsEnum.hasMoreElements()) {
            double currentAmount = 0;
            Rental currentRental = (Rental) rentalsEnum.nextElement();
            //determine amounts for each line
            currentAmount = amountFor(currentRental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getMoviePriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(currentAmount) + "\n";
            totalAmount += currentAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental currentRental) {
        double currentAmount = 0;
        switch (currentRental.getMovie().getMoviePriceCode()) {
            case Movie.REGULAR:
                currentAmount += 2;
                if (currentRental.getDaysRented() > 2)
                    currentAmount += (currentRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                currentAmount += currentRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                currentAmount += 1.5;
                if (currentRental.getDaysRented() > 3)
                    currentAmount += (currentRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return currentAmount;
    }

    public String htmlStatement() {
        //To Do
        return "";
    }
}
    