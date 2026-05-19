package model;

public class Admin extends User {

    public Admin(String userId,
                 String username,
                 String password,
                 String contact) {

        super(userId,
                username,
                password,
                contact,
                "Admin");
    }
}