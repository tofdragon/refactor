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
    protected void updateSell() {
        sellInDecrement();
    }

    @Override
    protected void updateCommonQuality() {
        if (qualityLtEqZero()) {
            return;
        }

        qualityDecrement();
    }

    @Override
    protected void sellInExpired() {
        if (qualityLtEqZero()) {
            return;
        }

        qualityDecrement();
    }

}
