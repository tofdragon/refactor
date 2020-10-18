package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.Backstage;
import com.gildedrose.item.Common;
import com.gildedrose.item.Item;
import com.gildedrose.item.Sulfuras;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.print(baseLine(3));
    }

    public static String baseLine(int days) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(bos);
        out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Common("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0), //
                new Common("Elixir of the Mongoose", 5, 7), //
                new Sulfuras( 0, 80), //
                new Sulfuras( -1, 80),
                new Backstage(15, 20),
                new Backstage( 10, 49),
                new Backstage( 5, 49),
                new Backstage( 1, 20),
                // this conjured item does not work properly yet
                new Common("Conjured Mana Cake", 3, 6) };

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
