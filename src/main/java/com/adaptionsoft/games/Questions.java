package com.adaptionsoft.games;

import java.util.LinkedList;

final class Questions {

    private static final String POP = "Pop";

    private static final String SPORTS = "Sports";

    private static final String SCIENCE = "Science";

    private static final String ROCK = "Rock";

    private LinkedList popQuestions = new LinkedList();

    private LinkedList scienceQuestions = new LinkedList();

    private LinkedList sportsQuestions = new LinkedList();

    private LinkedList rockQuestions = new LinkedList();

    Questions(int count) {
        for (int i = 0; i < count; i++) {
            popQuestions.addLast(createPopQuestion(i));
            scienceQuestions.addLast(createScienceQuestion(i));
            sportsQuestions.addLast(createSportsQuestion(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createPopQuestion(int index) {
        return "Pop Question " + index;
    }

    private String createSportsQuestion(int index) {
        return "Sports Question " + index;
    }

    private String createScienceQuestion(int index) {
        return "Science Question " + index;
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    void askQuestion(int place) {
        if (category(place) == POP)
            System.out.println(popQuestions.removeFirst());
        if (category(place) == SCIENCE)
            System.out.println(scienceQuestions.removeFirst());
        if (category(place) == SPORTS)
            System.out.println(sportsQuestions.removeFirst());
        if (category(place) == ROCK)
            System.out.println(rockQuestions.removeFirst());
    }

    String category(int place) {
        if (place == 0 || place == 4 || place == 8) {
            return POP;
        }

        if (place == 1 || place == 5 || place == 9) {
            return SCIENCE;
        }

        if (place == 2 || place == 6 || place == 10) {
            return SPORTS;
        }

        return ROCK;
    }
}
