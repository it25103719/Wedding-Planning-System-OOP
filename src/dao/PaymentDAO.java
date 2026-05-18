package dao;

import model.Payment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public List<Payment> getAllPayments() {

        List<Payment> payments =
                new ArrayList<>();

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "src/payments.txt"
                            )
                    );

            String line;

            while((line = reader.readLine()) != null){

                String[] parts =
                        line.split("\\|");

                int paymentId =
                        Integer.parseInt(
                                parts[0]
                                        .replace("Payment ID:","")
                                        .trim()
                        );

                String customerName =
                        parts[1]
                                .replace("Customer Name:","")
                                .trim();

                double amount =
                        Double.parseDouble(
                                parts[2]
                                        .replace("Amount:","")
                                        .trim()
                        );

                String paymentMethod =
                        parts[3]
                                .replace("Payment Method:","")
                                .trim();

                String paymentDate =
                        parts[4]
                                .replace("Payment Date:","")
                                .trim();

                Payment payment =
                        new Payment(

                                paymentId,

                                customerName,

                                amount,

                                paymentMethod,

                                paymentDate
                        );

                payments.add(payment);
            }

            reader.close();

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return payments;
    }
}