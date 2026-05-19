package model;

// CustomerReview class inherits from Review class

public class CustomerReview extends Review {

    // Constructor
    public CustomerReview(int reviewId, String customerName,
                          String vendorName, String comment, int rating) {

        super(reviewId, customerName, vendorName, comment, rating);
    }

    // Method overriding for polymorphism
    @Override
    public void displayReviewType() {

        System.out.println("Customer Review");
    }
}