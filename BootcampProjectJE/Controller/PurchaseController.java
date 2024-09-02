package Controller;

import Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseController {
    private Scanner scanner = new Scanner(System.in);


    public PurchaseController(Scanner scanner) {

    }

    public void placeBuyOrder() {
        System.out.println("Place Buy Order");
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
            return;
        }

        switch (choice) {
            case 1:
                System.out.println("Enter amount of Bitcoin to buy:");
                String amountInput = scanner.nextLine();
                BigDecimal amount;

                try {
                    InputValidator.validateNumberInput(amountInput);
                    amount = new BigDecimal(amountInput);

                    if (amount.compareTo(BigDecimal.ONE) < 0 || amount.compareTo(new BigDecimal("100")) > 0) {
                        System.out.println("Invalid input. Please enter a number between 1 and 100.");
                        return;
                    }

                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }

                System.out.println("Enter maximum price to pay per Bitcoin:");
                String maxPriceInput = scanner.nextLine();
                BigDecimal maxPrice;

                try {
                    InputValidator.validateNumberInput(maxPriceInput);
                    maxPrice = new BigDecimal(maxPriceInput);
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToBitcoin = Wallet.getBalance().divide(Bitcoin.getBitcoinPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisBitcoinPriceinUsd = Bitcoin.getBitcoinPrice().multiply(amount);
                ArrayList<SellOrder> sellOrders = OrderBook.getSellOrdersBitcoin();

                if (Wallet.getBalance().compareTo(thisBitcoinPriceinUsd) >= 0) {
                    for (SellOrder sellOrder : sellOrders) {

                        if (sellOrder.getAmount().equals(amount) && thisBitcoinPriceinUsd.compareTo(maxPrice) <= 0) {


                            System.out.println("\nSearching for a Seller...........\n");
                            try{
                                Thread.sleep(5000);
                            }catch(Exception e){
                                e.printStackTrace();
                            }

                            System.out.println(sellOrder.getSellerName() + " is offering " + sellOrder.getAmount() + " for " + sellOrder.getTotalPrice());
                            System.out.println("Do you confirm the purchase?  (YES/NO): ");
                            String yesNo = scanner.nextLine();
                            if (yesNo.equalsIgnoreCase("yes")) {
                                System.out.println("Buy order executed successfully!");

                                Wallet.withdraw(thisBitcoinPriceinUsd);
                                Bitcoin.deposit(amount);
                                System.out.println("\nSubstracting " + thisBitcoinPriceinUsd + " From the Wallet\n");

                                System.out.println("\nWe have deposited: " + amount + " BITCOINS INTO YOUR WALLET, CHECK IT!!! ");

                                HistoryController.setComprasHechas(sellOrder);
                                sellOrders.remove(sellOrder);

                                break;

                            } else {
                                System.out.println("Returning to loggin......");
                                System.out.println("..........");
                                System.out.println("..........");
                                return;

                            }

                        }

                    }
                } else {
                    System.out.println("Insufficient funds.");
                }
                break;


            case 2:
                System.out.println("Enter amount of Ethereum to buy:");
                String amountInputE = scanner.nextLine();
                BigDecimal amountE;

                try {
                    InputValidator.validateNumberInput(amountInputE);
                    amountE = new BigDecimal(amountInputE);

                    if (amountE.compareTo(BigDecimal.ONE) < 0 || amountE.compareTo(new BigDecimal("100")) > 0) {
                        System.out.println("Invalid input. Please enter a number between 1 and 100.");
                        return;
                    }

                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }

                System.out.println("Enter maximum price to pay per Ethereum:");
                String maxPriceInputE = scanner.nextLine();
                BigDecimal maxPriceE;

                try {
                    InputValidator.validateNumberInput(maxPriceInputE);
                    maxPrice = new BigDecimal(maxPriceInputE);
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToEthereum = Wallet.getBalance().divide(Ethereum.getEthereumPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisEthereumPriceinUsd = Ethereum.getEthereumPrice().multiply(amountE);
                ArrayList<SellOrder> sellOrdersE = OrderBook.getSellOrdersEthereum();

                if (Wallet.getBalance().compareTo(thisEthereumPriceinUsd) >= 0) {
                    for (SellOrder sellOrder : sellOrdersE) {

                        if (sellOrder.getAmount().equals(amountE) && thisEthereumPriceinUsd.compareTo(maxPrice) <= 0) {

                            System.out.println("\nSearching for a Seller...........\n");
                            try{
                                Thread.sleep(5000);
                            }catch(Exception e){
                                e.printStackTrace();
                            }

                            System.out.println(sellOrder.getSellerName() + " is offering " + sellOrder.getAmount() + " for " + sellOrder.getTotalPrice());
                            System.out.println("Do you confirm the purchase?  (YES/NO): ");
                            String yesNo = scanner.nextLine();
                            if (yesNo.equalsIgnoreCase("yes")) {
                                System.out.println("Buy order executed successfully!");

                                Wallet.withdraw(thisEthereumPriceinUsd);
                                Ethereum.deposit(amountE);
                                System.out.println("\nSubstracting " + thisEthereumPriceinUsd + " From the Wallet\n");

                                System.out.println("\nWe have deposited: " + amountE + " ETHEREUM INTO YOUR WALLET, CHECK IT!!! ");
                                HistoryController.setComprasHechas(sellOrder);
                                sellOrdersE.remove(sellOrder);


                                break;

                            } else {
                                System.out.println("Returning to loggin......");
                                System.out.println("..........");
                                System.out.println("..........");
                                return;

                            }
                        }
                    }
                } else {
                    System.out.println("Insufficient funds.");
                }
                break;


        }
    }
}






