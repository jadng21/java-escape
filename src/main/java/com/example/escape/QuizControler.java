package com.example.escape;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class QuizControler {
    private List<Question> questions;
    private int correct_answer_num = 0;
    private int correct_answer_index = 0;
    private static final int SCORE_MIN = 5;

    public QuizControler() {
        this.questions = new ArrayList<>();
        this.correct_answer_index = 0;
        this.correct_answer_num = 0;
    }

    public boolean loadAnswer(int num, int category, String difficulty) throws IOException, InterruptedException {
        org.json.JSONArray QuestionJson = QuizApi.GetQuestions(num, category, difficulty);

        if (QuestionJson == null || QuestionJson.length() == 0) {
            return false;
        }
        for (int i = 0; i < QuestionJson.length(); i++) {
            questions.add(new Question(QuestionJson.getJSONObject(i)));
        }
        return true;
    }

    public Question getCurrentQuestion() {
        if (correct_answer_index < questions.size()) {
            return questions.get(correct_answer_index);
        }
        return null;
    }

    public boolean checkCorrectAnswer(String answer) {
        Question current = getCurrentQuestion();
        if (current == null) return false;

        boolean isCorrect = current.verifAnswer(answer);
        if (isCorrect) {
            correct_answer_num++;
        }
        correct_answer_index++;
        return isCorrect;
    }

    public int getCorrect_answer_num() {
        return correct_answer_num;
    }

    public void reinit() {
        correct_answer_index = 0;
        correct_answer_num = 0;
        questions.clear();
    }
}