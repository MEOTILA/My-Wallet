package main.java;

import main.java.model.Wallet;
import main.java.service.TransactionService;
import main.java.service.UserService;

import java.util.Scanner;


public class Main3 {
    final static Scanner scanner = new Scanner(System.in);
    final static UserService userService = new UserService();
    final static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) throws InterruptedException {
        //SIMPLE THREAD JOIN

        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Runnable withdrawTask = () -> transactionService.withdraw(wallet, 200);
        Runnable chargeTask = () -> transactionService.charge(wallet,100);


        Thread firstThread = new Thread(withdrawTask);
        Thread secondThread = new Thread(chargeTask);
        Thread thirdThread = new Thread(withdrawTask);


        firstThread.start();
        firstThread.join();

        secondThread.start();
        secondThread.join();

        thirdThread.start();
        thirdThread.join();


        System.out.println("Wallet Balance: " + wallet.getBalance());
    }
}
