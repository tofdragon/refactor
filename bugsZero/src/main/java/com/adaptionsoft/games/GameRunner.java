
package com.adaptionsoft.games;

import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {
        Random rand = new Random();
        playGame(rand);
    }

    static void playGame(Random rand) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        boolean notAWinner = true;

        do {
            boolean isStillInPenaltyBox = aGame.roll(rand.nextInt(5) + 1);
            boolean isWrongAnswer = rand.nextInt(9) == 7;

            if (isStillInPenaltyBox) {
                aGame.goNextPlayer();
                continue;
            }

            if (isWrongAnswer) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
            aGame.goNextPlayer();

        } while (notAWinner);
    }
}
