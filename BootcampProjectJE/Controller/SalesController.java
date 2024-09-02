package Controller;

import Model.*;
import View.SalesView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SalesController {
    private Scanner scanner;


    public SalesController(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    SalesView view = new SalesView(scanner);

    public void placeSellOrder() {
        int choice = view.selectCryptocurrencyToSell();
        switch (choice) {
            case 1:
                sellBitcoin();
                break;
            case 2:
                sellEthereum();
                break;
        }
    }
        private void sellBitcoin() {
            BigDecimal amount = view.getAmountInput("Enter amount of Bitcoin to sell:");
            BigDecimal minPrice = view.getMinPriceInput("Enter minimum price to sell Bitcoin:");
            ArrayList<BuyOrder> buyOrders = OrderBook.getBuyOrdersBitcoin();

            if (Bitcoin.getBitcoinBalance().compareTo(amount) >= 0) {
                Iterator<BuyOrder> iterator = buyOrders.iterator();
                while (iterator.hasNext()) {
                    BuyOrder buyOrder = iterator.next();

                    if (buyOrder.getAmount().equals(amount) && Bitcoin.getBitcoinPrice().multiply(amount).compareTo(minPrice) >= 0) {
                        view.displayBuyOrderConfirmation(buyOrder);
                        if (view.confirmPurchase()) {
                            Wallet.deposit(Bitcoin.getBitcoinPrice().multiply(amount));
                            Bitcoin.withdraw(amount);
                            HistoryController.setVentasHechas(buyOrder);
                            view.displayBuyOrderSuccessMessage(Bitcoin.getBitcoinPrice().multiply(amount));
                            iterator.remove();
                            return;
                        }
                    }
                }
            } else {
                view.displayInsufficientFundsMessage();
            }
        }
        private void sellEthereum() {
            BigDecimal amount = view.getAmountInput("Enter amount of Ethereum to sell:");
            BigDecimal minPrice = view.getMinPriceInput("Enter minimum price to sell Ethereum:");
            ArrayList<BuyOrder> buyOrders = OrderBook.getBuyOrdersEthereum();

            if (Ethereum.getEthereumBalance().compareTo(amount) >= 0) {
                Iterator<BuyOrder> iterator = buyOrders.iterator();
                while (iterator.hasNext()) {
                    BuyOrder buyOrder = iterator.next();

                    if (buyOrder.getAmount().equals(amount) && Ethereum.getEthereumPrice().multiply(amount).compareTo(minPrice) >= 0) {
                        view.displayBuyOrderConfirmation(buyOrder);
                        if (view.confirmPurchase()) {
                            Wallet.deposit(Ethereum.getEthereumPrice().multiply(amount));
                            Ethereum.withdraw(amount);
                            HistoryController.setVentasHechas(buyOrder);
                            view.displayBuyOrderSuccessMessage(Ethereum.getEthereumPrice().multiply(amount));
                            iterator.remove();
                            return;
                        }
                    }
                }
            } else {
                view.displayInsufficientFundsMessage();
            }

    }
}



