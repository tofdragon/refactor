package game;

/**
 * @author sunjing
 */
public enum CardType {

    /**
     * 同花顺
     */
    StraightFlush(9),

    /**
     * 四条
     */
    FourOfAKind(8),

    /**
     * 葫芦
     */
    FullHouse(7),

    /**
     * 同花
     */
    Flush(6),

    /**
     * 顺子
     */
    Straight(5),

    /**
     * 三条
     */
    ThreeOfAKind(4),

    /**
     * 两对
     */
    TwoPair(3),

    /**
     * 一对
     */
    OnePair(2),

    /**
     * 单牌
     */
    HighCard(1);

    private Integer size;

    CardType(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
