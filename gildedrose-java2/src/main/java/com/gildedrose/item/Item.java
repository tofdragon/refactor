package com.gildedrose.item;

/**
 * @author sunjing
 */
public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void passOneDay() {
        updateQuality();
        updateSellIn();
        updateQualityWhenExpired();
    }

    /**
     * updateQuality
     */
    protected abstract void updateQuality();

    /**
     * updateSellIn
     */
    protected abstract void updateSellIn();

    /**
     * updateQualityWhenExpired
     */
    protected abstract void updateQualityWhenExpired();

    protected final void incrementQuality() {
        quality = quality + 1;
    }

    protected final void decrementSellIn() {
        sellIn = sellIn - 1;
    }

    protected final void decrementQuality() {
        quality = quality - 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
