package com.adaptionsoft.games.uglytrivia;

/**
 * 玩家
 *
 * @author sunjing
 */
final class Player {

    private String name;

    private int place = 0;

    private int purse = 0;

    private boolean inPenaltyBox = false;

    private Player() {
    }

    public static Player create(String playerName) {
        Player player = new Player();
        player.name = playerName;
        return player;
    }

    String name() {
        return name;
    }

    int place() {
        return place;
    }

    void changePlace(int roll){
        place = place + roll;
        if (place > 11) {
            place = place  - 12;
        }
    }

    int purseIncrement() {
        return purse++;
    }

    boolean didPlayerWin() {
        return purse != 6;
    }

    int purse() {
        return this.purse;
    }

    boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    void inPenaltyBox() {
        inPenaltyBox = true;
    }
}
