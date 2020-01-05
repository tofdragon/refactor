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

    protected void updateCommonQuality() {
        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

    protected void updateSell() {
        sellInDecrement();
    }

    protected final void sellInDecrement() {
        sellIn = sellIn - 1;
    }

    protected void updateWhenSellLessThanZero() {
        if (sellIn >= 0) {
            return;
        }

        if (quality <= 0) {
            return;
        }

        quality = quality - 1;
    }

    protected final void qualityIncrementWhenQualityLt() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
