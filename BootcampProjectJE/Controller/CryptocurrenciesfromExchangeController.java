package Controller;

import Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CryptocurrenciesfromExchangeController {
    private Scanner scanner;


    public CryptocurrenciesfromExchangeController(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void BuyCryptocurrenciesFromExchange() {
        System.out.println("\n"+Bitcoin.getBitcoinExchangerBalance()+" BITCOIN AVAILABLE!!!!");
        System.out.println(Ethereum.getEthereumExchangerBalance() +" ETHEREUM AVAILABLE!!!\n");

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
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToBitcoin = Wallet.getBalance().divide(Bitcoin.getBitcoinPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisBitcoinPriceinUsd = Bitcoin.getBitcoinPrice().multiply(amount);

                if (Wallet.getBalance().compareTo(thisBitcoinPriceinUsd) >= 0) {

                    Wallet.withdraw(thisBitcoinPriceinUsd);
                    Bitcoin.deposit(amount);
                    Bitcoin.withdrawExchanger(amount);
                    System.out.println("\nSubstracting " + thisBitcoinPriceinUsd + " From the Wallet\n");

                    System.out.println("\nWe have deposited: " + amount + " BITCOINS INTO YOUR WALLET, CHECK IT!!! ");


                } else {
                    System.out.println("NOT ENOUGH FUNDS");
                }


                break;

            case 2:

                System.out.println("Enter amount of Ethereum to buy:");
                String amountInputE = scanner.nextLine();
                BigDecimal amountE;

                try {
                    InputValidator.validateNumberInput(amountInputE);
                    amountE = new BigDecimal(amountInputE);
                } catch (NotANumberException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    return;
                }
                BigDecimal convertionMyMoneyToEthereum = Wallet.getBalance().divide(Ethereum.getEthereumPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisEthereumPriceinUsd = Ethereum.getEthereumPrice().multiply(amountE);

                if (Wallet.getBalance().compareTo(thisEthereumPriceinUsd) >= 0) {

                    Wallet.withdraw(thisEthereumPriceinUsd);
                    Bitcoin.deposit(amountE);
                    Bitcoin.withdrawExchanger(amountE);
                    System.out.println("\nSubstracting " + thisEthereumPriceinUsd + " From the Wallet\n");

                    System.out.println("\nWe have deposited: " + amountE + " BITCOINS INTO YOUR WALLET, CHECK IT!!! ");


                } else {
                    System.out.println("NOT ENOUGH FUNDS");
                }
                break;
            case 3:
                System.out.println("Returning.....");
                break;

        }
    }
}


