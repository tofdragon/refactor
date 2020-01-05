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

    public void updateQuality() {
        updateCommonQuality();
        updateSell();
        updateWhenSellLessThanZero();
    }

    protected void updateCommonQuality() {
    }

    protected void updateSell() {
    }

    protected void updateWhenSellLessThanZero() {
    }

    protected final void sellInDecrement() {
        sellIn = sellIn - 1;
    }

    protected final void qualityIncrementWhenQualityLt() {
        if (getQuality() < 50) {
            quality = quality + 1;
        }
    }

    protected final void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
