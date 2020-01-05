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
    }

    @Override
    protected void updateSell() {
    }

    @Override
    protected void updateWhenSellLessThanZero() {
    }

}
