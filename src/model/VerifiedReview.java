package model;

// VerifiedReview class inherits from Review class

public class VerifiedReview extends Review {

    // Constructor
    public VerifiedReview(int reviewId, String customerName,
                          String vendorName, String comment, int rating) {

        // Calling parent constructor
        super(reviewId, customerName, vendorName, comment, rating);
    }

    // Method overriding for polymorphism
    @Override
    public void displayReviewType() {

        System.out.println("Verified Review");
    }
}