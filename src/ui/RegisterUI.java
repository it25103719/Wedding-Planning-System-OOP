package ui;

import dao.UserDAO;
import model.Admin;
import model.Customer;
import model.User;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class RegisterUI {

    public RegisterUI() {

        // FRAME
        JFrame frame =
                new JFrame("User Registration");

        frame.setSize(1000,700);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // TITLE
        JLabel title =
                new JLabel("USER MANAGEMENT");

        title.setBounds(250,40,500,60);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        42
                )
        );

        // USER ID
        JLabel idLabel =
                new JLabel("User ID");

        idLabel.setBounds(120,150,180,40);

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JTextField idField =
                new JTextField();

        idField.setBounds(420,150,350,45);

        // USERNAME
        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setBounds(120,240,180,40);

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JTextField usernameField =
                new JTextField();

        usernameField.setBounds(420,240,350,45);

        // PASSWORD
        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setBounds(120,330,180,40);

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JTextField passwordField =
                new JTextField();

        passwordField.setBounds(420,330,350,45);

        // CONTACT
        JLabel contactLabel =
                new JLabel("Contact");

        contactLabel.setBounds(120,420,180,40);

        contactLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        JTextField contactField =
                new JTextField();

        contactField.setBounds(420,420,350,45);

        // ROLE
        JLabel roleLabel =
                new JLabel("Role");

        roleLabel.setBounds(120,510,180,40);

        roleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        String[] roles = {
                "Customer",
                "Admin"
        };

        JComboBox<String> roleBox =
                new JComboBox<>(roles);

        roleBox.setBounds(420,510,350,45);

        roleBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        20
                )
        );

        // ADD BUTTON
        JButton addButton =
                new JButton("Add User");

        addButton.setBounds(
                180,
                600,
                220,
                60
        );

        addButton.setBackground(
                new Color(255,64,129)
        );

        addButton.setForeground(
                Color.WHITE
        );

        addButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        // VIEW BUTTON
        JButton viewButton =
                new JButton("View Users");

        viewButton.setBounds(
                520,
                600,
                220,
                60
        );

        viewButton.setBackground(
                new Color(46,204,113)
        );

        viewButton.setForeground(
                Color.WHITE
        );

        viewButton.setFont(
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

        frame.add(roleLabel);
        frame.add(roleBox);

        frame.add(addButton);

        frame.add(viewButton);

        // ADD USER
        addButton.addActionListener(e -> {

            String id =
                    idField.getText();

            String username =
                    usernameField.getText();

            String password =
                    passwordField.getText();

            String contact =
                    contactField.getText();

            String role =
                    roleBox.getSelectedItem()
                            .toString();

            User user;

            if(role.equals("Admin")) {

                user =
                        new Admin(
                                id,
                                username,
                                password,
                                contact
                        );
            }

            else {

                user =
                        new Customer(
                                id,
                                username,
                                password,
                                contact
                        );
            }

            UserDAO dao =
                    new UserDAO();

            dao.addUser(user);

            JOptionPane.showMessageDialog(
                    frame,
                    "User Added Successfully!"
            );

            // CLEAR FIELDS
            idField.setText("");

            usernameField.setText("");

            passwordField.setText("");

            contactField.setText("");
        });

        // VIEW USERS
        viewButton.addActionListener(e -> {

            UserDAO dao =
                    new UserDAO();

            ArrayList<User> users =
                    dao.getAllUsers();

            String[] columns = {
                    "User ID",
                    "Username",
                    "Contact",
                    "Role"
            };

            String[][] data =
                    new String[users.size()][4];

            for(int i = 0; i < users.size(); i++) {

                User user =
                        users.get(i);

                data[i][0] =
                        user.getUserId();

                data[i][1] =
                        user.getUsername();

                data[i][2] =
                        user.getContact();

                data[i][3] =
                        user.getRole();
            }

            JTable table =
                    new JTable(data, columns);

            table.setRowHeight(35);

            table.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            16
                    )
            );

            JTableHeader header =
                    table.getTableHeader();

            header.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            18
                    )
            );

            JScrollPane pane =
                    new JScrollPane(table);

            pane.setPreferredSize(
                    new Dimension(650,300)
            );

            JOptionPane.showMessageDialog(
                    frame,
                    pane,
                    "All Users",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // SHOW FRAME
        frame.setVisible(true);
    }
}