package Controller;

import Model.Bitcoin;
import Model.CryptoCurrency;
import Model.Ethereum;
import Model.Wallet;

import java.math.BigDecimal;
import java.util.Scanner;

public class ControllerCheckWallet {

    private DepositMoneyController depositMoneyController;
    private Wallet wallet;
    private double amountMoney;
    private Bitcoin bitcoin;
    private Ethereum ethereum;


    public ControllerCheckWallet() {

    }

    public void checkWallet() {

        System.out.println("Money: " + Wallet.getBalance());
        System.out.println("Bitcoin: " + Bitcoin.getBitcoinBalance() );
        System.out.println("Ethereum: " + Ethereum.getEthereumBalance()) ;
    }
}
