package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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
        expired();
    }

    protected void updateQuality() {
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

        if (quality <= 0) {
            return;
        }

        if (name.equals(SULFURAS)) {
            return;
        }

        quality = quality - 1;
    }

    protected void updateSellIn() {
        if (name.equals(SULFURAS)) {
            return;
        }

        sellIn = sellIn - 1;
    }

    protected void expired() {
        if (sellIn >= 0) {
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
