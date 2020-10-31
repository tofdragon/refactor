package game.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author sunjing
 */
public abstract class AbstractCompareStrategy implements CompareStrategy{

    protected final String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    protected final int[] noOrRepeatNumber(int[] number, int flag) {
        //先获得数组中每个元素出现的次数，然后再进行计算出现次数大于1的和出现次数等于1的
        Map<Integer, Integer> map = new HashMap<>(NUM_SIZE);
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (arg0, arg1) -> arg1.getValue().compareTo(arg0.getValue()));

        int[] repeatNumber = new int[list.size()];
        int[] noRepeatNumber = new int[list.size()];

        int i = 0;
        if (flag == 0) {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    repeatNumber[i] = entry.getKey();
                    i++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == 1) {
                    noRepeatNumber[i] = entry.getKey();
                    i++;
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        if (flag == 0) {
            for (i = 0; i < repeatNumber.length; i++) {
                hashSet.add(repeatNumber[i]);
            }
        } else {
            for (i = 0; i < noRepeatNumber.length; i++) {
                hashSet.add(noRepeatNumber[i]);
            }
        }
        hashSet.remove(0);
        int[] result = new int[hashSet.size()];
        i = 0;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        int[] reResult = new int[result.length];
        for (i = 0; i < result.length; i++) {
            reResult[i] = result[result.length - i - 1];
        }
        return reResult;
    }

    protected final String compareResult(int player1, int player2) {
        if (player1 < player2) {
            return PLAYER_2_WINS_HIGH_CARD + intNumber(player2);
        }

        if (player1 > player2) {
            return PLAYER_1_WINS_HIGH_CARD + intNumber(player1);
        }

        return TIE;
    }
}
