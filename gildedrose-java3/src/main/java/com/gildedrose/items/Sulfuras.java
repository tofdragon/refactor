package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author sunjing
 */
public class Sulfuras extends Item {

    private static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
    }

    @Override
    protected void updateSellIn() {
    }

    @Override
    protected void updateQualityWhenExpired() {
    }
}
