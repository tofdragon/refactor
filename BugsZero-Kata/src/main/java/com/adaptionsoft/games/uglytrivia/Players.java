package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏所有玩家
 *
 * @author sunjing
 */
final class Players {

    private List<Player> players = new ArrayList<>();

    private int currentPlayer = 0;

    private Players() {
    }

    static Players create() {
        return new Players();
    }

    void add(String playerName) {
        players.add(Player.create(playerName));
    }

    int size() {
        return players.size();
    }

    void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }

    Player currentPlayer() {
        return players.get(currentPlayer);
    }
}
