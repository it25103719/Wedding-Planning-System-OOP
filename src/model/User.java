package model;

public class User {

    private String userId;
    private String username;
    private String password;
    private String contact;
    private String role;

    public User(String userId,
                String username,
                String password,
                String contact,
                String role) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {

        return userId + "," +
                username + "," +
                password + "," +
                contact + "," +
                role;
    }
}