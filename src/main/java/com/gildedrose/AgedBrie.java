package com.gildedrose;

public class AgedBrie extends Item {

    private static final String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }

        quality = quality + 1;
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
