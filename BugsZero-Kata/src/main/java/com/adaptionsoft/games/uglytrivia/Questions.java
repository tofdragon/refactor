package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 问题
 *
 * @author sunjing
 */
final class Questions {

    private List<String> popQuestions = new LinkedList<>();

    private List<String> scienceQuestions = new LinkedList<>();

    private List<String> sportsQuestions = new LinkedList<>();

    private List<String> rockQuestions = new LinkedList<>();

    private Questions() {
    }

    static Questions create() {
        final Questions questions = new Questions();
        IntStream.range(0, 50).forEach(i -> {
            questions.addPopQuestions(i);
            questions.addScienceQuestions(i);
            questions.addSportsQuestions(i);
            questions.addRockQuestions(i);
        });
        return questions;
    }

    private void addRockQuestions(int index) {
        rockQuestions.add(getRock() + " Question " + index);
    }

    private void addSportsQuestions(int index) {
        sportsQuestions.add(getSports() + " Question " + index);
    }

    private void addScienceQuestions(int index) {
        scienceQuestions.add(getScience() + " Question " + index);
    }

    private void addPopQuestions(int index) {
        popQuestions.add(getPop() + " Question " + index);
    }

    String askQuestion(String category) {
        if (category.equals(getPop())) {
            return getPopQuestions().remove(0);
        }

        if (category.equals(getScience())) {
            return getScienceQuestions().remove(0);
        }

        if (category.equals(getSports())) {
            return getSportsQuestions().remove(0);
        }

        if (category.equals(getRock())) {
            return getRockQuestions().remove(0);
        }

        return null;
    }

    String currentCategory(int placeOfCurrentPlayer) {
        if (placeOfCurrentPlayer == 0 || placeOfCurrentPlayer == 4 || placeOfCurrentPlayer == 8) {
            return getPop();
        }

        if (placeOfCurrentPlayer == 1 || placeOfCurrentPlayer == 5 || placeOfCurrentPlayer == 9) {
            return getScience();
        }

        if (placeOfCurrentPlayer == 2 || placeOfCurrentPlayer == 6 || placeOfCurrentPlayer == 10) {
            return getScience();
        }

        return getRock();
    }

    private List<String> getPopQuestions() {
        return popQuestions;
    }

    private List<String> getScienceQuestions() {
        return scienceQuestions;
    }

    private List<String> getSportsQuestions() {
        return sportsQuestions;
    }

    private List<String> getRockQuestions() {
        return rockQuestions;
    }

    private static String getPop() {
        return "Pop";
    }

    private static String getRock() {
        return "Rock";
    }

    private static String getSports() {
        return "Sports";
    }

    private static String getScience() {
        return "Science";
    }

}
