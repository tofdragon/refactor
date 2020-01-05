package com.gildedrose;

final class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : getItems()) {
            updateCommonQuality(item);
            updateSellWhenNotSulfuras(item);
            updateWhenSellLessThanZero(item);
        }
    }

    private void updateCommonQuality(Item item) {
        if (!item.isAged() && !item.isBackStage()) {
            if (item.quality > 0) {
                if (!item.isSulfuras()) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.isBackStage()) {
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
    }

    private void updateSellWhenNotSulfuras(Item item) {
        if (!item.isSulfuras()) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateWhenSellLessThanZero(Item item) {
        if (item.sellIn < 0) {
            if (!item.isAged()) {
                if (!item.isBackStage()) {
                    if (item.quality > 0) {
                        if (!item.isSulfuras()) {
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

    public Item[] getItems() {
        return items;
    }
}