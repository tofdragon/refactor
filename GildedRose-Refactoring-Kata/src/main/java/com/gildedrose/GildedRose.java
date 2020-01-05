package com.gildedrose;

final class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : getItems()) {
            item.updateQuality();
        }
    }

    public Item[] getItems() {
        return items;
    }
}