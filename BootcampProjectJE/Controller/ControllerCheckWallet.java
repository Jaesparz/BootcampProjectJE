package Controller;

import Model.Bitcoin;
import Model.CryptoCurrency;
import Model.Ethereum;
import Model.Wallet;
import View.CheckWalletView;

import java.math.BigDecimal;
import java.util.Scanner;

public class ControllerCheckWallet {




    public ControllerCheckWallet() {

    }

    public void checkWallet() {
        CheckWalletView view = new CheckWalletView();

        view.showWalletBalance(Wallet.getBalance());
        view.showBitcoinBalance(Bitcoin.getBitcoinBalance());
        view.showEthereumBalance(Ethereum.getEthereumBalance());
    }
}

