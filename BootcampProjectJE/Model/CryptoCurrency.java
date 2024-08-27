package Model;

import java.math.BigDecimal;

public class CryptoCurrency {
    private String name;
    private BigDecimal amount;

    public CryptoCurrency(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }
}
