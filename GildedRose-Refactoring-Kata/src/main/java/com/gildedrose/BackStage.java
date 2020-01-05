package com.gildedrose;

/**
 * BackStage
 *
 * @author sunjing
 */
public final class BackStage extends Item {

    private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackStage(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (getQuality() >= 50) {
            return;
        }
        qualityIncrement();

        if (getSellIn() < 10) {
            qualityIncrementWhenQualityLt();
        }

        if (getSellIn() < 5) {
            qualityIncrementWhenQualityLt();
        }
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellInGtEqZero()) {
            return;
        }
        qualityZero();
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }
}
