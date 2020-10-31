package game;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sunjing
 */
public class PokerTest {

    private Poker poker = new Poker();

//    红桃H，方块D，黑桃S，梅花C

    @Test
    public void test() {
        Set set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(2);
        System.out.print(set);
    }

    /**
     * 同花顺(StraightFlush)：同一花色的顺子。（最大牌：A-K-Q-J-10 最小牌：2-3-4-5-6）
     */
    @Test
    public void test同花顺_StraightFlush() {
        String str = "player1 wins - StraightFlush";

        // "AH KH QH JH TH"
        Assert.assertEquals("tie", poker.compairResult(同花顺_StraightFlush(), 同花顺_StraightFlush()));
        Assert.assertEquals("player1 wins - high card:A", poker.compairResult(同花顺_StraightFlush(), "2H 3H 4H 5H 6H"));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 四条_FourOfAKind()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 葫芦_FullHouse()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 同花_Flush()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 顺子_Straight()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 三条_ThreeOfAKind()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(同花顺_StraightFlush(), 单牌_HighCard()));
    }

    /**
     * 四条(FourOfAKind)：四同张加单张。（最大牌：A-A-A-A-K 最小牌：2-2-2-2-3）
     */
    @Test
    public void test四条_FourOfAKind() {
        String str = "player1 wins - FourOfAKind";

        // "8S 8D 8H JH 8C"
        Assert.assertEquals("player1 wins - high card:8",
                poker.compairResult(四条_FourOfAKind(), 四条_FourOfAKind()));
        Assert.assertEquals("player2 wins - high card:9",
                poker.compairResult(四条_FourOfAKind(), "9S 9D 9H 9H 6C"));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 葫芦_FullHouse()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 同花_Flush()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 顺子_Straight()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 三条_ThreeOfAKind()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(四条_FourOfAKind(), 单牌_HighCard()));
    }

    /**
     * 葫芦(FullHouse)：三同张加对子。（最大牌：A-A-A-K-K 最小牌：2-2-2-3-3）
     */
    @Test
    public void test葫芦_FullHouse() {
        String str = "player1 wins - FullHouse";

        // "8H 8D 8S 6D 6H"
        Assert.assertEquals("player1 wins - high card:8",
                poker.compairResult(葫芦_FullHouse(), 葫芦_FullHouse()));
        Assert.assertEquals("player2 wins - high card:9",
                poker.compairResult(葫芦_FullHouse(), "9H 9D 9S 7D 7H"));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 同花_Flush()));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 顺子_Straight()));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 三条_ThreeOfAKind()));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(葫芦_FullHouse(), 单牌_HighCard()));
    }

    /**
     * 同花(Flush)：同一花色。（最大牌：A-K-Q-J-9 最小牌：2-3-4-5-7）
     */
    @Test
    public void test同花_Flush() {
        String str = "player1 wins - Flush";

        // "8H 5H TH 7H 6H"
        Assert.assertEquals("tie", poker.compairResult(同花_Flush(), 同花_Flush()));
//        Assert.assertEquals("player2 wins - high card:9", poker.compairResult(同花_Flush(), "1H 3H 5H 9H TH"));
        Assert.assertEquals(str, poker.compairResult(同花_Flush(), 顺子_Straight()));
        Assert.assertEquals(str, poker.compairResult(同花_Flush(), 三条_ThreeOfAKind()));
        Assert.assertEquals(str, poker.compairResult(同花_Flush(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(同花_Flush(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(同花_Flush(), 单牌_HighCard()));
    }

    /**
     * 顺子(Straight)：花色不一样的顺子。（最大牌：A-K-Q-J-10 最小牌：2-3-4-5-6）
     */
    @Test
    public void test顺子_Straight() {
        String str = "player1 wins - Straight";

        //"5H 6D 7S 8C 9H"
        Assert.assertEquals("tie", poker.compairResult(顺子_Straight(), 顺子_Straight()));
        Assert.assertEquals("player2 wins - high card:A", poker.compairResult(顺子_Straight(), "TH JD QS KC AH"));
        Assert.assertEquals(str, poker.compairResult(顺子_Straight(), 三条_ThreeOfAKind()));
        Assert.assertEquals(str, poker.compairResult(顺子_Straight(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(顺子_Straight(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(顺子_Straight(), 单牌_HighCard()));
    }

    /**
     * 三条(ThreeOfAKind)：三同张加两单张。（最大牌：A-A-A-K-Q 最小牌：2-2-2-3-4）
     */
    @Test
    public void test三条_ThreeOfAKind() {
        String str = "player1 wins - ThreeOfAKind";

        // 5H 5D 5S 8C 7H
        Assert.assertEquals("player1 wins - high card:5",
                poker.compairResult(三条_ThreeOfAKind(), 三条_ThreeOfAKind()));
        Assert.assertEquals("player2 wins - high card:9",
                poker.compairResult(三条_ThreeOfAKind(), "9H 9D 9S 4C 2H"));
        Assert.assertEquals(str, poker.compairResult(三条_ThreeOfAKind(), 两对_TwoPair()));
        Assert.assertEquals(str, poker.compairResult(三条_ThreeOfAKind(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(三条_ThreeOfAKind(), 单牌_HighCard()));
    }

    /**
     * 两对(TwoPair)：（最大牌：A-A-K-K-Q 最小牌：2-2-3-3-4）
     */
    @Test
    public void test两对_TwoPair() {
        String str = "player1 wins - TwoPair";

        // 5H 5D 6S 6C 9H
        Assert.assertEquals("player2 wins - high card:8",
                poker.compairResult(两对_TwoPair(), "7H 7D 8S 8C 3H"));
        Assert.assertEquals(str, poker.compairResult(两对_TwoPair(), 一对_OnePair()));
        Assert.assertEquals(str, poker.compairResult(两对_TwoPair(), 单牌_HighCard()));
    }

    /**
     * 一对(OnePair)：（最大牌：A-A-K-Q-J 最小牌：2-2-3-4-5）
     */
    @Test
    public void test一对_OnePair() {
        String str = "player1 wins - OnePair";

        // "2H 2D 5S 9C 7H"
        Assert.assertEquals("tie", poker.compairResult(一对_OnePair(), 一对_OnePair()));
        Assert.assertEquals("player2 wins - high card:3", poker.compairResult(一对_OnePair(), "3H 3D 6S 2C 9H"));
        Assert.assertEquals(str, poker.compairResult(一对_OnePair(), 单牌_HighCard()));
    }

    /**
     * 单牌(HighCard)：（最大牌：A-K-Q-J-9 最小牌：2-3-4-5-7）
     */
    @Test
    public void test单牌_HighCard() {
        String str = "player1 wins - OnePair";

        // "5H 3D 7S TC 9H"
        Assert.assertEquals("tie", poker.compairResult(单牌_HighCard(), 单牌_HighCard()));
        Assert.assertEquals("player2 wins - high card:J", poker.compairResult(单牌_HighCard(), "6H 3D 8S 5C JH"));
    }

    private String 同花顺_StraightFlush() {
        return "AH KH QH JH TH";
    }

    private String 四条_FourOfAKind() {
        return "8S 8D 8H JH 8C";
    }

    private String 葫芦_FullHouse() {
        return "8H 8D 8S 6D 6H";
    }

    private String 同花_Flush() {
        return "8H 5H TH 7H 6H";
    }

    private String 顺子_Straight() {
        return "5H 6D 7S 8C 9H";
    }

    private String 三条_ThreeOfAKind() {
        return "5H 5D 5S 8C 7H";
    }

    private String 两对_TwoPair() {
        return "5H 5D 6S 6C 9H";
    }

    private String 一对_OnePair() {
        return "2H 2D 5S 9C 7H";
    }

    private String 单牌_HighCard() {
        return "5H 3D 7S TC 9H";
    }

    @Test
    public void testDiffCardType() {
        Assert.assertEquals("player1 wins - StraightFlush",
                poker.compairResult("3H 6H 2H 4H 5H", "8S 8D 8H JH 8C"));

        Assert.assertEquals("player2 wins - StraightFlush",
                poker.compairResult("8S 8D 8H JH 8C", "3H 6H 2H 4H 5H"));
    }

    @Test
    public void testSameCardType() {
        Assert.assertEquals("player2 wins - high card:Q",
                poker.compairResult("3H 6H 2H 4H 5H", "8D 9D TD JD QD"));

        Assert.assertEquals("player1 wins - high card:Q",
                poker.compairResult("8D 9D TD JD QD", "3H 6H 2H 4H 5H"));
    }

    @Test
    public void testTie() {
        Assert.assertEquals("tie",
                poker.compairResult("3H 6H 2H 4H 5H", "3H 6H 2H 4H 5H"));

        Assert.assertEquals("tie",
                poker.compairResult("8D 9D TD JD QD", "8D 9D TD JD QD"));
    }

}
