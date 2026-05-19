package model;

// Review class for storing review details
public class Review {

    // Private variables (Encapsulation)
    private int reviewId;
    private String customerName;
    private String vendorName;
    private String comment;
    private int rating;

    // Constructor
    public Review(int reviewId, String customerName,
                  String vendorName, String comment, int rating) {

        // Assign values to variables
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.vendorName = vendorName;
        this.comment = comment;
        this.rating = rating;
    }

    // Getter method for review ID
    public int getReviewId() {
        return reviewId;
    }

    // Getter method for customer name
    public String getCustomerName() {
        return customerName;
    }

    // Getter method for vendor name
    public String getVendorName() {
        return vendorName;
    }

    // Getter method for review comment
    public String getComment() {
        return comment;
    }

    // Getter method for rating
    public int getRating() {
        return rating;
    }

    // Method for displaying review type (Polymorphism)
    public void displayReviewType() {
        System.out.println("General Review");
    }
}