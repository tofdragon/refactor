package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunjing
 */
public class Players {

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
}
