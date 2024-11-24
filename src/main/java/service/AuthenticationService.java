package main.java.service;

import main.java.model.User;

public class AuthenticationService {
    private static User loggedInUser;

    public static void setLoggedUser(User user) {
        loggedInUser = user;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }
}
