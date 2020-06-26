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

    private Map<String, Question> currentCategoryToQuestion = new HashMap<>();

    void create() {
        currentCategoryToQuestion.put(POP_QUESTION, new Question(POP_QUESTION));
        currentCategoryToQuestion.put(SCIENCE_QUESTION, new Question(SCIENCE_QUESTION));
        currentCategoryToQuestion.put(SPORTS_QUESTION, new Question(SPORTS_QUESTION));
        currentCategoryToQuestion.put(ROCK_QUESTION, new Question(ROCK_QUESTION));
        currentCategoryToQuestion.put(BLUES_QUESTION, new Question(BLUES_QUESTION));
        currentCategoryToQuestion.put(HISTORY_QUESTION, new Question(HISTORY_QUESTION));
    }

    void askQuestion(int place) {
        removeQuestion(place);
    }

    private void removeQuestion(String currentCategory) {
        currentCategoryToQuestion.get(currentCategory).removeQuestion();
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
}
