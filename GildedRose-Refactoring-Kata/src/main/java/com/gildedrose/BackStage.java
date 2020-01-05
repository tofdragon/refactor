package com.gildedrose;

/**
 * BackStage
 *
 * @author sunjing
 */
public final class BackStage extends Item {

    public BackStage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateCommonQuality() {
        if (quality < 50) {
            quality = quality + 1;


            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
        return;
    }

    @Override
    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }

        quality = quality - quality;
        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

    @Override
    protected void updateSell() {
        sellIn = sellIn - 1;
    }
}
