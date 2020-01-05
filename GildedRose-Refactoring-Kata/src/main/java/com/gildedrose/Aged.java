package com.gildedrose;

/**
 * Aged
 *
 * @author sunjing
 */
public final class Aged extends Item {

    private static final String NAME = "Aged Brie";

    public Aged(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        qualityIncrementWhenQualityLt();
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }
        qualityIncrementWhenQualityLt();
    }
}
