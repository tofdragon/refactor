package com.gildedrose.item;

import com.gildedrose.Item;

/**
 *
 * @author sunjing
 */
public class Sulfuras extends Item {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(SULFURAS, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
    }

    @Override
    protected void updateSellIn() {
    }

    @Override
    protected void expired() {
    }
}
