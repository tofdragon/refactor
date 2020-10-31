package bowling;

/**
 * @author sunjing
 */
final class StrikeScoreStrategy implements ScoreStrategy {

    @Override
    public ScoreResponse score(int[] rolls, int num) {
        int allCount = 10;
        if (rolls[num] == allCount) {
            return ScoreResponse.createNoNum(10 + rolls[num + 1] + rolls[num + 2]);
        }
        return ScoreResponse.createNoMatch();
    }
}
