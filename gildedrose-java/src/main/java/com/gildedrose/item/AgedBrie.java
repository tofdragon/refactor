package com.gildedrose.item;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class AgedBrie extends Item {

    private static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }

        quality = quality + 1;
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
