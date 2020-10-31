package bowling;

/**
 * @author sunjing
 */
final class SpareScoreStrategy implements ScoreStrategy {

    @Override
    public ScoreResponse score(int[] rolls, int num) {
        int allCount = 10;
        if (rolls[num] + rolls[num + 1] == allCount) {
            return ScoreResponse.createWithNum(10 + rolls[num + 2]);
        }
        return ScoreResponse.createNoMatch();
    }
}
