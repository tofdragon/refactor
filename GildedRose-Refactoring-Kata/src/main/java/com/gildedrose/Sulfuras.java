package com.gildedrose;

/**
 * Sulfuras
 *
 * @author sunjing
 */
public final class Sulfuras extends Item {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
