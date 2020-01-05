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
        setQuality(getQuality() + 1);

        if (getSellIn() < 11) {
            qualityIncrementWhenQualityLt();
        }

        if (getSellIn() < 6) {
            qualityIncrementWhenQualityLt();
        }
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (getSellIn() >= 0) {
            return;
        }
        setQuality(0);
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }
}
