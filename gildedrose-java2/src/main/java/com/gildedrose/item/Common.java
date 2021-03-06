package com.gildedrose.item;

/**
 * @author sunjing
 */
public final class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality <= 0) {
            return;
        }

        decrementQuality();
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

        if (quality <= 0) {
            return;
        }

        decrementQuality();
    }

}
