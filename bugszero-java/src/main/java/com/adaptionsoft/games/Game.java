package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sj
 */
public class Game {

	private List players = new ArrayList();
	private int[] places = new int[6];
	private int[] purses  = new int[6];
	private boolean[] inPenaltyBox  = new boolean[6];

	private List<Player> tempPlayers = new ArrayList<>();

    private Questions questions = new Questions();

	private int currentPlayer = 0;
	private boolean isGettingOutOfPenaltyBox;

	public Game(){
		questions.create();
    }

	public boolean add(String playerName) {
	    players.add(playerName);
	    tempPlayers.add(Player.create(playerName));

	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + tempPlayers.size());
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
		return inPenaltyBox[currentPlayer];
	}

	private Object currentPlayer() {
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
		places[currentPlayer] = place;
	}

	private int placeOfCurrentPlayer() {
		return places[currentPlayer];
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
		return purses[currentPlayer]++;
	}

	private int purseOfCurrentPlayer() {
		return purses[currentPlayer];
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer() + " was sent to the penalty box");
		goInPenaltyBoxOfCurrentPlayer();

		goNextPlayer();
		return true;
	}

	private void goInPenaltyBoxOfCurrentPlayer() {
		inPenaltyBox[currentPlayer] = true;
	}

	private boolean didPlayerWin() {
		return purseOfCurrentPlayer() != 6;
	}
}
