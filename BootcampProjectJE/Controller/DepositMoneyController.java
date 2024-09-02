package Controller;

import Model.Wallet;
import View.DepositMoneyView;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositMoneyController {
    private Scanner scanner = new Scanner(System.in);

    public void save() {

        DepositMoneyView view =  new DepositMoneyView(scanner);
        BigDecimal amount = view.getAmountInput("Enter the amount to deposit: ");
        Wallet.deposit(amount);
        view.showSuccessMessage("Deposit successful! New balance: " + Wallet.getBalance());
    }

}
