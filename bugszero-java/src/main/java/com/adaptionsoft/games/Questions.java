package com.adaptionsoft.games;

import java.util.LinkedList;

/**
 *
 * @author sunjing
 */
public class Questions {

    private LinkedList popQuestions = new LinkedList();

    private LinkedList scienceQuestions = new LinkedList();

    private LinkedList sportsQuestions = new LinkedList();

    private LinkedList rockQuestions = new LinkedList();

    public void create() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void removeFirstOfPopQuestion() {
        System.out.println(popQuestions.removeFirst());
    }

    public void removeFirstOfScienceQuestion() {
        System.out.println(scienceQuestions.removeFirst());
    }

    public void removeFirstOfSportsQuestion() {
        System.out.println(sportsQuestions.removeFirst());
    }

    public void removeFirstOfRockQuestion() {
        System.out.println(rockQuestions.removeFirst());
    }

}
