package ui;

import dao.EventDAO;

import javax.swing.*;
import java.awt.*;

public class ManageEventUI {

    public ManageEventUI() {

        JFrame frame =
                new JFrame("Manage Events");

        frame.setSize(700,650);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ===== TITLE =====

        JLabel title =
                new JLabel("Admin Event Panel");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        title.setBounds(180,40,400,50);

        frame.add(title);

        // ===== ADD EVENT BUTTON =====

        JButton addButton =
                new JButton("Add Event");

        addButton.setBounds(220,150,220,50);

        addButton.setBackground(
                new Color(255,64,129)
        );

        addButton.setForeground(Color.WHITE);

        frame.add(addButton);

        // ===== VIEW EVENTS BUTTON =====

        JButton viewButton =
                new JButton("View Events");

        viewButton.setBounds(220,250,220,50);

        viewButton.setBackground(
                new Color(67,181,129)
        );

        viewButton.setForeground(Color.WHITE);

        frame.add(viewButton);

        // ===== DELETE EVENT BUTTON =====

        JButton deleteButton =
                new JButton("Delete Event");

        deleteButton.setBounds(220,350,220,50);

        deleteButton.setBackground(
                new Color(255,87,87)
        );

        deleteButton.setForeground(Color.WHITE);

        frame.add(deleteButton);

        // ===== EXIT BUTTON =====

        JButton exitButton =
                new JButton("Exit");

        exitButton.setBounds(220,450,220,50);

        exitButton.setBackground(Color.RED);

        exitButton.setForeground(Color.WHITE);

        frame.add(exitButton);

        // ===== BUTTON ACTIONS =====

        addButton.addActionListener(e -> {

            new EventUI();
        });

        viewButton.addActionListener(e -> {

            new ViewEventUI();
        });

        // ===== DELETE FUNCTION =====

        deleteButton.addActionListener(e -> {

            try {

                String input =
                        JOptionPane.showInputDialog(
                                "Enter Event ID to Delete"
                        );

                int eventId =
                        Integer.parseInt(input);

                EventDAO dao =
                        new EventDAO();

                dao.deleteEvent(eventId);

                JOptionPane.showMessageDialog(

                        null,

                        "Event Deleted Successfully!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(

                        null,

                        "Invalid Event ID"
                );
            }
        });

        // ===== EXIT =====

        exitButton.addActionListener(e -> {

            frame.dispose();
        });

        frame.setVisible(true);
    }
}