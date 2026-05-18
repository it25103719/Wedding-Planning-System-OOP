package model;

public class Payment {

    private int paymentId;

    private String customerName;

    private double amount;

    private String paymentMethod;

    private String paymentDate;

    public Payment(
            int paymentId,
            String customerName,
            double amount,
            String paymentMethod,
            String paymentDate
    ) {

        this.paymentId = paymentId;

        this.customerName = customerName;

        this.amount = amount;

        this.paymentMethod = paymentMethod;

        this.paymentDate = paymentDate;
    }

    // ========= GETTERS =========

    public int getPaymentId() {
        return paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    // ========= SETTERS =========

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    // ========= POLYMORPHISM METHOD =========

    public String displayPaymentDetails() {

        return "Payment ID: " + paymentId +
                " | Customer Name: " + customerName +
                " | Amount: " + amount +
                " | Payment Method: " + paymentMethod +
                " | Payment Date: " + paymentDate;
    }
}