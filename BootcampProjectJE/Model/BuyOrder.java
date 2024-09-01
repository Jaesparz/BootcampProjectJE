package Model;

import java.math.BigDecimal;

public class BuyOrder {
    private String buyerName;
    private BigDecimal amount;
    private BigDecimal totalPrice;

    public BuyOrder(String buyerName, BigDecimal amount, BigDecimal totalPrice) {
        this.buyerName = buyerName;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public String getBuyerName() {
        return buyerName;
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
                "buyerName='" + buyerName + '\'' +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ']';
    }

}
