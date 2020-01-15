package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class OrderItem {

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTaxedAmount() {
        return product.unitaryTaxedAmount().multiply(BigDecimal.valueOf(getQuantity())).setScale(2, HALF_UP);
    }

    public BigDecimal getTax() {
        return product.unitaryTax().multiply(BigDecimal.valueOf(getQuantity()));
    }
}
