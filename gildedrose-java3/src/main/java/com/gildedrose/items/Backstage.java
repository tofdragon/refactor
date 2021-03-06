package com.gildedrose.items;

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
            quality = quality + 1;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
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

        quality = 0;
    }
}
