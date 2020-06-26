package com.adaptionsoft.games;

import java.util.LinkedList;

/**
 *
 * @author sunjing
 */
public class Question {

    private LinkedList names = new LinkedList();

    private Category category;

    public Question(Category category) {
        this.category = category;
        create(category);
    }

    private void create(Category category) {
        for (int i = 0; i < 50; i++) {
            names.addLast(category.getName() + " Question " + i);
        }
    }

    void removeQuestion() {
        System.out.println(names.removeFirst());
    }

    boolean equalsCategory(Category category) {
        return this.category == category;
    }
}
