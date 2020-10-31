package game.strategy;

import game.Player;

/**
 * @author sunjing
 */
public class TwoPairCompareStrategy extends AbstractCompareStrategy {

    @Override
    public String compare(String player1, String player2) {
        Player player = new Player();

        int[] player1Number = player.strNumber(player1);
        int[] player2Number = player.strNumber(player2);
        return sameTwoPair(player1Number, player2Number);
    }

    private String sameTwoPair(int[] player1Number, int[] player2Number) {
        int[] player1Repeat = noOrRepeatNumber(player1Number, 0);
        int[] player2Repeat = noOrRepeatNumber(player2Number, 0);
        int[] player1NoRepeat = noOrRepeatNumber(player1Number, 1);
        int[] player2NoRepeat = noOrRepeatNumber(player2Number, 1);

        if (player1Repeat[0] < player2Repeat[0]) {
            return PLAYER_2_WINS_HIGH_CARD + intNumber(player2Repeat[0]);
        }

        if (player1Repeat[0] > player2NoRepeat[0]) {
            return PLAYER_1_WINS_HIGH_CARD + intNumber(player1Repeat[0]);
        }

        return compareResult(player1NoRepeat[0], player2NoRepeat[0]);
    }
}
