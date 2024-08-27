package Controller;

import Model.Wallet;

import java.util.Scanner;

public class DepositMoneyController  {
    private Scanner scanner;
    private Wallet wallet;

    public DepositMoneyController(Scanner scanner) {
        this.scanner = scanner;
        this.wallet = new Wallet();
    }

    public void save() {
        System.out.println("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        wallet.deposit(amount);
        System.out.println("Deposit successful! New balance: " + wallet.getBalance());
    }
}
