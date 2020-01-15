package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String currency;
    private List<OrderItem> items;
    private OrderStatus status;
    private int id;

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal("0.00");
        for (OrderItem orderItem : items) {
            total.add(orderItem.getTaxedAmount());
        }
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTax() {
        BigDecimal tax = new BigDecimal("0.00");
        for (OrderItem orderItem : items) {
            tax.add(orderItem.getTax());
        }
        return tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addItem(Product product, int quantity) {
        final OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);

        if (this.getItems() == null) {
            this.items = new ArrayList<>();
        }
        this.getItems().add(orderItem);
    }
}
