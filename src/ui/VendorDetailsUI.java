package ui;

import javax.swing.*;
import java.awt.*;

public class VendorDetailsUI extends JFrame {

    public VendorDetailsUI(String id,
                           String name,
                           String service,
                           String contact) {

        setTitle("Vendor Details");

        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(5, 1, 10, 10));

        getContentPane().setBackground(new Color(245, 245, 245));

        JLabel title = new JLabel("Vendor Details", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel lblId = new JLabel("Vendor ID : " + id);
        JLabel lblName = new JLabel("Vendor Name : " + name);
        JLabel lblService = new JLabel("Service : " + service);
        JLabel lblContact = new JLabel("Contact : " + contact);

        Font font = new Font("Segoe UI", Font.PLAIN, 18);

        lblId.setFont(font);
        lblName.setFont(font);
        lblService.setFont(font);
        lblContact.setFont(font);

        add(title);
        add(lblId);
        add(lblName);
        add(lblService);
        add(lblContact);

        setVisible(true);
    }
}