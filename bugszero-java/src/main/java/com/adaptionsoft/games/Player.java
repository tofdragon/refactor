package com.adaptionsoft.games;

/**
 *
 * @author sunjing
 */
public class Player {

    private String name;

    private int place = 0;

    private int purse = 0;

    private boolean inPenaltyBox = false;

    private Player() {

    }

    public static Player create(String name) {
        Player player = new Player();
        player.name = name;
        return player;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    int incrementPurse() {
        return purse ++;
    }

    public int getPurse() {
        return purse;
    }

    boolean inPenaltyBox() {
        return inPenaltyBox;
    }

    void goInPenaltyBox() {
        inPenaltyBox = true;
    }

    void goOutInPenaltyBox() {
        inPenaltyBox = false;
    }
}
