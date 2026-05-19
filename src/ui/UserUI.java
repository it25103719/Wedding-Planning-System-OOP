package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserUI extends JFrame {

    public UserUI() {

        setTitle("User Panel");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        JLabel title = new JLabel("USER DASHBOARD");

        title.setBounds(120, 20, 200, 30);

        add(title);

        // ADD BUTTON
        JButton addBtn = new JButton("Add Vendor");

        addBtn.setBounds(100, 90, 180, 40);

        add(addBtn);

        // VIEW BUTTON
        JButton viewBtn = new JButton("View Vendors");

        viewBtn.setBounds(100, 160, 180, 40);

        add(viewBtn);

        // =========================
        // BUTTON ACTIONS
        // =========================

        // ADD VENDOR
        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new AddVendorForm().setVisible(true);
            }
        });

        // VIEW VENDORS
        viewBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ViewVendorsUI().setVisible(true);
            }
        });

        setVisible(true);
    }
}