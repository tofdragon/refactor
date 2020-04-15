package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

class Game {

    private List<Player> players = new ArrayList<>();

    private Questions questions = new Questions();

    private int currentPlayer = 0;

    Game() {
        questions.create();
    }

    void add(String playerName) {
        players.add(new Player(playerName));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + howManyPlayers());
    }

    private int howManyPlayers() {
        return players.size();
    }

    boolean roll(int roll) {
        System.out.println(getCurrentPlayer().name() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (getCurrentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                getCurrentPlayer().goOutInPenaltyBox();
                System.out.println(getCurrentPlayer().name() + " is getting out of the penalty box");
                movePlayerAndAskQuestion(roll);
                return false;
            } else {
                System.out.println(getCurrentPlayer().name() + " is not getting out of the penalty box");
                return true;
            }

        } else {
            movePlayerAndAskQuestion(roll);
            return false;
        }
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void movePlayerAndAskQuestion(int roll) {
        changePlaceOfCurrentPlayer(roll);

        System.out.println(getCurrentPlayer().name() + "'s new location is " + getCurrentPlayer().place());
        System.out.println("The category is " + currentCategory().getName());
        askQuestion();
    }

    private void changePlaceOfCurrentPlayer(int roll) {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.changePlace(roll);
        if (currentPlayer.place() > 11) {
            currentPlayer.changePlace(-12);
        }
    }

    private void askQuestion() {
        System.out.println(questions.removeQuestionFirst(currentCategory()));
    }

    private Category currentCategory() {
        return Category.values()[getCurrentPlayer().place() % Category.values().length];
    }

    boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            return true;
        }
        return askCorrectlyAnswered();
    }

    private boolean askCorrectlyAnswered() {
        System.out.println("Answer was correct!!!!");
        getCurrentPlayer().increaseGoldCoin();
        System.out.println(getCurrentPlayer().name() + " now has " + getCurrentPlayer().goldCoin() + " Gold Coins.");
        return didPlayerWin();
    }

    void goNextPlayer() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) {
            currentPlayer = 0;
        }
    }

    boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().name() + " was sent to the penalty box");
        getCurrentPlayer().goInPenaltyBox();
        return true;
    }

    private boolean didPlayerWin() {
        return !(getCurrentPlayer().goldCoin() == 6);
    }
}
