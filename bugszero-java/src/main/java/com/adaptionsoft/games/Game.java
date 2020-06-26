package com.adaptionsoft.games;

/**
 * @author sj
 */
public class Game {

	private Players players = new Players();

    private Questions questions = new Questions();

	private int currentPlayer = 0;
	private boolean isGettingOutOfPenaltyBox;

	public Game(){
		questions.create();
    }

	public boolean add(String playerName) {
		players.addPlayer(playerName);
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public void roll(int roll) {
		System.out.println(currentPlayer().getName() + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (currentPlayer().inPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(currentPlayer().getName() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(currentPlayer().getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			movePlayerAndAskQuestion(roll);
		}

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
		askQuestion();
	}

	private void askQuestion() {
		questions.removeQuestion(currentPlayer().getPlace());
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayer().inPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				goNextPlayer();
				currentPlayer().incrementPurse();
				System.out.println(currentPlayer().getName() + " now has " + currentPlayer().getPurse() + " Gold Coins.");
				boolean winner = didPlayerWin();
				return winner;
			} else {
				goNextPlayer();
				return true;
			}
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
