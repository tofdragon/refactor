package game.strategy;

/**
 * @author sunjing
 */
public interface CompareStrategy {

    String PLAYER_1_WINS = "player1 wins - ";
    String PLAYER_2_WINS = "player2 wins - ";
    String PLAYER_2_WINS_HIGH_CARD = "player2 wins - high card:";
    String PLAYER_1_WINS_HIGH_CARD = "player1 wins - high card:";
    String TIE = "tie";
    int NUM_SIZE = 5;

    /**
     * 比较结果
     * @param player1 玩家1
     * @param player2 玩家2
     * @return 结果
     */
    String compare(String player1, String player2);
}
