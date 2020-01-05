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
        updateSell();
        updateWhenSellLessThanZero();
    }

    private void updateCommonQuality() {
        if (isAged() || isBackStage()) {
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
            return;
        }

        if (quality <= 0) {
            return;
        }

        if (isSulfuras()) {
            return;
        }

        quality = quality - 1;
    }

    private void updateSell() {
        if (isSulfuras()) {
            return;
        }

        sellIn = sellIn - 1;
    }

    private void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }

        if (isAged()) {
            if (quality < 50) {
                quality = quality + 1;
            }
            return;
        }

        if (isBackStage()) {
            quality = quality - quality;
        }

        if (quality <= 0) {
            return;
        }

        if (isSulfuras()) {
            return;
        }
        quality = quality - 1;
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
