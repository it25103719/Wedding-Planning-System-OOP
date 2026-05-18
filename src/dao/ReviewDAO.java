package dao;

import model.Review;

import java.io.FileWriter;
import java.io.IOException;

public class ReviewDAO {

    // Method to save review details to reviews.txt file
    public void saveReview(Review review) {

        try {

            FileWriter writer = new FileWriter("reviews.txt", true);

            writer.write(
                    review.getReviewId() + "," +
                            review.getCustomerName() + "," +
                            review.getVendorName() + "," +
                            review.getComment() + "," +
                            review.getRating() + "\n"
            );

            writer.close();

            System.out.println("Review saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving review.");
        }
    }
}