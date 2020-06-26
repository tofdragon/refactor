
package com.adaptionsoft.games;

import java.util.Random;

/**
 * @author sj
 */
public class GameRunner {

	public static void main(String[] args) {
		Game aGame = new Game();
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		aGame.playGame(new Random());
	}
}
