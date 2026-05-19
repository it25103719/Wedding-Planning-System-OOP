package ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class PaymentUI {

    // ================= AUTO PAYMENT ID =================

    private String generatePaymentId(){

        int count = 0;

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("src/payments.txt")
                    );

            while(reader.readLine() != null){

                count++;
            }

            reader.close();

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return "P" + (count + 1);
    }

    // ================= CONSTRUCTOR =================

    public PaymentUI() {

        JFrame frame =
                new JFrame("Add Payment");

        frame.setSize(700,730);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel("Add Payment");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        title.setBounds(230,50,300,40);

        frame.add(title);

        // ================= CUSTOMER NAME =================

        JLabel customerLabel =
                new JLabel("Customer Name");

        customerLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        customerLabel.setBounds(90,150,180,30);

        frame.add(customerLabel);

        JTextField customerField =
                new JTextField();

        customerField.setBounds(300,145,280,40);

        frame.add(customerField);

        // ================= PAYMENT AMOUNT =================

        JLabel amountLabel =
                new JLabel("Amount");

        amountLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        amountLabel.setBounds(90,240,180,30);

        frame.add(amountLabel);

        JTextField amountField =
                new JTextField();

        amountField.setBounds(300,235,280,40);

        frame.add(amountField);

        // ================= PAYMENT METHOD =================

        JLabel methodLabel =
                new JLabel("Payment Method");

        methodLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        methodLabel.setBounds(90,330,180,30);

        frame.add(methodLabel);

        String[] methods = {

                "Card",
                "Online",
                "Cash"
        };

        JComboBox<String> methodBox =
                new JComboBox<>(methods);

        methodBox.setBounds(300,325,280,40);

        methodBox.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        frame.add(methodBox);

        // ================= PAYMENT DATE =================

        JLabel dateLabel =
                new JLabel("Payment Date");

        dateLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        dateLabel.setBounds(90,420,180,30);

        frame.add(dateLabel);

        JTextField dateField =
                new JTextField();

        dateField.setBounds(300,415,280,40);

        frame.add(dateField);

        // ================= ADD BUTTON =================

        JButton addBtn =
                new JButton("Add Payment");

        addBtn.setBounds(220,540,220,55);

        addBtn.setBackground(
                new Color(255,70,130)
        );

        addBtn.setForeground(Color.WHITE);

        addBtn.setFocusPainted(false);

        addBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        frame.add(addBtn);

        // ================= VIEW BUTTON =================

        JButton viewBtn =
                new JButton("View Payments");

        viewBtn.setBounds(220,620,220,45);

        viewBtn.setBackground(
                new Color(60,179,113)
        );

        viewBtn.setForeground(Color.WHITE);

        viewBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        frame.add(viewBtn);

        // ================= SAVE PAYMENT =================

        addBtn.addActionListener(e -> {

            String customer =
                    customerField.getText();

            String amount =
                    amountField.getText();

            String method =
                    methodBox.getSelectedItem().toString();

            String date =
                    dateField.getText();

            // ===== VALIDATION =====

            if(
                    customer.isEmpty()
                            ||
                            amount.isEmpty()
                            ||
                            date.isEmpty()
            ){

                JOptionPane.showMessageDialog(

                        null,

                        "Please Fill All Fields"
                );

                return;
            }

            try{

                FileWriter writer =
                        new FileWriter(
                                "src/payments.txt",
                                true
                        );

                writer.write(

                        "Payment ID: "
                                + generatePaymentId()

                                + " | Customer Name: "
                                + customer

                                + " | Amount: "
                                + amount

                                + " | Payment Method: "
                                + method

                                + " | Payment Date: "
                                + date

                                + "\n"
                );

                writer.close();

                JOptionPane.showMessageDialog(

                        null,

                        "Payment Added Successfully"
                );

                // ===== CLEAR FIELDS =====

                customerField.setText("");

                amountField.setText("");

                dateField.setText("");

            }catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(

                        null,

                        "Error Saving Payment"
                );
            }
        });

        // ================= OPEN VIEW UI =================

        viewBtn.addActionListener(e -> {

            new ViewPaymentsUI();
        });

        // ================= SHOW FRAME =================

        frame.setVisible(true);
    }
}