package com.gildedrose;

/**
 * @author sunjing
 */
public class Item {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private static final String AGED_BRIE = "Aged Brie";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void passOneDay() {
        updateQuality();
        updateSellIn();
        updateQualityWhenExpired();
    }

    private void updateQuality() {
        if (name.equals(BACKSTAGE)) {
            if (quality >= 50) {
                return;
            }

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
            return;
        }

        if (name.equals(AGED_BRIE)) {
            if (quality >= 50) {
                return;
            }

            quality = quality + 1;
            return;
        }

        if (quality <= 0) {
            return;
        }

        if (name.equals(SULFURAS)) {
            return;
        }

        quality = quality - 1;
    }

    private void updateSellIn() {
        if (name.equals(SULFURAS)) {
            return;
        }

        sellIn = sellIn - 1;
    }

    private void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (name.equals(AGED_BRIE)) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }

        if (name.equals(BACKSTAGE)) {
            quality = 0;
            return;
        }

        if (quality <= 0) {
            return;
        }

        if (name.equals(SULFURAS)) {
            return;
        }

        quality = quality - 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
