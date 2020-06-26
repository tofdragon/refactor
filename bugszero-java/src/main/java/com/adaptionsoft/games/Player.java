package com.adaptionsoft.games;

/**
 *
 * @author sunjing
 */
public class Player {

    private String name;

    private int place = 0;

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
}
