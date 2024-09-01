package Model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SellOrder {
    private String sellerName;
    private BigDecimal amount;
    private BigDecimal totalPrice;

    public SellOrder(String sellerName, BigDecimal amount, BigDecimal totalPrice) {
        this.sellerName = sellerName;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public String getSellerName() {
        return sellerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "[" +
                "sellerName='" + sellerName + '\'' +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ']';
    }

}
