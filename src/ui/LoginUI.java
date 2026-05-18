package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;

public class LoginUI {

    public void loginPage() {

        // USERNAME
        String username =
                JOptionPane.showInputDialog(
                        null,
                        "Enter Username"
                );

        // PASSWORD
        String password =
                JOptionPane.showInputDialog(
                        null,
                        "Enter Password"
                );

        // DAO OBJECT
        UserDAO dao =
                new UserDAO();

        // LOGIN
        User user =
                dao.login(username, password);

        // LOGIN SUCCESS
        if(user != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Login Success!"
            );

            // ADMIN
            if(user.getRole().equals("Admin")) {

                new AdminUserManagementUI(user);
            }

            // CUSTOMER
            else {

                new UserDashboardUI(user);
            }
        }

        // LOGIN FAILED
        else {

            JOptionPane.showMessageDialog(
                    null,
                    "Invalid Username or Password!"
            );
        }
    }
}