package bowling;

/**
 * @author sunjing21
 */
final class ScoreResponse {

    private Boolean match;

    private Integer score;

    private Integer num;

    private ScoreResponse() {
        this.score = 0;
        this.num = 0;
        this.match = false;
    }

    static ScoreResponse createWithNum(Integer score) {
        ScoreResponse scoreResponse = new ScoreResponse();
        scoreResponse.score = score;
        scoreResponse.num = 1;
        scoreResponse.match = true;
        return scoreResponse;
    }

    static ScoreResponse createNoNum(Integer score) {
        ScoreResponse scoreResponse = new ScoreResponse();
        scoreResponse.score = score;
        scoreResponse.match = true;
        return scoreResponse;
    }

    static ScoreResponse createNoMatch() {
        return new ScoreResponse();
    }

    Integer score() {
        return score;
    }

    Integer num() {
        return num;
    }

    public Boolean match() {
        return match;
    }
}
