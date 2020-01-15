package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

/**
 * @author sunjing
 */
public final class GameRunner {

    public static void main(String[] args) {
        playGame(new Random());
    }

    public static void playGame(Random rand) {
        Game aGame = createGame();
        boolean notAWinner = play(rand, aGame);
        while (notAWinner) {
            notAWinner = play(rand, aGame);
        }
    }

    private static Game createGame() {
        Game game = new Game();
        game.add("Chet");
        game.add("Pat");
        game.add("Sue");
        return game;
    }

    private static boolean play(Random rand, Game aGame) {
        aGame.roll(rand.nextInt(5) + 1);

        if (rand.nextInt(9) == 7) {
            return aGame.wrongAnswer();
        }
        return aGame.wasCorrectlyAnswered();
    }

}
