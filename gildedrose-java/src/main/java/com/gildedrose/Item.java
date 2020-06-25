package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";;
    
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

    private void updateQuality() {
        if (!name.equals(AGED_BRIE) && !name.equals(BACKSTAGE)) {
            if (quality > 0) {
                if (!name.equals(SULFURAS)) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals(BACKSTAGE)) {
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
            }
        }
    }

    private void updateSellIn() {
        if (name.equals(SULFURAS)) {
            return;
        }

        sellIn = sellIn - 1;
    }

    private void expired() {
        if (sellIn < 0) {
            if (!name.equals(AGED_BRIE)) {
                if (!name.equals(BACKSTAGE)) {
                    if (quality > 0) {
                        if (!name.equals(SULFURAS)) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = quality - quality;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
