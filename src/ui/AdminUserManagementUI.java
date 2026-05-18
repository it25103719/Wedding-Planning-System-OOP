package ui;

import dao.UserDAO;
import model.Admin;
import model.Customer;
import model.User;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class AdminUserManagementUI {

    private User loggedUser;

    public AdminUserManagementUI(User loggedUser) {

        this.loggedUser = loggedUser;

        JFrame frame =
                new JFrame("User Management");

        frame.setSize(900,650);

        frame.setLayout(null);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // TITLE
        JLabel title =
                new JLabel("USER MANAGEMENT");

        title.setBounds(240,30,500,50);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        38
                )
        );

        frame.add(title);

        // USER ID
        JLabel idLabel =
                new JLabel("User ID");

        idLabel.setBounds(120,120,150,30);

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField idField =
                new JTextField();

        idField.setBounds(350,120,350,40);

        // USERNAME
        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setBounds(120,190,150,30);

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField usernameField =
                new JTextField();

        usernameField.setBounds(350,190,350,40);

        // PASSWORD
        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setBounds(120,260,150,30);

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JPasswordField passwordField =
                new JPasswordField();

        passwordField.setBounds(350,260,350,40);

        // CONTACT
        JLabel contactLabel =
                new JLabel("Contact");

        contactLabel.setBounds(120,330,150,30);

        contactLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        JTextField contactField =
                new JTextField();

        contactField.setBounds(350,330,350,40);

        // ROLE
        JLabel roleLabel =
                new JLabel("Role");

        roleLabel.setBounds(120,400,150,30);

        roleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        String[] roles = {
                "Customer",
                "Admin"
        };

        JComboBox<String> roleBox =
                new JComboBox<>(roles);

        roleBox.setBounds(350,400,350,40);

        roleBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        // ADD BUTTON
        JButton addButton =
                new JButton("Add User");

        addButton.setBounds(100,520,170,50);

        addButton.setBackground(
                new Color(255,64,129)
        );

        addButton.setForeground(Color.WHITE);

        addButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        // VIEW BUTTON
        JButton viewButton =
                new JButton("View Users");

        viewButton.setBounds(350,520,170,50);

        viewButton.setBackground(
                new Color(46,204,113)
        );

        viewButton.setForeground(Color.WHITE);

        viewButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        // DELETE BUTTON
        JButton deleteButton =
                new JButton("Delete User");

        deleteButton.setBounds(600,520,170,50);

        deleteButton.setBackground(
                new Color(231,76,60)
        );

        deleteButton.setForeground(Color.WHITE);

        deleteButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        // ONLY ADMIN CAN MANAGE USERS
        if(!loggedUser.getRole()
                .equals("Admin")) {

            addButton.setEnabled(false);

            deleteButton.setEnabled(false);

            roleBox.setEnabled(false);
        }

        // ADD COMPONENTS
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
        frame.add(deleteButton);

        // ADD USER
        addButton.addActionListener(e -> {

            String id =
                    idField.getText();

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

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

        // DELETE USER
        deleteButton.addActionListener(e -> {

            String id =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter User ID"
                    );

            UserDAO dao =
                    new UserDAO();

            dao.deleteUser(id);

            JOptionPane.showMessageDialog(
                    frame,
                    "User Deleted Successfully!"
            );
        });

        frame.setVisible(true);
    }
}