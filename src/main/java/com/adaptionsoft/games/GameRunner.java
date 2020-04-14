package com.adaptionsoft.games;

import java.util.Random;

public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        Random rand = new Random();
        playGame(rand);
    }

    public static void playGame(Random rand) {
        Game game = new Game();

        game.add("Chet");
        game.add("Pat");
        game.add("Sue");

        do {
            boolean isStillInPenaltyBox = game.roll(rand.nextInt(5) + 1);
            boolean isWrongAnswer = rand.nextInt(9) == 7;

            if (!isStillInPenaltyBox) {
                if (isWrongAnswer) {
                    notAWinner = game.wrongAnswer();
                } else {
                    notAWinner = game.wasCorrectlyAnswered();
                }
            }
            game.goNextPlayer();
        } while (notAWinner);
    }
}
