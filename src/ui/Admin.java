package ui;

public class Admin {

    private String username;
    private String password;

    // CONSTRUCTOR

    public Admin(String username, String password) {

        this.username = username;
        this.password = password;
    }

    // LOGIN METHOD

    public boolean login(String inputUsername, String inputPassword) {

        return username.equals(inputUsername)
                && password.equals(inputPassword);
    }
}