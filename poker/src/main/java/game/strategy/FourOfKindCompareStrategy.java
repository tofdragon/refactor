package game.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.Player;

/**
 * @author sunjing
 */
public class FourOfKindCompareStrategy extends AbstractCompareStrategy {

    @Override
    public String compare(String player1, String player2) {
        Player player = new Player();

        int[] player1Number = player.strNumber(player1);
        int[] player2Number = player.strNumber(player2);

        return sameFourOfKind(player1Number, player2Number);
    }

    private String sameFourOfKind(int[] player1Number, int[] player2Number) {
        int[] player1ArraySort = arraySort(player1Number);
        int[] player2ArraySort = arraySort(player2Number);

        if (player1ArraySort[0] < player2ArraySort[0]) {
            return PLAYER_2_WINS_HIGH_CARD + intNumber(player2ArraySort[0]);
        }
        return PLAYER_1_WINS_HIGH_CARD + intNumber(player1ArraySort[0]);
    }

    private int[] arraySort(int[] number) {
        Map<Integer, Integer> map = new HashMap<>(NUM_SIZE);

        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
                continue;
            }
            map.put(number[i], 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());

        Collections.sort(list, (arg0, arg1) -> arg1.getValue().compareTo(arg0.getValue()));

        int[] arrayresult = new int[list.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i] = entry.getKey();
            i++;
        }
        return arrayresult;
    }

}
