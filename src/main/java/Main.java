package main.java;

import main.java.model.User;
import main.java.model.Wallet;
import main.java.service.AuthenticationService;
import main.java.service.TransactionService;
import main.java.service.UserService;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static UserService userService = new UserService();
    final static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {
        System.out.println("Welcome to WalletApp..\n\n");
        Wallet wallet1 = new Wallet();
        wallet1.setBalance(1000);
        wallet1.setWalletAddress("1");


        while (true) {
            System.out.println("1.Signup");
            System.out.println("2.login");
            int userInput = scanner.nextInt();

            userLoginMenu(userInput);


        }
    }


    public static void userLoginMenu(int option) {

        switch (option) {

            case 1:
                System.out.println("Enter firstname:");
                String firstname = scanner.next();
                System.out.println("Enter lastname:");
                String lastname = scanner.next();
                System.out.println("Enter username:");
                String username = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();

            case 2:
        }
    }


    public static void loginMenu() {
        // login related logic...
    }

    public static void chargeBalanceMenu() {
        User currentLoggedInUser = AuthenticationService.getLoggedInUser();

        // print menu and get the wallet Address from the user:

        // TODO: Logic regarding checking user is the owner of the wallet!!!

    }
}
