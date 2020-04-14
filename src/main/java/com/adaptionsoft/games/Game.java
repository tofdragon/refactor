package com.adaptionsoft.games;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private List<Player> players = new LinkedList<>();

    private Questions questions;

    private int currentPlayer = 0;

    public Game() {
        questions = new Questions(50);
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + howManyPlayers());
        return true;
    }

    private int howManyPlayers() {
        return players.size();
    }

    public boolean roll(int roll) {
        System.out.println(currentPlayer().name() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                currentPlayer().goOutInPenaltyBox();

                movePlayerAndAskQuestion(roll);
                return false;
            }

            System.out.println(currentPlayer().name() + " is not getting out of the penalty box");
            return true;
        }

        movePlayerAndAskQuestion(roll);
        return false;
    }

    private Player currentPlayer() {
        return players.get(currentPlayer);
    }

    private void movePlayerAndAskQuestion(int roll) {
        changePlaceOfCurrentPlayer(roll);

        System.out.println(currentPlayer().name() + "'s new location is " + currentPlayer().place());
        System.out.println("The category is " + questions.category(currentPlayer().place()));

        questions.askQuestion(currentPlayer().place());
    }

    private void changePlaceOfCurrentPlayer(int roll) {
        Player player = currentPlayer();
        player.changePlace(roll);

        if (player.place() > 11) {
            player.changePlace(-12);
        }
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer().isInPenaltyBox()) {
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer().addPurse();
        return !didPlayerWin();
    }

    void goNextPlayer() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) {
            currentPlayer = 0;
        }
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");

        currentPlayer().goInPenaltyBox();

        return true;
    }

    private boolean didPlayerWin() {
        return currentPlayer().purse() == 6;
    }
}
