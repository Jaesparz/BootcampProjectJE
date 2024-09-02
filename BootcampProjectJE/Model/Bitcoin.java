package Model;

import java.math.BigDecimal;

public class Bitcoin extends CryptoCurrency {
    private static BigDecimal bitcoinPrice = BigDecimal.valueOf(58963.52);
    private static BigDecimal bitcoinBalance = BigDecimal.valueOf(0);

    public Bitcoin(String name, BigDecimal amount) {
        super(name, amount);
    }


    public static void deposit(BigDecimal amount) {
        System.out.println("Depositing " + amount + " Bitcoins...");
        bitcoinBalance = bitcoinBalance.add(amount);
    }



    public static void withdraw(BigDecimal amount) {
        if (bitcoinBalance.compareTo(amount) >= 0) {
            bitcoinBalance = bitcoinBalance.subtract(amount);
        } else {
            System.out.println("Insufficient Bitcoins");
        }
    }



    public static BigDecimal getBitcoinBalance() {   //ESTE ES LAS MONEDAS ACTUALES QUE SE TIENE
        return bitcoinBalance;
    }
    public static BigDecimal getBitcoinPrice() {    //pilas, este usalo para las conversiones y compra/venta Y PARA MOSTRAR EL PRECIO ESTANDAR DE LA MONEDA.
        return bitcoinPrice;
    }




}
