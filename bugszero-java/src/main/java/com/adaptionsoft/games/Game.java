package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sj
 */
public class Game {

	private List<Player> players = new ArrayList<>();

    private Questions questions = new Questions();

	private int currentPlayer = 0;
	private boolean isGettingOutOfPenaltyBox;

	public Game(){
		questions.create();
    }

	public boolean add(String playerName) {
	    players.add(Player.create(playerName));

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(currentPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (isInPenaltyBoxOfCurrentPlayer()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(currentPlayer() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(currentPlayer() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			movePlayerAndAskQuestion(roll);
		}

	}

	private boolean isInPenaltyBoxOfCurrentPlayer() {
		return tempCurrentPlayer().inPenaltyBox();
	}

	private Object currentPlayer() {
		return players.get(currentPlayer).getName();
	}

	private Player tempCurrentPlayer() {
		return players.get(currentPlayer);
	}

	private void movePlayerAndAskQuestion(int roll) {
		setPlaceOfCurrentPlayer(placeOfCurrentPlayer() + roll);
		if (placeOfCurrentPlayer() > 11){
			setPlaceOfCurrentPlayer(placeOfCurrentPlayer() - 12);
		}

		System.out.println(currentPlayer() + "'s new location is " + placeOfCurrentPlayer());
		askQuestion();
	}

	private void setPlaceOfCurrentPlayer(int place) {
		tempCurrentPlayer().setPlace(place);
	}

	private int placeOfCurrentPlayer() {
		return tempCurrentPlayer().getPlace();
	}

	private void askQuestion() {
		questions.removeQuestion(placeOfCurrentPlayer());
	}

	public boolean wasCorrectlyAnswered() {
		if (isInPenaltyBoxOfCurrentPlayer()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				goNextPlayer();
				incrementPurseOfCurrentPlayer();
				System.out.println(currentPlayer() + " now has " + purseOfCurrentPlayer() + " Gold Coins.");
				boolean winner = didPlayerWin();
				return winner;
			} else {
				goNextPlayer();
				return true;
			}
		} else {
			System.out.println("Answer was corrent!!!!");
			incrementPurseOfCurrentPlayer();
			System.out.println(currentPlayer() + " now has " + purseOfCurrentPlayer() + " Gold Coins.");

			boolean winner = didPlayerWin();
			goNextPlayer();

			return winner;
		}
	}

	private void goNextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) {
			currentPlayer = 0;
		}
	}

	private int incrementPurseOfCurrentPlayer() {
		tempCurrentPlayer().incrementPurse();
		return purseOfCurrentPlayer();
	}

	private int purseOfCurrentPlayer() {
		return tempCurrentPlayer().getPurse();
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer() + " was sent to the penalty box");
		goInPenaltyBoxOfCurrentPlayer();

		goNextPlayer();
		return true;
	}

	private void goInPenaltyBoxOfCurrentPlayer() {
		tempCurrentPlayer().goInPenaltyBox();
	}

	private boolean didPlayerWin() {
		return purseOfCurrentPlayer() != 6;
	}
}
