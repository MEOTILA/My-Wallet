package main.java.service;

import main.java.database.Database;
import main.java.model.User;

public class UserService {

    public void userSignup(String firstName,
                           String lastName,
                           String username,
                           String password) {

        // Create user
        User signingUser = new User();
        signingUser.setFirstName(firstName);
        signingUser.setLastName(lastName);
        signingUser.setUsername(username);
        signingUser.setPassword(password);

        // Save to database
        Database.userList.add(signingUser);
    }


    public void userLogin(String username,
                          String password) {

        // Find the user from database:
        for (User checkingUser: Database.userList) {

            // First find user with username
            if (checkingUser.getUsername().equals(username)) {

                // Check password
                if (checkingUser.getPassword().equals(password)) {

                    // Set the logged User
                    AuthenticationService.setLoggedUser(checkingUser);

                    System.out.println("User logged in successfully..");
                    return;
                }
            }
        }
        System.out.println("Username or password is wrong!");
    }


}
