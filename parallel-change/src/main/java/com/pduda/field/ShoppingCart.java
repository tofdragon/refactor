package com.pduda.field;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    private List<Integer> prices = new LinkedList<>();

    public void add(int price) {
        this.prices.add(price);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Integer price : prices) {
            total += price;
        }
        return total;
    }

    public boolean hasDiscount() {
        return calculateTotalPrice() >= 100;
    }

    public int numberOfProducts() {
        return prices.size();
    }
}
