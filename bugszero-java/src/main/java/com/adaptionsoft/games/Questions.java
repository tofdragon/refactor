package com.adaptionsoft.games;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunjing
 */
public class Questions {

    private Map<Category, Question> currentCategoryToQuestion = new HashMap<>();

    void create() {
        currentCategoryToQuestion.put(Category.POP, new Question(Category.POP.getName()));
        currentCategoryToQuestion.put(Category.SCIENCE, new Question(Category.SCIENCE.getName()));
        currentCategoryToQuestion.put(Category.SPORTS, new Question(Category.SPORTS.getName()));
        currentCategoryToQuestion.put(Category.ROCK, new Question(Category.ROCK.getName()));
        currentCategoryToQuestion.put(Category.BLUES, new Question(Category.BLUES.getName()));
        currentCategoryToQuestion.put(Category.HISTORY, new Question(Category.HISTORY.getName()));
    }

    void askQuestion(int place) {
        removeQuestion(place);
    }

    private void removeQuestion(int currentPlace) {
        Category currentCategory = Category.values()[currentPlace % Category.values().length];
        System.out.println("The category is " + currentCategory.getName());
        currentCategoryToQuestion.get(currentCategory).removeQuestion();
    }
}
