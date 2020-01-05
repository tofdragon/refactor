package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class TextTestFixture {

    public static String baseLine() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bos);
        out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Common("+5 Dexterity Vest", 10, 20), //
                new Aged(2, 0), //
                new Common("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80), //
                new Sulfuras( -1, 80),
                new BackStage(15, 20),
                new BackStage(10, 49),
                new BackStage(5, 49),
                // this conjured item does not work properly yet
                new Common("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;

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
