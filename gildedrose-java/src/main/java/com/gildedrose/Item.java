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
        expired();
    }

    protected void updateQuality() {
    }

    protected void updateSellIn() {
    }

    protected final void sellInDecrement() {
        sellIn = sellIn - 1;
    }

    protected void expired() {
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
