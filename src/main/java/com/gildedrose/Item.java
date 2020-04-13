package com.gildedrose;

public abstract class Item {

    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
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
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
