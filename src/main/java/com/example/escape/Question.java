package com.example.escape;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Question {
    private String question;
    private String correct_answer;
    private String difficulty;
    private String category;
    private List<String> options;

    public Question(JSONObject jsonQuestion) {
        this.question = QuizApi.decodeHtml(jsonQuestion.getString("question"));
        this.correct_answer = QuizApi.decodeHtml(jsonQuestion.getString("correct_answer"));
        this.difficulty = QuizApi.decodeHtml(jsonQuestion.getString("difficulty"));
        this.category = QuizApi.decodeHtml(jsonQuestion.getString("category"));

        this.options = new ArrayList<>();
        this.options.add(this.correct_answer);

        JSONArray incorrect_answers = jsonQuestion.getJSONArray("incorrect_answers");
        for (int i = 0; i < incorrect_answers.length(); i++) {
            this.options.add(QuizApi.decodeHtml(incorrect_answers.getString(i)));
        }

        Collections.shuffle(this.options);
    }

    public boolean verifAnswer(String options) {
        return options != null && options.equals(correct_answer);
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }
}