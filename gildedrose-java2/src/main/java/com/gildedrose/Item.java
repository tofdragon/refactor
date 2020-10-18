package com.gildedrose;

/**
 * @author sunjing
 */
public class Item {

    protected static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

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

    protected void updateQuality() {
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

        quality = quality - 1;
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQualityWhenExpired() {
        if (sellIn >= 0) {
            return;
        }

        if (name.equals(AGED_BRIE)) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
