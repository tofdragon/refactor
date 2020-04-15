package com.adaptionsoft.games;

enum Category {

    POP("Pop"),

    SCIENCE("Science"),

    SPORTS("Sports"),

    ROCK("Rock"),

    BLUES("Blues"),

    HISTORY("History");

    private String name;

    public String getName() {
        return this.name;
    }

    Category(final String name) {
        this.name = name;
    }
}
