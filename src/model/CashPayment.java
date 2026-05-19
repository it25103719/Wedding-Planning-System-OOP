package model;

public class CashPayment extends Payment {

    public CashPayment(
            int paymentId,
            String customerName,
            double amount,
            String paymentDate
    ) {

        super(
                paymentId,
                customerName,
                amount,
                "Cash",
                paymentDate
        );
    }

    @Override
    public String displayPaymentDetails() {

        return "CASH PAYMENT -> "
                + getCustomerName()
                + " | "
                + getAmount();
    }
}