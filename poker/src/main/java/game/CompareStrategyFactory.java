package game;

import java.util.HashMap;
import java.util.Map;

import game.strategy.CompareStrategy;
import game.strategy.FourOfKindCompareStrategy;
import game.strategy.OnePairCompareStrategy;
import game.strategy.StraightFlushCompareStrategy;
import game.strategy.ThreeOfKindCompareStrategy;
import game.strategy.TwoPairCompareStrategy;

/**
 * @author sunjing
 */
public class CompareStrategyFactory {

    private Map<CardType, CompareStrategy> typeToStrategy = new HashMap<>();

    public CompareStrategyFactory() {
        typeToStrategy.put(CardType.StraightFlush, new StraightFlushCompareStrategy());
        typeToStrategy.put(CardType.Flush, new StraightFlushCompareStrategy());
        typeToStrategy.put(CardType.Straight, new StraightFlushCompareStrategy());
        typeToStrategy.put(CardType.HighCard, new StraightFlushCompareStrategy());

        typeToStrategy.put(CardType.FourOfAKind, new FourOfKindCompareStrategy());
        typeToStrategy.put(CardType.FullHouse, new FourOfKindCompareStrategy());

        typeToStrategy.put(CardType.ThreeOfAKind, new ThreeOfKindCompareStrategy());

        typeToStrategy.put(CardType.TwoPair, new TwoPairCompareStrategy());

        typeToStrategy.put(CardType.OnePair, new OnePairCompareStrategy());
    }

    public CompareStrategy compareStrategy(CardType cardType) {
        return typeToStrategy.get(cardType);
    }
}
