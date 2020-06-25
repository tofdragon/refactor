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
        qualityDecrement();
    }

    @Override
    protected void updateSellIn() {
        sellInDecrement();
    }

    @Override
    protected void expired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        qualityDecrement();
    }
}
