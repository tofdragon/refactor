package com.gildedrose;

final class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void passOneDay() {
        for (Item item : getItems()) {
            item.passOneDay();
        }
    }

    public Item[] getItems() {
        return items;
    }
}