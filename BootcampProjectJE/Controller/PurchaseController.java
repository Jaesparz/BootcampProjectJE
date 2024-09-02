package Controller;

import Model.*;
import View.PurchaseView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PurchaseController {
    private Scanner scanner = new Scanner(System.in);


    public PurchaseController(Scanner scanner) {

    }

    PurchaseView view = new PurchaseView(scanner);

    public void placeBuyOrder() {

        int choice = view.selectCryptocurrency();
        if (choice == 1) {
            buyBitcoin();
        } else if (choice == 2) {
            buyEthereum();
        }


    }
    private void buyBitcoin() {
        BigDecimal amount = view.getAmountInput("Enter amount of Bitcoin to buy:");
        BigDecimal maxPrice = view.getMaxPriceInput("Enter maximum price to pay per Bitcoin:");
        ArrayList<SellOrder> sellOrders = OrderBook.getSellOrdersBitcoin();

        if (Wallet.getBalance().compareTo(Bitcoin.getBitcoinPrice().multiply(amount)) >= 0) {
            Iterator<SellOrder> iterator = sellOrders.iterator();
            while (iterator.hasNext()) {
                SellOrder sellOrder = iterator.next();
                if (sellOrder.getAmount().equals(amount) && Bitcoin.getBitcoinPrice().multiply(amount).compareTo(maxPrice) <= 0) {
                    view.displayBuyOrderConfirmation(sellOrder);
                    if (view.confirmPurchase()) {
                        Wallet.withdraw(Bitcoin.getBitcoinPrice().multiply(amount));
                        Bitcoin.deposit(amount);
                        HistoryController.setComprasHechas(sellOrder);
                        view.displayBuyOrderSuccessMessageB(amount);
                        iterator.remove();
                        return;
                    }
                }
            }
        } else {
            view.displayInsufficientFundsMessage();
        }
    }

    private void buyEthereum() {
        BigDecimal amount = view.getAmountInput("Enter amount of Ethereum to buy:");
        BigDecimal maxPrice = view.getMaxPriceInput("Enter maximum price to pay per Ethereum:");
        ArrayList<SellOrder> sellOrders = OrderBook.getSellOrdersEthereum();

        if (Wallet.getBalance().compareTo(Ethereum.getEthereumPrice().multiply(amount)) >= 0) {
            Iterator<SellOrder> iterator = sellOrders.iterator();
            while (iterator.hasNext()) {
                SellOrder sellOrder = iterator.next();

                if (sellOrder.getAmount().equals(amount) && Ethereum.getEthereumPrice().multiply(amount).compareTo(maxPrice) <= 0) {
                    view.displayBuyOrderConfirmation(sellOrder);
                    if (view.confirmPurchase()) {
                        Wallet.withdraw(Ethereum.getEthereumPrice().multiply(amount));
                        Ethereum.deposit(amount);
                        HistoryController.setComprasHechas(sellOrder);
                        view.displayBuyOrderSuccessMessageE(amount);
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






