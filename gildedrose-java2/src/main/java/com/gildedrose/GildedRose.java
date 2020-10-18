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
            item.updateQuality();
            item.updateSellIn();
            updateQualityWhenExpired(item);
        }
    }

    private void updateQualityWhenExpired(Item item) {
        item.updateQualityWhenExpired();
    }

}