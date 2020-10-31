package bowling;

import java.util.LinkedList;
import java.util.List;

// Please don't modify the class name.
public class Bowling {

    private final int[] rolls = new int[21];

    private int rollsIndex = 0;

    // Please don't modify the signature of this method.
    public void roll(int n) {
        this.rolls[rollsIndex] = n;
        this.rollsIndex++;
    }

    // Please don't modify the signature of this method.
    public int getScore() {
        int score = 0;
        int current = 0;

        for (int num = 0; num < this.rollsIndex; num++) {
            if (current == 10) {
                break;
            }

            ScoreResponse scoreResponse = scoreResponse(rolls, num);
            score += scoreResponse.score();
            num += scoreResponse.num();
            current++;
        }

        return score;
    }

    private ScoreResponse scoreResponse(final int[] rolls, int num) {
        List<ScoreStrategy> scoreStrategies = new LinkedList<>();
        scoreStrategies.add(new StrikeScoreStrategy());
        scoreStrategies.add(new SpareScoreStrategy());
        scoreStrategies.add(new CommonScoreStrategy());

        for (ScoreStrategy scoreStrategy : scoreStrategies) {
            ScoreResponse scoreResponse = scoreStrategy.score(rolls, num);
            if (scoreResponse.match()) {
                return scoreResponse;
            }
        }
        return null;
    }
}
