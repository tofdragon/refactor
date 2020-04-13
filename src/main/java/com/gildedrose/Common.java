package com.gildedrose;

public class Common extends Item {

    public Common(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    protected void updateQuality() {
        if (quality <= 0) {
            return;
        }
        quality = quality - 1;
    }

    protected void updateSellIn() {
        sell_in = sell_in - 1;
    }

    protected void updateQualityWhenExpired() {
        if (sell_in >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }
}
