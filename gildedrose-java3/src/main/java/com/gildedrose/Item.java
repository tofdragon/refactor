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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void passOneDay() {
        updateQuality();
        updateSellIn();
        updateQualityWhenExpired();
    }

    /**
     *  updateQuality
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

}
