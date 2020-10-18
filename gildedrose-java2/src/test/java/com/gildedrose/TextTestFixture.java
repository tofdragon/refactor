package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.print(baseLine(3));
    }

    public static String baseLine(int days) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(bos);
        out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras( 0, 80), //
                new Sulfuras( -1, 80),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            out.println("-------- day " + i + " --------");
            out.println("name, sellIn, quality");
            for (Item item : items) {
                out.println(item);
            }
            out.println();
            app.passOneDay();
        }

        return bos.toString();
    }

}
