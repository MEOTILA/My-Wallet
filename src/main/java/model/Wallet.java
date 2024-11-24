package main.java.model;

public class Wallet {
    //Unique
    private double balance = 0.0;
    private String walletAddress;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
