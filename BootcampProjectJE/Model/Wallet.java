package Model;

import java.math.BigDecimal;

public class Wallet {
    private static BigDecimal balance;

    public Wallet() {
        this.balance = BigDecimal.ZERO;
    }

    public static BigDecimal getBalance() {
        return balance;
    }

    public static void setBalance(BigDecimal nuevoBalance) {
        balance = nuevoBalance;
    }

    public static void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public static void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}