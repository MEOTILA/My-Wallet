package main.java;

import main.java.model.User;
import main.java.model.Wallet;
import main.java.service.AuthenticationService;
import main.java.service.TransactionService;
import main.java.service.UserService;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static UserService userService = new UserService();
    final static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {
        System.out.println("Welcome to WalletApp..\n\n");


        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Runnable withdrawTask = () -> transactionService.withdraw(wallet, 200);
        Runnable chargeTask = () -> transactionService.charge(wallet,100);


        Thread firstThread = new Thread(withdrawTask);
        Thread secondThread = new Thread(chargeTask);
        Thread thirdThread = new Thread(withdrawTask);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(withdrawTask);
        executor.submit(chargeTask);
        executor.submit(withdrawTask);


        executor.close();
//
//        try {
//            while (!executor.isTerminated()) {
//                // You can add additional logic here to wait for all tasks to finish
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        System.out.println("Wallet Balance: " + wallet.getBalance());
    }

















        /*while (true) {
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

    }*/
}

