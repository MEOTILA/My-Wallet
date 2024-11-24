package main.java;

import main.java.model.Wallet;
import main.java.service.TransactionService;
import main.java.service.UserService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    final static Scanner scanner = new Scanner(System.in);
    final static UserService userService = new UserService();
    final static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {
       //EXECUTOR SERVICE


        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Runnable withdrawTask = () -> transactionService.withdraw(wallet, 200);
        Runnable chargeTask = () -> transactionService.charge(wallet,100);


        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(withdrawTask);
        executor.submit(chargeTask);
        executor.submit(withdrawTask);

        executor.close();

        System.out.println("Wallet Balance: " + wallet.getBalance());
    }
}
