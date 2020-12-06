package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

    @Override
    public void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    public void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }
}
