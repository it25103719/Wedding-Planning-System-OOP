package ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class BookingForm {
    // ================= AUTO BOOKING ID =================

    private String generateBookingId(){

        int count = 0;

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("src/bookings.txt")
                    );

            while(reader.readLine() != null){

                count++;
            }

            reader.close();

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return "B" + (count + 1);
    }

    // ================= CONSTRUCTOR =================

    public BookingForm() {

        JFrame frame =
                new JFrame("Add Booking");

        frame.setSize(700,750);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel("Add Booking");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        title.setBounds(230,60,300,40);

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

        customerLabel.setBounds(90,170,180,30);

        frame.add(customerLabel);

        JTextField customerField =
                new JTextField();

        customerField.setBounds(300,165,280,40);

        frame.add(customerField);

        // ================= EVENT NAME =================

        JLabel eventLabel =
                new JLabel("Event Name");

        eventLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        eventLabel.setBounds(90,270,180,30);

        frame.add(eventLabel);

        JTextField eventField =
                new JTextField();

        eventField.setBounds(300,265,280,40);

        frame.add(eventField);

        // ================= VENDOR NAME =================

        JLabel vendorLabel =
                new JLabel("Vendor Name");

        vendorLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        vendorLabel.setBounds(90,370,180,30);

        frame.add(vendorLabel);

        JTextField vendorField =
                new JTextField();

        vendorField.setBounds(300,365,280,40);

        frame.add(vendorField);

        // ================= BOOKING DATE =================

        JLabel dateLabel =
                new JLabel("Booking Date");

        dateLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        dateLabel.setBounds(90,470,180,30);

        frame.add(dateLabel);

        JTextField dateField =
                new JTextField();

        dateField.setBounds(300,465,280,40);

        frame.add(dateField);

        // ================= BUTTON =================

        JButton addBtn =
                new JButton("Add Booking");

        addBtn.setBounds(220,600,220,55);

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

        // ================= SAVE BOOKING =================

        addBtn.addActionListener(e -> {

            String customer =
                    customerField.getText();

            String event =
                    eventField.getText();

            String vendor =
                    vendorField.getText();

            String date =
                    dateField.getText();

            // ===== VALIDATION =====

            if(
                    customer.isEmpty()
                            ||
                            event.isEmpty()
                            ||
                            vendor.isEmpty()
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
                                "src/bookings.txt",
                                true
                        );

                writer.write(

                        "Booking ID: "
                                + generateBookingId()

                                + " | Customer Name: "
                                + customer

                                + " | Event Name: "
                                + event

                                + " | Vendor Name: "
                                + vendor

                                + " | Booking Date: "
                                + date

                                + "\n"
                );

                writer.close();

                JOptionPane.showMessageDialog(

                        null,

                        "Booking Added Successfully"
                );

                // ===== CLEAR FIELDS =====

                customerField.setText("");

                eventField.setText("");

                vendorField.setText("");

                dateField.setText("");

            }catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(

                        null,

                        "Error Saving Booking"
                );
            }
        });

        // ================= SHOW FRAME =================

        frame.setVisible(true);
    }
}

