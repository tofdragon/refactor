package game;

// Please don't modify the class name.
public class Poker {

    public static final String PLAYER_1_WINS = "player1 wins - ";
    public static final String PLAYER_2_WINS = "player2 wins - ";

    // Please don't modify the signature of this method.
    // Please keep the result output format.
    public String compairResult(String player1, String player2) {
        Player player = new Player();
        CardType player1Type = player.judgeType(player1);
        CardType player2Type = player.judgeType(player2);

        if (player1Type.getSize() > player2Type.getSize()) {
            return PLAYER_1_WINS + player1Type;
        }

        if (player1Type.getSize() < player2Type.getSize()) {
            return PLAYER_2_WINS + player2Type;
        }

        CompareStrategyFactory compareStrategyFactory = new CompareStrategyFactory();
        return compareStrategyFactory.compareStrategy(player1Type).compare(player1, player2);
    }
}