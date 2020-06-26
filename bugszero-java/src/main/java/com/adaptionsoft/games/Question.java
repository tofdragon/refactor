package com.adaptionsoft.games;

import java.util.LinkedList;

/**
 *
 * @author sunjing
 */
public class Question {

    private LinkedList names = new LinkedList();

    Question(String category) {
        create(category);
    }

    private void create(String category) {
        for (int i = 0; i < 50; i++) {
            names.addLast(category + " Question " + i);
        }
    }

    void removeQuestion() {
        System.out.println(names.removeFirst());
    }
}
