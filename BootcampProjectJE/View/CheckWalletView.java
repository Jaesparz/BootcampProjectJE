package View;

import java.math.BigDecimal;

public class CheckWalletView {
    public void showWalletBalance(BigDecimal amountMoney) {
        System.out.println("\nMoney: " + amountMoney);
    }

    public void showBitcoinBalance(BigDecimal bitcoinBalance) {
        System.out.println("Bitcoin: " + bitcoinBalance);
    }

    public void showEthereumBalance(BigDecimal ethereumBalance) {
        System.out.println("Ethereum: " + ethereumBalance);
    }
}