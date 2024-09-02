package View;

import Model.InputValidator;
import Model.NotANumberException;
import Model.SellOrder;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseView {
    private Scanner scanner;

    public PurchaseView(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public int selectCryptocurrency() {
        System.out.println("Select cryptocurrency to buy:");
        System.out.println("1. Bitcoin");
        System.out.println("2. Ethereum");

        String choiceInput = scanner.nextLine();
        int choice;

        try {
            InputValidator.validateNumberInput(choiceInput);
            choice = Integer.parseInt(choiceInput);
        } catch (NotANumberException e) {
            System.out.println("Invalid input. Please enter a number.");
            return selectCryptocurrency();
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

            if (amount.compareTo(BigDecimal.ONE) < 0 || amount.compareTo(new BigDecimal("100")) > 0) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                return getAmountInput(prompt);
            }

        } catch (NotANumberException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getAmountInput(prompt);
        }

        return amount;
    }

    public BigDecimal getMaxPriceInput(String prompt) {
        System.out.println(prompt);
        String maxPriceInput = scanner.nextLine();
        BigDecimal maxPrice;

        try {
            InputValidator.validateNumberInput(maxPriceInput);
            maxPrice = new BigDecimal(maxPriceInput);
        } catch (NotANumberException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getMaxPriceInput(prompt);
        }

        return maxPrice;
    }

    public void displayBuyOrderConfirmation(SellOrder sellOrder) {
        System.out.println("\nSearching for a Seller...........\n");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sellOrder.getSellerName() + " is offering " + sellOrder.getAmount() + " for " + sellOrder.getTotalPrice());
        System.out.println("Do you confirm the purchase?  (YES/NO): ");
    }

    public boolean confirmPurchase() {
        String yesNo = scanner.nextLine();
        return yesNo.equalsIgnoreCase("yes");
    }

    public void displayInsufficientFundsMessage() {
        System.out.println("Insufficient funds.");
    }

    public void displayBuyOrderSuccessMessageB(BigDecimal amount) {
        System.out.println("\nWe have deposited: " + amount  + " BITCOINS INTO YOUR WALLET, CHECK IT!!! ");
    }
    public void displayBuyOrderSuccessMessageE(BigDecimal amount) {
        System.out.println("\nWe have deposited: " + amount + " ETHEREUM INTO YOUR WALLET, CHECK IT!!! ");
    }
}