package com.gildedrose.item;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class AgedBrie extends Item {

    private static final String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }

        quality = quality + 1;
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

        if (quality < 50) {
            quality = quality + 1;
        }
    }

}
