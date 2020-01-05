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
        updateCommonQuality();
        updateSellWhenNotSulfuras();
        updateWhenSellLessThanZero();
    }

    private void updateCommonQuality() {
        if (!isAged() && !isBackStage()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackStage()) {
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

    private void updateSellWhenNotSulfuras() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    private void updateWhenSellLessThanZero() {
        if (sellIn < 0) {
            if (!isAged()) {
                if (!isBackStage()) {
                    if (quality > 0) {
                        if (!isSulfuras()) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = quality - quality;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    private boolean isBackStage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isAged() {
        return name.equals("Aged Brie");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
