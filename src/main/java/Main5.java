package main.java;

import main.java.model.Wallet;
import main.java.service.TransactionService;
import main.java.service.UserService;

import java.util.concurrent.CountDownLatch;

public class Main5 {
    final static UserService userService = new UserService();
    final static TransactionService transactionService = new TransactionService();
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Runnable withdrawTask = () -> {
            transactionService.withdraw(wallet, 200);
            latch.countDown();
        };

        Runnable chargeTask = () -> {
            try {
                latch.await();
                transactionService.charge(wallet, 100);
            }
            catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        };


        Thread withdrawThreadOne = new Thread(withdrawTask);
        Thread chargeThread = new Thread(chargeTask);
        Thread withdrawThreadTwo = new Thread(withdrawTask);

        withdrawThreadOne.start();
        chargeThread.start();
        withdrawThreadTwo.start();

        withdrawThreadOne.join();
        chargeThread.join();
        withdrawThreadTwo.join();

        System.out.println("Wallet Balance: " + wallet.getBalance());
    }
}
