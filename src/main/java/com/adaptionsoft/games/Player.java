package com.adaptionsoft.games;

final class Player {

    private String name;

    private int place = 0;

    private int purse = 0;

    private boolean inPenaltyBox = false;

    Player(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    int place() {
        return place;
    }

    void changePlace(int roll) {
        this.place = this.place() + roll;
    }

    int purse() {
        return purse;
    }

    void addPurse() {
        this.purse = this.purse() + 1;
        System.out.println(name() + " now has " + purse() + " Gold Coins.");
    }

    boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    void goInPenaltyBox() {
        this.inPenaltyBox = true;
        System.out.println(name() + " was sent to the penalty box");
    }

    void goOutInPenaltyBox() {
        this.inPenaltyBox = false;
        System.out.println(name() + " is getting out of the penalty box");
    }
}
