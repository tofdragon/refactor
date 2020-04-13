package com.gildedrose;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Common("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.passOneDay();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_equals_base_line_of_three_days() throws IOException {
        equals_base_line_of(3);
    }

    private void equals_base_line_of(int days) throws IOException {
        String baseline = Files.toString(new File("src/test/java/baseLine" + days + ".txt"), UTF_8);
        Assert.assertEquals(baseline, TextTestFixture.baseLine(days));
    }

    @Test
    public void should_equals_base_line_of_six_days() throws IOException {
        equals_base_line_of(6);
    }

    @Test
    public void should_equals_base_line_of_ten_days() throws IOException {
        equals_base_line_of(10);
    }

    @Test
    public void should_equals_base_line_of_fifteen_days() throws IOException {
        equals_base_line_of(15);
    }
}
