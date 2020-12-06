package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;
import com.gildedrose.items.Common;
import com.google.common.io.Files;

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
    public void should_equals_baseLine_when_is_3_days() throws IOException {
        assertEqualsBaseLine(3);
    }

    private void assertEqualsBaseLine(int days) throws IOException {
        String actual = Files.toString(new File("src/test/java/com/gildedrose/baseLine" + days + ".txt"),
                Charset.forName("utf-8"));
        assertThat(actual, is(TextTestFixture.baseLine(days)));
    }

    @Test
    public void should_equals_baseLine_when_is_9_days() throws IOException {
        assertEqualsBaseLine(9);
    }
}
