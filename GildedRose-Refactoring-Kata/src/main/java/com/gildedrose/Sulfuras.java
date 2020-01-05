package com.gildedrose;

/**
 * Sulfuras
 *
 * @author sunjing
 */
public final class Sulfuras extends Item {

    private static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (quality <= 0) {
            return;
        }
    }

    @Override
    protected void updateSell() {
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }
    }

}
