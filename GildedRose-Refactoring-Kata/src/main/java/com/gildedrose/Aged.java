package com.gildedrose;

/**
 * Aged
 *
 * @author sunjing
 */
public final class Aged extends Item {

    public Aged(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        return;
    }

    @Override
    protected void updateSell() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }

        if (quality < 50) {
            quality = quality + 1;
        }
    }


}
