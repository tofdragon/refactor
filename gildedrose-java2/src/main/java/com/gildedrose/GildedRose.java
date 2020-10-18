package com.gildedrose;

class GildedRose {

    static final String AGED_BRIE = "Aged Brie";

    static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void passOneDay() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
            updateQualityWhenExpired(item);
        }
    }

    private void updateQualityWhenExpired(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item) {
        item.updateQuality();
    }
}