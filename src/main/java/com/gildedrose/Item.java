package com.gildedrose;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    void passOneDay() {
        updateQuality();
        updateSellIn();
        updateQualityWhenExpired();
    }

    private void updateQuality() {
        if (isAgedBrie()) {
            if (quality >= 50) {
                return;
            }

            quality = quality + 1;
            return;
        }

        if (isBackstage()) {
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

        if (quality <= 0) {
            return;
        }

        if (isSulfuras()) {
            return;
        }

        quality = quality - 1;
    }

    private void updateSellIn() {
        if (isSulfuras()) {
            return;
        }

        sell_in = sell_in - 1;
    }

    private void updateQualityWhenExpired() {
        if (sell_in >= 0) {
            return;
        }

        if (isAgedBrie()) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }

        if (isBackstage()) {
            quality = quality - quality;
            return;
        }

        if (quality <= 0) {
            return;
        }

        if (isSulfuras()) {
            return;
        }

        quality = quality - 1;
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
