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
    }

    int size() {
        return players.size();
    }

    Player player(int playerIndex) {
        return players.get(playerIndex);
    }
}
