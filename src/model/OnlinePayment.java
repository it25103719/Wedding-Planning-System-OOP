package model;

public class OnlinePayment extends Payment {

    public OnlinePayment(
            int paymentId,
            String customerName,
            double amount,
            String paymentDate
    ) {

        super(
                paymentId,
                customerName,
                amount,
                "Online",
                paymentDate
        );
    }

    @Override
    public String displayPaymentDetails() {

        return "ONLINE PAYMENT -> "
                + getCustomerName()
                + " | "
                + getAmount();
    }
}