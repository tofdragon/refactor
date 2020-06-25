package com.gildedrose.item;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class Backstage extends Item {

    private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public Backstage(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }

        qualityIncrement();

        if (sellIn < 11) {
            if (quality < 50) {
                qualityIncrement();
            }
        }

        if (sellIn < 6) {
            if (quality < 50) {
                qualityIncrement();
            }
        }
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

        quality = 0;
    }
}
