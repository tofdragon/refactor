package game.strategy;

import game.Player;

/**
 * @author sunjing
 */
public class StraightFlushCompareStrategy extends AbstractCompareStrategy{

    @Override
    public String compare(String player1, String player2) {
        Player player = new Player();

        int[] player1Number = player.strNumber(player1);
        int[] player2Number = player.strNumber(player2);

        return sameStraightFlush(player1Number, player2Number);
    }

    private String sameStraightFlush(int[] player1Number, int[] player2Number) {
        return compareResult(player1Number[0],  player2Number[0]);
    }
}
