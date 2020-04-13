package com.gildedrose;

public class Backstage extends Item {

    private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public Backstage(int sell_in, int quality) {
        super(NAME, sell_in, quality);
    }

    protected void updateQuality() {
        if (quality >= 50) {
            return;
        }
        quality = quality + 1;

        if (sell_in < 11) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }

        if (sell_in < 6) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
        return;
    }

    protected void updateSellIn() {
        sell_in = sell_in - 1;
    }

    protected void updateQualityWhenExpired() {
        if (sell_in >= 0) {
            return;
        }
        quality = quality - quality;
    }
}
