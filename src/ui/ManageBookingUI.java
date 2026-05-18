package ui;

import dao.BookingDAO;

import javax.swing.*;
import java.awt.*;

public class ManageBookingUI {

    public ManageBookingUI() {

        // ADMIN LOGIN

        Admin admin =
                new Admin(
                        "admin",
                        "1234"
                );

        String username =
                JOptionPane.showInputDialog(
                        null,
                        "Enter Admin Username"
                );

        String password =
                JOptionPane.showInputDialog(
                        null,
                        "Enter Admin Password"
                );

        if (!admin.login(username, password)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Access Denied!"
            );

            return;
        }

        // DAO OBJECT

        BookingDAO dao =
                new BookingDAO();

        // FRAME

        JFrame frame =
                new JFrame("Manage Bookings");

        frame.setSize(500, 500);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        // TITLE

        JLabel title =
                new JLabel(
                        "Update / Delete Booking"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        title.setBounds(
                90,
                20,
                350,
                40
        );

        frame.add(title);

        // BOOKING ID

        JLabel idLabel =
                new JLabel("Booking ID");

        idLabel.setBounds(
                50,
                90,
                120,
                30
        );

        frame.add(idLabel);

        JTextField idField =
                new JTextField();

        idField.setBounds(
                180,
                90,
                220,
                30
        );

        frame.add(idField);

        // NEW VENDOR

        JLabel vendorLabel =
                new JLabel("New Vendor");

        vendorLabel.setBounds(
                50,
                150,
                120,
                30
        );

        frame.add(vendorLabel);

        JTextField vendorField =
                new JTextField();

        vendorField.setBounds(
                180,
                150,
                220,
                30
        );

        frame.add(vendorField);

        // NEW DATE

        JLabel dateLabel =
                new JLabel("New Date");

        dateLabel.setBounds(
                50,
                210,
                120,
                30
        );

        frame.add(dateLabel);

        JTextField dateField =
                new JTextField();

        dateField.setBounds(
                180,
                210,
                220,
                30
        );

        frame.add(dateField);

        // UPDATE BUTTON

        JButton updateBtn =
                new JButton("Update Booking");

        updateBtn.setBounds(
                60,
                320,
                150,
                45
        );

        frame.add(updateBtn);

        // DELETE BUTTON

        JButton deleteBtn =
                new JButton("Delete Booking");

        deleteBtn.setBounds(
                250,
                320,
                150,
                45
        );

        frame.add(deleteBtn);

        // UPDATE ACTION

        updateBtn.addActionListener(e -> {

            try {

                String bookingId =
                        idField.getText();

                String newVendor =
                        vendorField.getText();

                String newDate =
                        dateField.getText();

                dao.updateBooking(
                        bookingId,
                        newVendor,
                        newDate
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Booking Updated Successfully"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Input"
                );
            }
        });

        // DELETE ACTION

        deleteBtn.addActionListener(e -> {

            try {

                String bookingId =
                        idField.getText();

                dao.deleteBooking(
                        bookingId
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Booking Deleted Successfully"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Booking ID"
                );
            }
        });

        frame.setVisible(true);
    }
}