package com.gildedrose;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import com.google.common.io.Files;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_equals_base_line_of_3_days() throws IOException {
        equals_base_line_of(3);
    }

    private void equals_base_line_of(int days) throws IOException {
        String baseline = Files.toString(new File("src/test/java/com/gildedrose/baseLine" + days + ".txt"), UTF_8);
        Assert.assertEquals(baseline, TextTestFixture.baseLine(days));
    }

    @Test
    public void should_equals_base_line_of_6_days() throws IOException {
        equals_base_line_of(6);
    }

    @Test
    public void should_equals_base_line_of_9_days() throws IOException {
        equals_base_line_of(9);
    }

    @Test
    public void should_equals_base_line_of_13_days() throws IOException {
        equals_base_line_of(13);
    }

    @Test
    public void should_equals_base_line_of_18_days() throws IOException {
        equals_base_line_of(18);
    }

    @Test
    public void should_equals_base_line_of_25_days() throws IOException {
        equals_base_line_of(25);
    }
}
