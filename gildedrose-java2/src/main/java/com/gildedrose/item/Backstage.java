package com.gildedrose.item;

/**
 * @author sunjing
 */
public final class Backstage extends Item {

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public Backstage(int sellIn, int quality) {
        super(BACKSTAGE, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }

        incrementQuality();

        if (sellIn < 11) {
            if (quality >= 50) {
                return;
            }
            incrementQuality();
        }

        if (sellIn < 6) {
            if (quality >= 50) {
                return;
            }
            incrementQuality();
        }
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

        quality = 0;
    }
}
