package model;

public class Customer extends User {

    public Customer(String userId,
                    String username,
                    String password,
                    String contact) {

        super(userId,
                username,
                password,
                contact,
                "Customer");
    }
}