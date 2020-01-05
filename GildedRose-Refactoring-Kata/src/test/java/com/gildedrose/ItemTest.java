package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * item
 *
 * @author sunjing
 */
public class ItemTest {

    @Test
    public void should_increment_three_when_lt_five() {
        Item item = new BackStage(2, 20);

        item.passOneDay();
        assertEquals(23, item.getQuality());

        item.passOneDay();
        assertEquals(26, item.getQuality());
    }

    @Test
    public void should_increment_five_when_lt_ten() {
        Item item = new BackStage(11, 20);

        item.passOneDay();
        assertEquals(21, item.getQuality());

        item.passOneDay();
        assertEquals(23, item.getQuality());

        item.passOneDay();
        item.passOneDay();
        item.passOneDay();
        item.passOneDay();
        item.passOneDay();
        assertEquals(34, item.getQuality());
    }
}
