package com.adaptionsoft.games;

import java.util.LinkedList;

/**
 *
 * @author sunjing
 */
public class Questions {

    LinkedList popQuestions = new LinkedList();

    public void create() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
        }
    }

    public void removeFirstOfPopQuestion() {
        System.out.println(popQuestions.removeFirst());
    }

}
