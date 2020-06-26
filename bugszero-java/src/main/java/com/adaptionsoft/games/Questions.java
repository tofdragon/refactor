package com.adaptionsoft.games;

import java.util.LinkedList;

/**
 *
 * @author sunjing
 */
public class Questions {

    private final String POP_QUESTION = "Pop";
    private final String SCIENCE_QUESTION = "Science";
    private final String SPORTS_QUESTION = "Sports";
    private final String ROCK_QUESTION = "Rock";
    private final String BLUES_QUESTION = "Blues";
    private final String HISTORY_QUESTION = "History";

    private LinkedList popQuestions = new LinkedList();

    private LinkedList scienceQuestions = new LinkedList();

    private LinkedList sportsQuestions = new LinkedList();

    private LinkedList rockQuestions = new LinkedList();

    void create() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    void askQuestion(int place) {
        removeQuestion(place);
    }

    private void removeQuestion(String currentCategory) {
        if (currentCategory == POP_QUESTION) {
            removeFirstOfPopQuestion();
        }
        if (currentCategory == SCIENCE_QUESTION) {
            removeFirstOfScienceQuestion();
        }
        if (currentCategory == SPORTS_QUESTION) {
            removeFirstOfSportsQuestion();
        }
        if (currentCategory == ROCK_QUESTION) {
            removeFirstOfRockQuestion();
        }
    }

    private void removeQuestion(int currentPlace) {
        String currentCategory = currentCategory(currentPlace);
        System.out.println("The category is " + currentCategory);
        removeQuestion(currentCategory);
    }

    private String currentCategory(int currentPlace) {
        if (currentPlace % 6 == 0) {
            return POP_QUESTION;
        }

        if (currentPlace % 6 == 1) {
            return SCIENCE_QUESTION;
        }

        if (currentPlace % 6 == 2) {
            return SPORTS_QUESTION;
        }

        if (currentPlace % 6 == 3) {
            return ROCK_QUESTION;
        }

        if (currentPlace % 6 == 4) {
            return BLUES_QUESTION;
        }

        return HISTORY_QUESTION;
    }

    private void removeFirstOfPopQuestion() {
        System.out.println(popQuestions.removeFirst());
    }

    private void removeFirstOfScienceQuestion() {
        System.out.println(scienceQuestions.removeFirst());
    }

    private void removeFirstOfSportsQuestion() {
        System.out.println(sportsQuestions.removeFirst());
    }

    private void removeFirstOfRockQuestion() {
        System.out.println(rockQuestions.removeFirst());
    }

}
