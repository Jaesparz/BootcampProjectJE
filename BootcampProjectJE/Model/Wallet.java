package Model;

import java.math.BigDecimal;

public interface Wallet {
    BigDecimal amount = null;

    void save();
}
