package com.gildedrose;

public class Common extends Item {

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (quality <= 0) {
            return;
        }
        quality = quality - 1;
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }
}
