import ui.AddVendorForm;
import ui.ManageVendorUI;
import ui.ViewVendorsUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI extends JFrame {

    public AdminUI() {

        // FRAME SETTINGS
        setTitle("Admin Panel - Vendor Management");

        setSize(450, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        // TITLE
        JLabel title = new JLabel("ADMIN DASHBOARD");

        title.setBounds(140, 20, 200, 30);

        add(title);

        // ADD BUTTON
        JButton addBtn = new JButton("Add Vendor");

        addBtn.setBounds(100, 80, 220, 40);

        add(addBtn);

        // VIEW BUTTON
        JButton viewBtn = new JButton("View Vendors");

        viewBtn.setBounds(100, 140, 220, 40);

        add(viewBtn);

        // MANAGE BUTTON
        JButton manageBtn = new JButton("Manage Vendors");

        manageBtn.setBounds(100, 200, 220, 40);

        add(manageBtn);

        // EXIT BUTTON
        JButton exitBtn = new JButton("Exit");

        exitBtn.setBounds(100, 260, 220, 40);

        add(exitBtn);

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

        // MANAGE VENDORS
        manageBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ManageVendorUI().setVisible(true);
            }
        });

        // EXIT
        exitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new AdminUI();
    }
}