package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Common("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.passOneDay();
        assertEquals("foo", app.getItems()[0].getName());
    }

}
