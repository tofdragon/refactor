package com.gildedrose;

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

    void passOneDay() {
        updateQuality();
        updateSellIn();
        updateQualityWhenExpired();
    }

    protected abstract void updateQuality();

    protected abstract void updateSellIn();

    protected abstract void updateQualityWhenExpired();

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
