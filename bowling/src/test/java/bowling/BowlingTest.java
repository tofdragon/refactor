package bowling;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sunjing
 */
public class BowlingTest {

    @Test
    public void testZeroScore() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(0);
        }
        Assert.assertEquals(0, bowling.getScore());
    }

    @Test
    public void testNoKnockout1() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(1);
        }

        Assert.assertEquals(20, bowling.getScore());
    }

    @Test
    public void testNoKnockout2() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(2);
        }
        Assert.assertEquals(40, bowling.getScore());
    }

    @Test
    public void testNoKnockout3() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(3);
        }
        Assert.assertEquals(60, bowling.getScore());
    }

    @Test
    public void testNoKnockout4() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(4);
        }
        Assert.assertEquals(80, bowling.getScore());
    }

    @Test
    public void testNoKnockout5() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 20; i++) {
            bowling.roll(4);
        }
        Assert.assertEquals(80, bowling.getScore());
    }

    @Test
    public void testAllSpare() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            // 14 * 9 = 126 + 10
            bowling.roll(4);
            bowling.roll(6);
        }
        bowling.roll(0);
        Assert.assertEquals(136, bowling.getScore());
    }

    @Test
    public void testAllSpare1() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            // 14 * 9 = 126 + 10
            bowling.roll(4);
            bowling.roll(6);
        }
        bowling.roll(3);
        Assert.assertEquals(139, bowling.getScore());
    }

    @Test
    public void testAllSpare2() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            // 14 * 9 = 126 + 10
            bowling.roll(4);
            bowling.roll(6);
        }
        bowling.roll(8);
        Assert.assertEquals(144, bowling.getScore());
    }

    @Test
    public void a_testAllSpare3() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            // 14 * 9 = 126 + 10
            bowling.roll(4);
            bowling.roll(6);
        }
        bowling.roll(10);

        // 156
        Assert.assertEquals(146, bowling.getScore());
    }

    @Test
    public void a_testAllStrike() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            bowling.roll(10);
        }
        bowling.roll(0);
        bowling.roll(0);
        //270
        Assert.assertEquals(270, bowling.getScore());
    }

    @Test
    public void a_testAllStrike1() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            bowling.roll(10);
        }
        bowling.roll(10);
        bowling.roll(10);
        // 320
        Assert.assertEquals(300, bowling.getScore());
    }

    @Test
    public void a_testAllStrike2() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            bowling.roll(10);
        }
        bowling.roll(10);
        bowling.roll(5);
        // 305
        Assert.assertEquals(295, bowling.getScore());
    }

    @Test
    public void a_testAllStrike3() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 10; i++) {
            bowling.roll(10);
        }
        bowling.roll(4);
        bowling.roll(5);

        Assert.assertEquals(283, bowling.getScore());
    }
}
