package View;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositMoneyView {
    private Scanner scanner;

    public DepositMoneyView(Scanner scanner) {
        this.scanner = scanner;
    }

    public BigDecimal getAmountInput(String prompt) {
        System.out.println(prompt);
        double amount = scanner.nextDouble();
        return new BigDecimal(amount);
    }

    public void showSuccessMessage(String message) {
        System.out.println(message);
    }
}