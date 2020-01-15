package com.adaptionsoft.games.uglytrivia;

/**
 * @author sunjing
 */
public final class Game {

    private Players players;

    private Questions questions;

    private boolean isGettingOutOfPenaltyBox;

    public Game() {
        questions = Questions.create();
        players = Players.create();
    }

    public void add(String playerName) {
        players.add(playerName);

        println(playerName + " was added");
        println("They are player number " + players.size());
    }

    private void println(String message) {
        System.out.println(message);
    }

    public void roll(int roll) {
        println(currentPlayer().name() + " is the current player");
        println("They have rolled a " + roll);

        if (currentPlayer().isInPenaltyBox()) {
            rollWhenIsInPenaltyBox(roll);
            return;
        }
        movePlayerAndAskQuestion(roll);
    }

    private Player currentPlayer() {
        return players.currentPlayer();
    }

    private void rollWhenIsInPenaltyBox(int roll) {
        if (roll % 2 == 0) {
            println(currentPlayer().name() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
            return;
        }

        println(currentPlayer().name() + " is getting out of the penalty box");
        isGettingOutOfPenaltyBox = true;
        movePlayerAndAskQuestion(roll);
    }

    private void movePlayerAndAskQuestion(int roll) {
        currentPlayer().changePlace(roll);
        int place = currentPlayer().place();

        println(currentPlayer().name() + "'s new location is " + place);
        println("The category is " + questions.currentCategory(place));
        println(questions.askQuestion(questions.currentCategory(place)));
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer().isInPenaltyBox()) {
            return wasCorrectlyAnsweredWhenIsInPenaltyBox();
        }

        println("Answer was corrent!!!!");
        currentPlayer().purseIncrement();
        println(currentPlayer().name() + " now has " + currentPlayer().purse() + " Gold Coins.");

        boolean winner = currentPlayer().didPlayerWin();
        players.nextPlayer();

        return winner;
    }

    private boolean wasCorrectlyAnsweredWhenIsInPenaltyBox() {
        if (isGettingOutOfPenaltyBox) {
            println("Answer was correct!!!!");
            players.nextPlayer();

            currentPlayer().purseIncrement();
            println(currentPlayer().name() + " now has " + currentPlayer().purse() + " Gold Coins.");

            return currentPlayer().didPlayerWin();
        }

        players.nextPlayer();
        return true;
    }

    public boolean wrongAnswer() {
        println("Question was incorrectly answered");
        println(currentPlayer().name() + " was sent to the penalty box");
        currentPlayer().inPenaltyBox();

        players.nextPlayer();
        return true;
    }
}
