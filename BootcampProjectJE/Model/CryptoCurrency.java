package Model;

import java.math.BigDecimal;

public abstract class CryptoCurrency {
    protected String name;
    protected static BigDecimal amount;

    public CryptoCurrency(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CryptoCurrency{" +
                "name='" + name + '\'' +
                '}';
    }
}

