package ui;

import dao.ReviewDAO;
import model.CustomerReview;
import model.Review;

public class ReviewUI {

    public static void main(String[] args) {

        // Creating review object
        Review review = new CustomerReview(
                1,
                "Kamal",
                "ABC Photography",
                "Excellent service",
                5
        );

        // Display review type
        review.displayReviewType();

        // Saving review
        ReviewDAO dao = new ReviewDAO();
        dao.saveReview(review);
    }
}