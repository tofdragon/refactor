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
        if (quality >= 50) {
            return;
        }
        quality = quality + 1;

        if (sellIn < 11) {
            qualityIncrementWhenQualityLt();
        }

        if (sellIn < 6) {
            qualityIncrementWhenQualityLt();
        }
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }
        quality = 0;
    }

    @Override
    protected void updateSell() {
        sellInDecrement();
    }
}
