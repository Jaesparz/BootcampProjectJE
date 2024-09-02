package Model;

import java.math.BigDecimal;

public class Ethereum extends CryptoCurrency {

    private static BigDecimal ethereumBalance = BigDecimal.valueOf(0);
    private static BigDecimal ethereumPrice = BigDecimal.valueOf(2542.80);
    private static BigDecimal ethereumeExchangerBalance = BigDecimal.valueOf(300);

    public Ethereum(String name, BigDecimal amount) {
        super(name, amount);
    }


    public  static void deposit(BigDecimal amount) {
        System.out.println("Depositing " + amount + " Ethereum...");
        ethereumBalance = ethereumBalance.add(amount);
    }


    public static void withdraw(BigDecimal amount) {
        if (ethereumBalance.compareTo(amount) >= 0) {
            ethereumBalance = ethereumBalance.subtract(amount);
        } else {
            System.out.println("Insufficient Bitcoins");
        }
    }
    public static void withdrawExchanger(BigDecimal amount) {
        if (ethereumeExchangerBalance.compareTo(amount) >= 0) {
            ethereumeExchangerBalance = ethereumeExchangerBalance.subtract(amount);
        } else {
            System.out.println("Insufficient Bitcoins");
        }
    }


    public static BigDecimal getEthereumBalance() {    ///PARA MOSTRAR DEPOSITAT O QUITAR PUEDES USAR LAS VARIABLES DE UNA VEZ ;).
        return ethereumBalance;
    }
    public  static BigDecimal getEthereumPrice() {        //pilas, este usalo para las conversiones y compra/venta
        return ethereumPrice;
    }
    public  static BigDecimal getEthereumExchangerBalance() {
        return ethereumeExchangerBalance;
    }


}


