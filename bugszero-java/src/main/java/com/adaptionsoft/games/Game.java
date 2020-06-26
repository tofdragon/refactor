package com.adaptionsoft.games;

/**
 * @author sj
 */
public class Game {

	private Players players = new Players();

    private Questions questions = new Questions();

	public Game(){
		questions.create();
    }

	public void add(String playerName) {
		players.addPlayer(playerName);
	}

	public void roll(int roll) {
		System.out.println(players.currentPlayer().getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		if (players.currentPlayer().notInPenaltyBox()) {
			movePlayerAndAskQuestion(roll);
			return;
		}

		if (roll % 2 != 0) {
			players.currentPlayer().goOutInPenaltyBox();
			System.out.println(players.currentPlayer().getName() + " is getting out of the penalty box");
			movePlayerAndAskQuestion(roll);
			return;
		}
		System.out.println(players.currentPlayer().getName() + " is not getting out of the penalty box");
	}

	private void movePlayerAndAskQuestion(int roll) {
		players.currentPlayer().move(roll);

		System.out.println(players.currentPlayer().getName() + "'s new location is " + players.currentPlayer().getPlace());
		questions.askQuestion(players.currentPlayer().getPlace());
	}

	public boolean wasCorrectlyAnswered() {
		if (players.currentPlayer().inPenaltyBox()) {
			return true;
		}
		System.out.println("Answer was corrent!!!!");
		players.currentPlayer().incrementPurse();
		System.out.println(players.currentPlayer().getName() + " now has " + players.currentPlayer().getPurse() + " Gold Coins.");
		return didPlayerWin();
	}

	void goNextPlayer() {
		players.goNextPlayer();
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.currentPlayer().getName() + " was sent to the penalty box");
		players.currentPlayer().goInPenaltyBox();

		return true;
	}

	private boolean didPlayerWin() {
		return players.currentPlayer().getPurse() != 6;
	}
}
