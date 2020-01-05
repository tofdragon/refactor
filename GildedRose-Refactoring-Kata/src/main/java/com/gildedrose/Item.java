package com.gildedrose;

public abstract class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void passOneDay() {
        updateSell();
        updateCommonQuality();

        if (getSellIn() >= 0) {
            return;
        }
        sellInExpired();
    }

    protected void updateSell() {
    }

    protected void updateCommonQuality() {
    }

    protected void sellInExpired() {
    }

    protected final void sellInDecrement() {
        sellIn = sellIn - 1;
    }

    protected final void qualityIncrementWhenQualityLtFifty() {
        if (getQuality() < 50) {
            qualityIncrement();
        }
    }

    protected final void qualityDecrement() {
        this.quality = this.quality - 1;
    }

    protected final void qualityIncrement() {
        this.quality = this.quality + 1;
    }

    protected final void qualityZero() {
        this.quality = 0;
    }

    protected final boolean qualityLtEqZero() {
        return getQuality() <= 0;
    }

    public String getName() {
        return name;
    }

    protected final int getSellIn() {
        return sellIn;
    }

    protected final int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
