package main.java;

import main.java.model.Wallet;
import main.java.service.TransactionService;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main6 {
    public static void main(String[] args) throws InterruptedException {
        //CYCLE BARRIER

        CyclicBarrier barrier = new CyclicBarrier(3);

        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Runnable withdrawTask = () -> {
            transactionService.withdraw(wallet, 200);
            try {
                barrier.await();  // Wait for other thread to complete before proceeding
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable chargeTask = () -> {
            transactionService.charge(wallet,100);
            try {
                barrier.await();  // Wait for other thread to complete before proceeding
            } catch (Exception e) {
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
