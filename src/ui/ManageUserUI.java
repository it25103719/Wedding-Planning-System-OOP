package ui;

import javax.swing.*;
import java.awt.*;

public class ManageUserUI {

    public ManageUserUI() {

        // FRAME
        JFrame frame =
                new JFrame("Manage Users");

        frame.setSize(1000,700);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // TITLE
        JLabel title =
                new JLabel("Update / Delete User");

        title.setBounds(280,40,500,60);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        40
                )
        );

        // USER ID
        JLabel idLabel =
                new JLabel("User ID");

        idLabel.setBounds(140,150,220,40);

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField idField =
                new JTextField();

        idField.setBounds(420,150,320,40);

        // USERNAME
        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setBounds(140,240,220,40);

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField usernameField =
                new JTextField();

        usernameField.setBounds(420,240,320,40);

        // PASSWORD
        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setBounds(140,330,220,40);

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField passwordField =
                new JTextField();

        passwordField.setBounds(420,330,320,40);

        // CONTACT
        JLabel contactLabel =
                new JLabel("Contact");

        contactLabel.setBounds(140,420,220,40);

        contactLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField contactField =
                new JTextField();

        contactField.setBounds(420,420,320,40);

        // UPDATE BUTTON
        JButton updateButton =
                new JButton("Update User");

        updateButton.setBounds(
                220,
                540,
                220,
                60
        );

        updateButton.setBackground(
                new Color(220,190,130)
        );

        updateButton.setForeground(
                Color.BLACK
        );

        updateButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        // DELETE BUTTON
        JButton deleteButton =
                new JButton("Delete User");

        deleteButton.setBounds(
                540,
                540,
                220,
                60
        );

        deleteButton.setBackground(
                new Color(240,80,80)
        );

        deleteButton.setForeground(
                Color.WHITE
        );

        deleteButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        // ADD COMPONENTS
        frame.add(title);

        frame.add(idLabel);
        frame.add(idField);

        frame.add(usernameLabel);
        frame.add(usernameField);

        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(contactLabel);
        frame.add(contactField);

        frame.add(updateButton);

        frame.add(deleteButton);

        // SHOW FRAME
        frame.setVisible(true);
    }
}