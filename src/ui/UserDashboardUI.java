package ui;

import model.User;

import javax.swing.*;

public class UserDashboardUI {

    public UserDashboardUI(User user) {

        JFrame frame =
                new JFrame("User Dashboard");

        frame.setSize(400,300);

        JTextArea area =
                new JTextArea();

        area.setText(

                "USER PROFILE\n\n" +

                        "ID : " +
                        user.getUserId()

                        + "\n\nUsername : " +

                        user.getUsername()

                        + "\n\nContact : " +

                        user.getContact()

                        + "\n\nRole : " +

                        user.getRole()
        );

        frame.add(area);

        frame.setVisible(true);
    }
}