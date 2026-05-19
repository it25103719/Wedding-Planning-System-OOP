package ui;

import dao.UserDAO;
import model.User;

public class ViewUsersUI {

    public void viewAllUsers() {

        UserDAO dao = new UserDAO();

        for (User user : dao.getAllUsers()) {

            System.out.println("---------------");

            System.out.println("ID: " +
                    user.getUserId());

            System.out.println("Username: " +
                    user.getUsername());

            System.out.println("Contact: " +
                    user.getContact());
        }
    }
}