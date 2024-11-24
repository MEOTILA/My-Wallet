package main.java.model;

import main.java.model.enumeration.TransactionType;

// Modeling
public class Transaction {
    private Wallet wallet;
    private double amount;
    private TransactionType type;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "wallet=" + wallet +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
