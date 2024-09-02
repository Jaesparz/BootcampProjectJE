package Controller;

import Model.*;
import View.CryptocurrenciesfromExchangeView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CryptocurrenciesfromExchangeController {
    private Scanner scanner;


    public CryptocurrenciesfromExchangeController(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void BuyCryptocurrenciesFromExchange() {
        CryptocurrenciesfromExchangeView view = new CryptocurrenciesfromExchangeView(scanner);
        view.showCryptocurrenciesAvailable();
        int choice = view.showCryptocurrenciesMenu();

        switch (choice) {
            case 1:

                BigDecimal amount = view.getAmountInput("Enter amount of Bitcoin to buy:");
                BigDecimal convertionMyMoneyToBitcoin = Wallet.getBalance().divide(Bitcoin.getBitcoinPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisBitcoinPriceinUsd = Bitcoin.getBitcoinPrice().multiply(amount);

                if (Wallet.getBalance().compareTo(thisBitcoinPriceinUsd) >= 0) {

                    Wallet.withdraw(thisBitcoinPriceinUsd);
                    Bitcoin.deposit(amount);
                    Exchanger.withdrawExchangerB(amount);

                    view.showSubstractionMessage(thisBitcoinPriceinUsd);
                    view.showDepositMessage("Bitcoin",amount);

                } else {
                    view.showErrorMessage("NOT ENOUGH FUNDS");
                }


                break;

            case 2:

                BigDecimal amountE = view.getAmountInput("Enter amount of Ethereum to buy:");
                BigDecimal convertionMyMoneyToEthereum = Wallet.getBalance().divide(Ethereum.getEthereumPrice(), RoundingMode.HALF_EVEN);
                BigDecimal thisEthereumPriceinUsd = Ethereum.getEthereumPrice().multiply(amountE);

                if (Wallet.getBalance().compareTo(thisEthereumPriceinUsd) >= 0) {

                    Wallet.withdraw(thisEthereumPriceinUsd);
                    Bitcoin.deposit(amountE);
                    Exchanger.withdrawExchangerE(amountE);

                    view.showSubstractionMessage(thisEthereumPriceinUsd);
                    view.showDepositMessage("Ethereum",amountE);

                } else {
                    view.showErrorMessage("NOT ENOUGH FUNDS");
                }
                break;
            case 3:
                view.showReturnMessage();
                break;

        }
    }
}


