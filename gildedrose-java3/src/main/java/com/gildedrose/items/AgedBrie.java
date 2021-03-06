package com.gildedrose.items;

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
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality >= 50) {
            return;
        }
        quality = quality + 1;

    }

}
