package com.example.escape;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class QuizControler {
    private List<Question> question;
    private int correct_answer_num = 0;
    private int correct_answer_index = 0;
    private static final int SCORE_MIN = 5;

    public QuizControler() {
        this.question = new ArrayList<>();
        this.correct_answer_index = 0;
        this.correct_answer_num = 0;
    }

    public boolean loadAnswer(int num, String category,int difficulty)throws IOException, InterruptedException {
    org.json.JSONArray QuestionJson = QuizApi.GetQuestions(num, difficulty, category);

    if (QuestionJson == null || QuestionJson.length() == 0) {
        return false;
    }
    for (int i = 0; i < QuestionJson.length(); i++) {
        question.add(new Question(QuestionJson.getJSONObject(i)));
    }
    return true;
    }

    public Question getCorrectAnswer() {
        if (correct_answer_index < question.size()) {
            return question.get(correct_answer_index);
        }
        return null;
    }
    public boolean checkCorrectAnswer(String answer) {
        Question question = getCorrectAnswer();
        if (question == null) return false;

        boolean IsCorrect = question.verifAnswer(answer);
        if (IsCorrect) {
            correct_answer_num++;
        }
        correct_answer_index++;
        return IsCorrect;
    }
    public boolean minScore() {
        return correct_answer_num >= SCORE_MIN;
    }

    public boolean nextQuestion() {
        return correct_answer_index < question.size();
    }

    public static int getScoreMin() {
        return SCORE_MIN;
    }
    public int getTotalQuestions() {
        return question.size();
    }

    public int getCorrect_answer_num() {
        return correct_answer_num;
    }



    public void reinit(){
        correct_answer_index = 0;
        correct_answer_num = 0;
        question.clear();
    }
}