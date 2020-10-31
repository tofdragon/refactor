package bowling;

/**
 * @author sunjing
 */
final class CommonScoreStrategy implements ScoreStrategy {

    @Override
    public ScoreResponse score(int[] rolls, int num) {
        return ScoreResponse.createWithNum(rolls[num] + rolls[num + 1]);
    }
}
