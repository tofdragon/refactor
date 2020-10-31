package game.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import game.Player;

/**
 * @author sunjing
 */
public class ThreeOfKindCompareStrategy extends AbstractCompareStrategy {

    @Override
    public String compare(String player1, String player2) {
        Player player = new Player();

        int[] player1Number = player.strNumber(player1);
        int[] player2Number = player.strNumber(player2);

        return sameThreeOfKind(player1Number, player2Number);
    }

    private String sameThreeOfKind(int[] player1Number, int[] player2Number) {
        int[] player1Repeat = noOrRepeatNumber(player1Number, 0);
        int[] player2Repeat = noOrRepeatNumber(player2Number, 0);

        if (player1Repeat[0] < player2Repeat[0]) {
            return PLAYER_2_WINS_HIGH_CARD + intNumber(player2Repeat[0]);
        }
        return PLAYER_1_WINS_HIGH_CARD + intNumber(player1Repeat[0]);
    }
}
