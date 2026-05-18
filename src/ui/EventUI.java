package ui;

import dao.EventDAO;

import model.CeremonyEvent;
import model.EngagementEvent;
import model.ReceptionEvent;
import model.WeddingEvent;

import javax.swing.*;
import java.awt.*;

public class EventUI {

    public EventUI() {

        JFrame frame =
                new JFrame("Event Management");

        frame.setSize(700,700);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ===== TITLE =====

        JLabel title =
                new JLabel("Add Event");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        40
                )
        );

        title.setBounds(240,50,300,50);

        frame.add(title);

        // ===== CUSTOMER NAME =====

        JLabel customerLabel =
                new JLabel("Customer Name");

        customerLabel.setBounds(80,170,150,30);

        frame.add(customerLabel);

        JTextField customerField =
                new JTextField();

        customerField.setBounds(250,170,300,40);

        frame.add(customerField);

        // ===== VENUE =====

        JLabel venueLabel =
                new JLabel("Venue");

        venueLabel.setBounds(80,260,150,30);

        frame.add(venueLabel);

        JTextField venueField =
                new JTextField();

        venueField.setBounds(250,260,300,40);

        frame.add(venueField);

        // ===== DATE =====

        JLabel dateLabel =
                new JLabel("Event Date");

        dateLabel.setBounds(80,350,150,30);

        frame.add(dateLabel);

        JTextField dateField =
                new JTextField();

        dateField.setBounds(250,350,300,40);

        frame.add(dateField);

        // ===== EVENT TYPE =====

        JLabel typeLabel =
                new JLabel("Event Type");

        typeLabel.setBounds(80,440,150,30);

        frame.add(typeLabel);

        String[] eventTypes = {

                "Engagement",
                "Reception",
                "Ceremony"
        };

        JComboBox<String> typeCombo =
                new JComboBox<>(eventTypes);

        typeCombo.setBounds(250,440,300,40);

        frame.add(typeCombo);

        // ===== ADD BUTTON =====

        JButton addButton =
                new JButton("Add Event");

        addButton.setBounds(230,540,220,50);

        addButton.setBackground(
                new Color(255,64,129)
        );

        addButton.setForeground(Color.WHITE);

        frame.add(addButton);

        // ===== VIEW BUTTON =====

        JButton viewButton =
                new JButton("View Events");

        viewButton.setBounds(230,610,220,50);

        viewButton.setBackground(
                new Color(67,181,129)
        );

        viewButton.setForeground(Color.WHITE);

        frame.add(viewButton);

        // ===== ADD EVENT ACTION =====

        addButton.addActionListener(e -> {

            try {

                String customerName =
                        customerField.getText();

                String venue =
                        venueField.getText();

                String date =
                        dateField.getText();

                String type =
                        typeCombo
                                .getSelectedItem()
                                .toString();

                WeddingEvent event;

                int eventId =
                        (int)(Math.random() * 1000);

                if(type.equals("Engagement")) {

                    event =
                            new EngagementEvent(

                                    eventId,
                                    customerName,
                                    venue,
                                    date
                            );

                } else if(type.equals("Reception")) {

                    event =
                            new ReceptionEvent(

                                    eventId,
                                    customerName,
                                    venue,
                                    date
                            );

                } else {

                    event =
                            new CeremonyEvent(

                                    eventId,
                                    customerName,
                                    venue,
                                    date
                            );
                }

                EventDAO dao =
                        new EventDAO();

                dao.addEvent(event);

                JOptionPane.showMessageDialog(

                        null,

                        "Event Added Successfully!"
                );

                customerField.setText("");

                venueField.setText("");

                dateField.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(

                        null,

                        "Error Adding Event"
                );
            }
        });

        // ===== VIEW EVENTS =====

        viewButton.addActionListener(e -> {

            new ViewEventUI();
        });

        frame.setVisible(true);
    }
}