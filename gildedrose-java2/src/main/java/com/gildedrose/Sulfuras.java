package com.gildedrose;

/**
 * @author sunjing
 */
public final class Sulfuras extends Item{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
