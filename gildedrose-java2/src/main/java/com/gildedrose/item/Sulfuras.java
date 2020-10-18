package com.gildedrose.item;

/**
 * @author sunjing
 */
public final class Sulfuras extends Item{

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(SULFURAS, sellIn, quality);
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
