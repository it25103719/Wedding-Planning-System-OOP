import ui.BookingForm;
import ui.ViewBookingsUI;
import ui.ManageBookingUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Booking Management System");

        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Booking Management System");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setBounds(100, 50, 450, 40);
        frame.add(title);

        JButton addBtn = new JButton("Add Booking");
        addBtn.setBounds(180, 140, 220, 50);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View Bookings");
        viewBtn.setBounds(180, 220, 220, 50);
        frame.add(viewBtn);

        JButton manageBtn = new JButton("Update / Delete Booking");
        manageBtn.setBounds(180, 300, 220, 50);
        frame.add(manageBtn);

        addBtn.addActionListener(e -> new BookingForm());

        viewBtn.addActionListener(e -> new ViewBookingsUI());

        manageBtn.addActionListener(e -> new ManageBookingUI());

        frame.setVisible(true);
    }
}