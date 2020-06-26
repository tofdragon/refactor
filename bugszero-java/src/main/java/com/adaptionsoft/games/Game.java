package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sj
 */
public class Game {
	private final String POP_QUESTION = "Pop";
	private final String SCIENCE_QUESTION = "Science";
	private final String SPORTS_QUESTION = "Sports";
	private final String ROCK_QUESTION = "Rock";
	List players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

	LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

	public Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public boolean add(String playerName) {
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			movePlayerAndAskQuestion(roll);
		}

	}

	private void movePlayerAndAskQuestion(int roll) {
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11){
			places[currentPlayer] = places[currentPlayer] - 12;
		}

		System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == POP_QUESTION) {
			System.out.println(popQuestions.removeFirst());
		}
		if (currentCategory() == SCIENCE_QUESTION) {
			System.out.println(scienceQuestions.removeFirst());
		}
		if (currentCategory() == SPORTS_QUESTION) {
			System.out.println(sportsQuestions.removeFirst());
		}
		if (currentCategory() == ROCK_QUESTION) {
			System.out.println(rockQuestions.removeFirst());
		}
	}


	private String currentCategory() {
		if (places[currentPlayer] == 0) {
			return POP_QUESTION;
		}
		if (places[currentPlayer] == 4) {
			return POP_QUESTION;
		}
		if (places[currentPlayer] == 8) {
			return POP_QUESTION;
		}
		if (places[currentPlayer] == 1) {
			return SCIENCE_QUESTION;
		}
		if (places[currentPlayer] == 5) {
			return SCIENCE_QUESTION;
		}
		if (places[currentPlayer] == 9) {
			return SCIENCE_QUESTION;
		}
		if (places[currentPlayer] == 2) {
			return SPORTS_QUESTION;
		}
		if (places[currentPlayer] == 6) {
			return SPORTS_QUESTION;
		}
		if (places[currentPlayer] == 10) {
			return SPORTS_QUESTION;
		}
		return ROCK_QUESTION;
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer++;
				if (currentPlayer == players.size()){
					currentPlayer = 0;
				}
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer)
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");

				boolean winner = didPlayerWin();

				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) {
					currentPlayer = 0;
				}
				return true;
			}



		} else {

			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer)
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");

			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;

			return winner;
		}
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == players.size()) {
			currentPlayer = 0;
		}
		return true;
	}


	private boolean didPlayerWin() {
		return purses[currentPlayer] != 6;
	}
}
