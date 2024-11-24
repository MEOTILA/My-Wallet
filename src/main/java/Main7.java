package main.java;

import main.java.model.Wallet;
import main.java.service.TransactionService;

import java.util.concurrent.*;

public class Main7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FUTURE

        Wallet wallet = new Wallet();
        wallet.setBalance(1000.0);

        TransactionService transactionService = new TransactionService();

        Callable<String> withdrawTask = () -> {
            transactionService.withdraw(wallet, 200);
            return "Withdraw done!";
        };


        Callable<String> chargeTask = () -> {
            transactionService.charge(wallet,100);
            return "Charge done!";
        };


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> withdrawFutureOne = executorService.submit(withdrawTask);
        Future<String> chargeFuture = executorService.submit(chargeTask);
        Future<String> withdrawFutureTwo = executorService.submit(withdrawTask);


        System.out.println(withdrawFutureOne.get());
        System.out.println(chargeFuture.get());
        System.out.println(withdrawFutureTwo.get());

        executorService.close();

        System.out.println("Wallet Balance: " + wallet.getBalance());
    }
}
