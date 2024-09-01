package Controller;

import Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesController {
    private Scanner scanner = new Scanner(System.in);


    public SalesController(Scanner scanner) {

    }

    public void placeSellOrder() {
        System.out.println("Place Sell Order");
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
            return;
        }

        switch (choice) {
            case 1:
                System.out.println("Enter amount of Bitcoin to sell:");
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

                System.out.println("Enter the mininum price to sell Bitcoin:");
                String minPriceInput = scanner.nextLine();
                BigDecimal minPrice;

                try {
                    InputValidator.validateNumberInput(minPriceInput);
                    minPrice = new BigDecimal(minPriceInput);
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToBitcoin = Wallet.getBalance().divide(Bitcoin.getBitcoinPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisBitcoinPriceinUsd = Bitcoin.getBitcoinPrice().multiply(amount);
                ArrayList<BuyOrder> buyOrders = OrderBook.getBuyOrdersBitcoin();

                if (Bitcoin.getBitcoinBalance().compareTo(amount) >= 0) {
                    for (BuyOrder buyorder : buyOrders) {

                        if (buyorder.getAmount().equals(amount) && (thisBitcoinPriceinUsd.compareTo(minPrice) >= 0)) {

                            System.out.println("\nSearching for a Buyer...........\n");
                            try{
                                Thread.sleep(5000);
                            }catch(Exception e){
                                e.printStackTrace();
                            }

                            System.out.println(buyorder.getBuyerName() + " is wanting to buy " + buyorder.getAmount() + " for " + buyorder.getTotalPrice());
                            System.out.println("Do you confirm the purchase?  (YES/NO): ");
                            String yesNo = scanner.nextLine();
                            if (yesNo.equalsIgnoreCase("yes")) {
                                System.out.println("Buy order executed successfully!");

                                Wallet.deposit(thisBitcoinPriceinUsd);
                                Bitcoin.withdraw(amount);
                                System.out.println("\nAdding " + thisBitcoinPriceinUsd + " to  Wallet\n");

                                System.out.println("\nWe have removed: " + amount + " bitcoins from your wallet\n");
                                System.out.println("\nWe have added " + thisBitcoinPriceinUsd + " to  Wallet, CHECK IT!!!!\n");


                                HistoryController.setVentasHechas(buyorder);
                                buyOrders.remove(buyorder);

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
                System.out.println("Enter amount of Ethereum to sell:");
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

                System.out.println("Enter the mininum price to sell Ethereum:");
                String minPriceInputE = scanner.nextLine();
                BigDecimal minPriceE;

                try {
                    InputValidator.validateNumberInput(minPriceInputE);
                    minPriceE = new BigDecimal(minPriceInputE);
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToEthereum = Wallet.getBalance().divide(Ethereum.getEthereumPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisEthereumPriceinUsd = Ethereum.getEthereumPrice().multiply(amountE);
                ArrayList<BuyOrder> buyOrdersE = OrderBook.getBuyOrdersEthereum();

                if (Bitcoin.getBitcoinBalance().compareTo(amountE) >= 0) {
                    for (BuyOrder buyOrder : buyOrdersE) {

                        if (buyOrder.getAmount().equals(amountE) && thisEthereumPriceinUsd.compareTo(minPriceE) >= 0) {

                            System.out.println("\nSearching for a Buyer...........\n");
                            try{
                                Thread.sleep(5000);
                            }catch(Exception e){
                                e.printStackTrace();
                            }

                            System.out.println(buyOrder.getBuyerName() + " is offering " + buyOrder.getAmount() + " for " + buyOrder.getTotalPrice());
                            System.out.println("Do you confirm the purchase?  (YES/NO): ");
                            String yesNo = scanner.nextLine();
                            if (yesNo.equalsIgnoreCase("yes")) {
                                System.out.println("Buy order executed successfully!");

                                Wallet.deposit(thisEthereumPriceinUsd);
                                Bitcoin.withdraw(amountE);

                                System.out.println("\nAdding " + thisEthereumPriceinUsd + " to  Wallet\n");

                                System.out.println("\nWe have removed: " + amountE + " bitcoins from your wallet\n");
                                System.out.println("\nWe have added " + thisEthereumPriceinUsd + " to  Wallet, CHECK IT!!!!\n");
                                HistoryController.setVentasHechas(buyOrder);
                                buyOrdersE.remove(buyOrder);


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


