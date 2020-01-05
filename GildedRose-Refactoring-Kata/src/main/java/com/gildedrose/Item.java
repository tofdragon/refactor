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

    boolean isBackStage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    boolean isAged() {
        return name.equals("Aged Brie");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
