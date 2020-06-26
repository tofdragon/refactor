package com.adaptionsoft.games;

/**
 * @author sunjing
 */
public enum Category {

    POP("Pop"),

    SCIENCE("Science"),

    SPORTS("Sports"),

    ROCK("Rock"),

    BLUES("Blues"),

    HISTORY("History");

    private String name;

    Category(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
