package com.adaptionsoft.games;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author sunjing
 */
public class Questions {

    private final String POP_QUESTION = "Pop";
    private final String SCIENCE_QUESTION = "Science";
    private final String SPORTS_QUESTION = "Sports";
    private final String ROCK_QUESTION = "Rock";
    private final String BLUES_QUESTION = "Blues";
    private final String HISTORY_QUESTION = "History";

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

    private void removeQuestion(Category currentCategory) {
        currentCategoryToQuestion.get(currentCategory).removeQuestion();
    }

    private void removeQuestion(int currentPlace) {
        Category currentCategory = currentCategory(currentPlace);
        System.out.println("The category is " + currentCategory.getName());
        removeQuestion(currentCategory);
    }

    private Category currentCategory(int currentPlace) {
        if (currentPlace % 6 == 0) {
            return Category.POP;
        }

        if (currentPlace % 6 == 1) {
            return Category.SCIENCE;
        }

        if (currentPlace % 6 == 2) {
            return Category.SPORTS;
        }

        if (currentPlace % 6 == 3) {
            return Category.ROCK;
        }

        if (currentPlace % 6 == 4) {
            return Category.BLUES;
        }

        return Category.HISTORY;
    }
}
