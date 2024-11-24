package main.java.service;

import main.java.database.Database;
import main.java.model.User;
import main.java.model.Wallet;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionService {
    private final ReentrantLock lock = new ReentrantLock();

    public void charge(Wallet wallet, double amount) {
        lock.lock();
        try {
            wallet.setBalance(wallet.getBalance() + amount);
            System.out.println("Charged successfully!");
        }finally {
            lock.unlock();
        }
    }

    public  boolean withdraw(Wallet wallet, double amount) {
        lock.lock();
        try {
            if (amount > wallet.getBalance()) {
                System.out.println("Not enough credit!");
                return false;
            }

            wallet.setBalance(wallet.getBalance() - amount);
            System.out.println("Cashed out successfully!");
            return true;
        } finally {
            lock.unlock();
        }
    }

    /*public synchronized void charge(Wallet wallet, double amount) {
        wallet.setBalance(wallet.getBalance() + amount);
        System.out.println("Charged successfully!");
    }

    public synchronized  boolean withdraw(Wallet wallet, double amount) {

        if (amount > wallet.getBalance()) {
            System.out.println("Not enough credit!");
            return false;
        }

        wallet.setBalance(wallet.getBalance() - amount);
        System.out.println("Cashed out successfully!");
        return true;
    }*/
}
