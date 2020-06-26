package com.adaptionsoft.games;

/**
 * @author sj
 */
public class Game {

	private Players players = new Players();

    private Questions questions = new Questions();

	private int currentPlayer = 0;

	public Game(){
		questions.create();
    }

	public boolean add(String playerName) {
		players.addPlayer(playerName);
		return true;
	}

	public void roll(int roll) {
		System.out.println(currentPlayer().getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		if (currentPlayer().notInPenaltyBox()) {
			movePlayerAndAskQuestion(roll);
			return;
		}

		if (roll % 2 != 0) {
			currentPlayer().goOutInPenaltyBox();

			System.out.println(currentPlayer().getName() + " is getting out of the penalty box");
			movePlayerAndAskQuestion(roll);
			return;
		}
		System.out.println(currentPlayer().getName() + " is not getting out of the penalty box");

	}

	private Player currentPlayer() {
		return players.of(currentPlayer);
	}

	private void movePlayerAndAskQuestion(int roll) {
		currentPlayer().setPlace(currentPlayer().getPlace() + roll);
		if (currentPlayer().getPlace() > 11){
			currentPlayer().setPlace(currentPlayer().getPlace() - 12);
		}

		System.out.println(currentPlayer().getName() + "'s new location is " + currentPlayer().getPlace());
		questions.askQuestion(currentPlayer().getPlace());
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayer().inPenaltyBox()){
			goNextPlayer();
			return true;
		} else {
			System.out.println("Answer was corrent!!!!");
			currentPlayer().incrementPurse();
			System.out.println(currentPlayer().getName() + " now has " + currentPlayer().getPurse() + " Gold Coins.");

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

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer().getName() + " was sent to the penalty box");
		currentPlayer().goInPenaltyBox();

		goNextPlayer();
		return true;
	}

	private boolean didPlayerWin() {
		return currentPlayer().getPurse() != 6;
	}
}
