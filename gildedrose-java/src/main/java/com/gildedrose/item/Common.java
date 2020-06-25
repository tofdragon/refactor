package com.gildedrose.item;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality <= 0) {
            return;
        }
        quality = quality - 1;
    }

    @Override
    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void expired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }
}
