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
    protected void updateSell() {
        sellInDecrement();
    }

    @Override
    protected void updateCommonQuality() {
        qualityIncrementWhenQualityLtFifty();
    }

    @Override
    protected void sellInExpired() {
        qualityIncrementWhenQualityLtFifty();
    }
}
