package com.gildedrose;

/**
 * Common
 *
 * @author sunjing
 */
public final class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (qualityLtEqZero()) {
            return;
        }

        qualityDecrement();
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellInGtEqZero()) {
            return;
        }

        if (qualityLtEqZero()) {
            return;
        }

        qualityDecrement();
    }

}
