package main.java.model;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Wallet {
    //Unique
    private double balance = 0.0;
    private String walletAddress;
    private final ReentrantReadWriteLock  lock = new ReentrantReadWriteLock();


    /*public double getBalance() {
        return balance;
    }*/
    public double getBalance() {
        lock.readLock().lock();
        try {
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    /*public void setBalance(double balance) {
        this.balance = balance;
    }*/
    public void setBalance(double balance) {
        lock.writeLock().lock();
        try {
            this.balance = balance;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "balance=" + balance +
                ", walletAddress='" + walletAddress + '\'' +
                '}';
    }
}
