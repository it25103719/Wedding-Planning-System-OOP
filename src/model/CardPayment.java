package model;

public class CardPayment extends Payment {

    public CardPayment(
            int paymentId,
            String customerName,
            double amount,
            String paymentDate
    ) {

        super(
                paymentId,
                customerName,
                amount,
                "Card",
                paymentDate
        );
    }

    @Override
    public String displayPaymentDetails() {

        return "CARD PAYMENT -> "
                + getCustomerName()
                + " | "
                + getAmount();
    }
}