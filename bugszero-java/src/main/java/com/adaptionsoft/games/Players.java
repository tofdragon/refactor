package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunjing
 */
public class Players {

    private int currentPlayer = 0;

    private List<Player> players = new ArrayList<>();

    void addPlayer(String playerName) {
        players.add(Player.create(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    int size() {
        return players.size();
    }

    Player of(int playerIndex) {
        return players.get(playerIndex);
    }

    Player currentPlayer() {
        return of(currentPlayer);
    }

    void goNextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }

}
