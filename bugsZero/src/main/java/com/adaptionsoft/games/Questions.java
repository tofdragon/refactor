package com.adaptionsoft.games;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class Questions {

    private Map<String, LinkedList<String>> categoryToQuestion = new HashMap<>();

    void create() {
        for (Category category : Category.values()) {
            LinkedList<String> questions = new LinkedList<>();
            for (int i = 0; i < 50; i++) {
                questions.addLast(category.getName() + " Question " + i);
            }
            categoryToQuestion.put(category.getName(), questions);
        }
    }

    String removeQuestionFirst(Category category) {
        return categoryToQuestion.get(category.getName()).removeFirst();
    }
}
