package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author sunjing
 */
public class Player {

    private static final int NUM_SIZE = 5;

    public CardType judgeType(String str) {
        //判断是什么牌
        String[] strArray = str.split("");
        int[] number = strNumber(str);
        ;
        String[] color = new String[NUM_SIZE];
        for (int i = 0; i < NUM_SIZE; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        HashSet<Integer> hashSetNumber = new HashSet<>();
        for (int i = 0; i < NUM_SIZE; i++) {
            hashSetNumber.add(number[i]);
        }
        HashSet<String> hashSetType = new HashSet<>();
        for (int i = 0; i < NUM_SIZE; i++) {
            hashSetType.add(color[i]);
        }

        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        if (hashSetNumber.size() == NUM_SIZE) {
            if ((number[zero] - number[four] == four) && (hashSetType.size() == one)) {
                //五个相邻的数字且花色一样——同花顺
                return CardType.StraightFlush;
            }

            if (number[zero] - number[four] == four) {
                //五个相邻数字——顺子
                return CardType.Straight;
            }

            if (hashSetType.size() == one) {
                //同一花色——同花
                return CardType.Flush;
            }
            //五个不相邻的数字——散牌
            return CardType.HighCard;
        }

        if (hashSetNumber.size() == four) {
            //一对相同，其余三个数字不同——对子
            return CardType.OnePair;
        }

        if (hashSetNumber.size() == three) {
            if ((number[zero] == number[one] && number[two] == number[three])) {
                //两对
                return CardType.TwoPair;
            }

            if ((number[one] == number[two] && number[three] == number[four])) {
                //两对
                return CardType.TwoPair;
            }

            if ((number[zero] == number[one] && number[three] == number[four])) {
                //两对
                return CardType.TwoPair;
            }

            //三个数字相同，另外两个数字不同——三条
            return CardType.ThreeOfAKind;
        }

        if (number[one] != number[zero] || number[three] != number[four]) {
            //四个数字相同——铁支
            return CardType.FourOfAKind;
        }

        //三个数字相同，另外两个数字相同——葫芦
        return CardType.FullHouse;
    }

    public int[] strNumber(String str) {
        //数字转化并将其从大到小排序
        Map<String, Integer> tToNum = new HashMap<>(NUM_SIZE);
        tToNum.put("T", 10);
        tToNum.put("J", 11);
        tToNum.put("Q", 12);
        tToNum.put("K", 13);
        tToNum.put("A", 14);

        int[] number = new int[NUM_SIZE];
        String[] strArray = str.split("");
        for (int i = 0; i < NUM_SIZE; i++) {
            String c = strArray[i * 3];
            Integer num = tToNum.get(c);
            number[i] = num == null ? Integer.valueOf(c) : num;
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (int j = 0; j < number.length; j++) {
            renumber[j] = number[number.length - j - 1];
        }
        return renumber;
    }
}
