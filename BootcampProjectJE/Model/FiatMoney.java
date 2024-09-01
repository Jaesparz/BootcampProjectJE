package Model;

import java.math.BigDecimal;

public class FiatMoney {

    private String name;

    BigDecimal amount;

    public FiatMoney(String name,BigDecimal amount) {
        this.amount = amount;
        this.name = name;
    }
}
