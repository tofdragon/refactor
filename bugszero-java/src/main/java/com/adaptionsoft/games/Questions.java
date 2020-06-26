package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
public class Questions {

    private List<Question> questions = new ArrayList<>();

    void create() {
        for (Category category : Category.values()) {
            questions.add(new Question(category));
        }
    }

    void askQuestion(int place) {
        Category category = categoryOf(place);
        questions.stream().filter(question -> question.equalsCategory(category)).findAny().get().removeQuestion();
    }

    private Category categoryOf(int place) {
        Category currentCategory = Category.values()[place % Category.values().length];
        System.out.println("The category is " + currentCategory.getName());
        return currentCategory;
    }
}
