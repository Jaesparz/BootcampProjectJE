package View;

import Model.BuyOrder;
import Model.InputValidator;
import Model.NotANumberException;

import java.math.BigDecimal;
import java.util.Scanner;

public class SalesView {
        private Scanner scanner;

        public SalesView(Scanner scanner) {
            this.scanner = new Scanner(System.in);
        }

        public int selectCryptocurrencyToSell() {
            System.out.println("Select cryptocurrency to sell:");
            System.out.println("1. Bitcoin");
            System.out.println("2. Ethereum");
            String choiceInput = scanner.nextLine();
            int choice;
            try {
                InputValidator.validateNumberInput(choiceInput);
                choice = Integer.parseInt(choiceInput);
            } catch (NotANumberException e) {
                System.out.println("Invalid input. Please enter a number.");
                return selectCryptocurrencyToSell();
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
                return getAmountInput(prompt);
            }
            return amount;
        }

        public BigDecimal getMinPriceInput(String prompt) {
            System.out.println(prompt);
            String minPriceInput = scanner.nextLine();
            BigDecimal minPrice;
            try {
                InputValidator.validateNumberInput(minPriceInput);
                minPrice = new BigDecimal(minPriceInput);
            } catch (NotANumberException e) {
                System.out.println("Invalid input. Please enter a number.");
                return getMinPriceInput(prompt);
            }
            return minPrice;
        }
        public void displayBuyOrderConfirmation(BuyOrder buyOrder) {
            System.out.println("\nSearching for a Buyer...........\n");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(buyOrder.getBuyerName() + " is wanting to buy " + buyOrder.getAmount() + " for " + buyOrder.getTotalPrice());
            System.out.println("Do you confirm the purchase?  (YES/NO): ");
        }

        public boolean confirmPurchase() {
            String yesNo = scanner.nextLine();
            return yesNo.equalsIgnoreCase("yes");
        }

        public void displayInsufficientFundsMessage() {
            System.out.println("Insufficient funds.");
        }
    public void displayBuyOrderSuccessMessage(BigDecimal amount) {
        System.out.println("\nWe have deposited: " + amount  + "$ INTO YOUR WALLET, CHECK IT!!! ");
    }
    }

