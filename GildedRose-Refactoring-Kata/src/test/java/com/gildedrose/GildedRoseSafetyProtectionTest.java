package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.google.common.io.Files;

/**
 * 安全防护
 *
 * @author sunjing
 */
public class GildedRoseSafetyProtectionTest {

    @Test
    public void should_equals() throws IOException {
        String baseLine = TextTestFixture.baseLine();

        String rightBaseLine = Files.toString(
                new File("./src/test/java/com/gildedrose/baseLine.txt"), Charset.forName("UTF-8"));

        Assertions.assertEquals(rightBaseLine, baseLine);
    }
}
