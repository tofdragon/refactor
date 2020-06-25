package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void passOneDay() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
            expired(item);
        }
    }

    private void expired(Item item) {
        item.expired();
    }

    private void updateSellIn(Item item) {
        item.updateSellIn();
    }

    private void updateQuality(Item item) {
        item.updateQuality();
    }
}
