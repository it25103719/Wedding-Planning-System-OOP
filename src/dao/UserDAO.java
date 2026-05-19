package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {

    private final String FILE_NAME =
            "users.txt";

    // ADD USER
    public void addUser(User user) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME, true)
                    );

            bw.write(user.toString());

            bw.newLine();

            bw.close();

        } catch (IOException e) {

            System.out.println(
                    "Save Error"
            );
        }
    }

    // GET ALL USERS
    public ArrayList<User> getAllUsers() {

        ArrayList<User> users =
                new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(FILE_NAME)
                    );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                if(data.length < 5) {

                    continue;
                }

                User user =
                        new User(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4]
                        );

                users.add(user);
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Read Error"
            );
        }

        return users;
    }

    // DELETE USER
    public void deleteUser(String userId) {

        ArrayList<User> users =
                getAllUsers();

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    );

            for(User user : users) {

                if(!user.getUserId()
                        .equals(userId)) {

                    bw.write(user.toString());

                    bw.newLine();
                }
            }

            bw.close();

        } catch (IOException e) {

            System.out.println(
                    "Delete Error"
            );
        }
    }

    // LOGIN METHOD
    public User login(String username,
                      String password) {

        ArrayList<User> users =
                getAllUsers();

        for(User user : users) {

            if(user.getUsername()
                    .equals(username)

                    &&

                    user.getPassword()
                            .equals(password)) {

                return user;
            }
        }

        return null;
    }

    // UPDATE USER
    public void updateUser(String id,
                           String username,
                           String password,
                           String contact) {

        ArrayList<User> users =
                getAllUsers();

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    );

            for(User user : users) {

                if(user.getUserId()
                        .equals(id)) {

                    user =
                            new User(
                                    id,
                                    username,
                                    password,
                                    contact,
                                    user.getRole()
                            );
                }

                bw.write(user.toString());

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {

            System.out.println(
                    "Update Error"
            );
        }
    }
}