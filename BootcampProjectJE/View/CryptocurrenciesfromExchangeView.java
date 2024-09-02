package View;

import Model.Exchanger;
import Model.InputValidator;
import Model.NotANumberException;

import java.math.BigDecimal;
import java.util.Scanner;

public class CryptocurrenciesfromExchangeView {
    private Scanner scanner;

    public CryptocurrenciesfromExchangeView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showCryptocurrenciesAvailable() {
        System.out.println("\n" + Exchanger.getBitcoinExchangerBalance() + " BITCOIN AVAILABLE!!!!");
        System.out.println(Exchanger.getEthereumExchangerBalance() + " ETHEREUM AVAILABLE!!!\n");
    }

    public int showCryptocurrenciesMenu() {
        System.out.println("CryptoCurrencies From Exchange");
        System.out.println("Select cryptocurrency to buy:");
        System.out.println("1. Bitcoin");
        System.out.println("2. Ethereum");
        System.out.println("3. Return");

        String choiceInput = scanner.nextLine();
        int choice;

        try {
            InputValidator.validateNumberInput(choiceInput);
            choice = Integer.parseInt(choiceInput);
        } catch (NotANumberException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }

        return choice;
    }

    public BigDecimal getAmountInput(String prompt) {
        System.out.println(prompt);
        String amountInput = scanner.nextLine();
        BigDecimal amount;

        try {
            InputValidator.validateNumberInput(amountInput);
            amount = new BigDecimal(amountInput);
        } catch (NotANumberException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }

        return amount;
    }

    public void showDepositMessage(String cryptocurrency, BigDecimal amount) {
        System.out.println("\nWe have deposited: " + amount + " " + cryptocurrency + " INTO YOUR WALLET, CHECK IT!!! ");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    public void showReturnMessage() {
        System.out.println("Returning.....");
    }

    public void showSubstractionMessage(BigDecimal USD) {
        System.out.println("\nSubstracting " + USD + " From the Wallet\n");
    }
}