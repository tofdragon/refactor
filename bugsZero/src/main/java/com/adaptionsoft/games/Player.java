package com.adaptionsoft.games;

final class Player {

    private String name;

    private int place = 0;

    private int goldCoin = 0;

    private boolean inPenaltyBox;

    Player(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    void changePlace(int roll) {
        this.place = this.place + roll;
    }

    int place() {
        return this.place;
    }

    int goldCoin() {
        return goldCoin;
    }

    void increaseGoldCoin() {
        goldCoin++;
    }

    boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    void goInPenaltyBox() {
        inPenaltyBox = true;
    }

    void goOutInPenaltyBox() {
        inPenaltyBox = false;
    }
}
