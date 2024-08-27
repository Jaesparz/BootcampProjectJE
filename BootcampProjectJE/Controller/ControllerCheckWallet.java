package Controller;

import Model.Wallet;

import java.util.Scanner;

public class ControllerCheckWallet {

    private Scanner scanner;
    private Wallet wallet;
    private double amountMoney;
    private double amountBitcoin;
    private double amountEthereum;
    public ControllerCheckWallet() {
        scanner = new Scanner(System.in);
        wallet = new Wallet();
        amountMoney = wallet.getBalance();
        amountBitcoin = 0.0;
        amountEthereum = 0.0;

    }



    public void checkWallet() {
        System.out.println("Money: "+amountMoney);
        System.out.println("Bitcoin: "+amountBitcoin);
        System.out.println("Ethereum: "+amountEthereum);


    }

}
