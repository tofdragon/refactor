package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

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
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_equals_baseline_when_is_3_days() throws IOException {
        assert_equals_baseline_when_is(3);
    }

    @Test
    public void should_equals_baseline_when_is_5_days() throws IOException {
        assert_equals_baseline_when_is(5);
    }

    private void assert_equals_baseline_when_is(int days) throws IOException {
        String actual = TextTestFixture.baseLine(days);
        String baseLine = Files.toString(new File("src/test/java/com/gildedrose/baseLine" + days +".txt"),
                Charset.forName("utf-8"));
        Assert.assertEquals(baseLine, actual);
    }

}
