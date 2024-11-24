package main.java.service;

import main.java.database.Database;
import main.java.model.User;
import main.java.model.Wallet;

import java.util.List;

public class TransactionService {

    public void charge(Wallet wallet, double amount) {
        wallet
                .setBalance(wallet.getBalance() + amount);
    }

    public boolean withdraw(Wallet wallet, double amount) {

        if (amount > wallet.getBalance()) {
            System.out.println("Not enough credit!");
            return false;
        }

        wallet
                .setBalance(wallet.getBalance() - amount);
        System.out.println("Cashed out successfully!");
        return true;
    }
}
