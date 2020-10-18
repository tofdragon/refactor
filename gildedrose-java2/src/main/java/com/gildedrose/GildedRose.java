package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (Item item : items) {
            final String agedBrie = "Aged Brie";
            final String backstage = "Backstage passes to a TAFKAL80ETC concert";
            final String sulfuras = "Sulfuras, Hand of Ragnaros";

            if (!item.name.equals(agedBrie)
                    && !item.name.equals(backstage)) {
                if (item.quality > 0) {
                    if (!item.name.equals(sulfuras)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(backstage)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(sulfuras)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(agedBrie)) {
                    if (!item.name.equals(backstage)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(sulfuras)) {
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
    }
}
