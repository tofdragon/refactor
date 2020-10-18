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

        incrementQuality();
    }

    @Override
    protected void updateSellIn() {
        decrementSellIn();
    }

    @Override
    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality >= 50) {
            return;
        }

        incrementQuality();
    }

}
