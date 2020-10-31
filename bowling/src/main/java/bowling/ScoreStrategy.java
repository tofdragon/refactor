package bowling;

/**
 * @author sunjing
 */
public interface ScoreStrategy {

    /**
     * 分数计算
     *
     * @param rolls 投的球
     * @param num   当前投递次数
     * @return 响应
     */
    ScoreResponse score(int[] rolls, int num);
}
