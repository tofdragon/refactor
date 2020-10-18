package com.gildedrose;

import java.util.stream.Stream;

import com.gildedrose.item.Item;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void passOneDay() {
        Stream.of(items).forEach(Item::passOneDay);
    }

}