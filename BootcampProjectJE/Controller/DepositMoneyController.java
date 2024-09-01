package Controller;

import Model.Wallet;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositMoneyController {
    private static Scanner scanner = new Scanner(System.in);


    public DepositMoneyController(Scanner scanner) {
        this.scanner = scanner;

    }

    public void save() {
        System.out.println("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        BigDecimal amountDecimal = new BigDecimal(amount);
        Wallet.deposit(amountDecimal);

        System.out.println("Deposit successful! New balance: " + Wallet.getBalance());
    }

}
