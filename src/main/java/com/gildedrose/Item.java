package com.gildedrose;

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

    protected void updateQuality() {
    }

    protected void updateSellIn() {
    }

    protected void updateQualityWhenExpired() {
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
