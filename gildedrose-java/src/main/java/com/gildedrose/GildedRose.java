package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String agedBrie = "Aged Brie";
            String backstage = "Backstage passes to a TAFKAL80ETC concert";
            String sulfuras = "Sulfuras, Hand of Ragnaros";

            updateQuality(item, agedBrie, backstage, sulfuras);
            updateSellIn(item, sulfuras);
            sellInLessZero(item, agedBrie, backstage, sulfuras);
        }
    }

    private void sellInLessZero(Item item, String agedBrie, String backstage, String sulfuras) {
        if (item.sell_in < 0) {
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

    private void updateSellIn(Item item, String sulfuras) {
        if (!item.name.equals(sulfuras)) {
            item.sell_in = item.sell_in - 1;
        }
    }

    private void updateQuality(Item item, String agedBrie, String backstage, String sulfuras) {
        if (!item.name.equals(agedBrie) && !item.name.equals(backstage)) {
            if (item.quality > 0) {
                if (!item.name.equals(sulfuras)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(backstage)) {
                    if (item.sell_in < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sell_in < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }
    }
}
