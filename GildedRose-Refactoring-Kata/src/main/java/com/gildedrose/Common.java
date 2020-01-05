package com.gildedrose;

/**
 * Common
 *
 * @author sunjing
 */
public class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
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

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

}
