package com.gildedrose.item;

/**
 * @author sunjing
 */
public final class AgedBrie extends Item {

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
    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality < 50) {
            quality = quality + 1;
        }

    }

}
