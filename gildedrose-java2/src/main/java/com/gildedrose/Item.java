package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        if (!name.equals(GildedRose.AGED_BRIE) && !name.equals(GildedRose.BACKSTAGE)) {
            if (quality > 0) {
                if (!name.equals(GildedRose.SULFURAS)) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals(GildedRose.BACKSTAGE)) {
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

    public void updateSellIn() {
        if (!name.equals(GildedRose.SULFURAS)) {
            sellIn = sellIn - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


}
