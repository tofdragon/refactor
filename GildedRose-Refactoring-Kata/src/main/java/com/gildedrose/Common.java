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
        if (getQuality() <= 0) {
            return;
        }

        setQuality(getQuality() - 1);
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (getSellIn() >= 0) {
            return;
        }

        if (getQuality() <= 0) {
            return;
        }

        setQuality(getQuality() - 1);
    }

}
