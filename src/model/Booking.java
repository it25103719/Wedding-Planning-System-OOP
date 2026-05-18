package model;

public class Booking {

    private int bookingId;
    private String customerName;
    private String vendorName;
    private String bookingDate;

    // CONSTRUCTOR

    public Booking(
            int bookingId,
            String customerName,
            String vendorName,
            String bookingDate
    ) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.vendorName = vendorName;
        this.bookingDate = bookingDate;
    }

    // GETTERS

    public int getBookingId() {

        return bookingId;
    }

    public String getCustomerName() {

        return customerName;
    }

    public String getVendorName() {

        return vendorName;
    }

    public String getBookingDate() {

        return bookingDate;
    }

    // SETTERS

    public void setBookingId(int bookingId) {

        this.bookingId = bookingId;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public void setVendorName(String vendorName) {

        this.vendorName = vendorName;
    }

    public void setBookingDate(String bookingDate) {

        this.bookingDate = bookingDate;
    }
}