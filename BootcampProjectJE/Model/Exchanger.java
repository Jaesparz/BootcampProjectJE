package Model;

import java.math.BigDecimal;

public class Exchanger {

    private static BigDecimal bitcoinExchangerBalance = BigDecimal.valueOf(50);
    private static BigDecimal ethereumeExchangerBalance = BigDecimal.valueOf(300);

    public static void withdrawExchangerE(BigDecimal amount) {
        if (ethereumeExchangerBalance.compareTo(amount) >= 0) {
            ethereumeExchangerBalance = ethereumeExchangerBalance.subtract(amount);
        } else {
            System.out.println("Insufficient Bitcoins");
        }
    }
    public static void withdrawExchangerB(BigDecimal amount) {
        if (bitcoinExchangerBalance.compareTo(amount) >= 0) {
            bitcoinExchangerBalance = bitcoinExchangerBalance.subtract(amount);
        } else {
            System.out.println("Insufficient Bitcoins");
        }
    }

    public  static BigDecimal getEthereumExchangerBalance() {
        return ethereumeExchangerBalance;
    }
    public static BigDecimal getBitcoinExchangerBalance() {
        return bitcoinExchangerBalance;
    }

}
