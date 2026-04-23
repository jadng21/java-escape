package com.example.escape;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

public class QuizViewController {

    private QuizControler quiz = new QuizControler();

    @FXML private Label labelQuestion;
    @FXML private Label labelScore;
    @FXML private Label labelFeedback;

    @FXML private Button opt1;
    @FXML private Button opt2;
    @FXML private Button opt3;
    @FXML private Button opt4;

    @FXML
    public void initialize() {
        try {
            if (quiz.loadAnswer(5, 9, "easy")) { // Chargement initial des données API manquant
                displayCurrentQuestion();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayCurrentQuestion() {
        Question q = quiz.getCurrentQuestion();
        if (q != null) {
            labelQuestion.setText(q.getQuestion());
            opt1.setText(q.getOptions().get(0));
            opt2.setText(q.getOptions().get(1));
            opt3.setText(q.getOptions().get(2));
            opt4.setText(q.getOptions().get(3));
        } else {
            labelQuestion.setText("Quiz terminé !");
        }
    }

    @FXML
    private void opt1clicked() {
        handleAnswer(opt1.getText());
    }

    @FXML
    private void opt2clicked() {
        handleAnswer(opt2.getText());
    }

    @FXML
    private void opt3clicked() {
        handleAnswer(opt3.getText());
    }

    @FXML
    private void opt4clicked() {
        handleAnswer(opt4.getText());
    }

    private void handleAnswer(String answer) {
        boolean correct = quiz.checkCorrectAnswer(answer);
        labelFeedback.setText(correct ? "Bonne réponse" : "Mauvaise réponse");
        labelScore.setText(quiz.getCorrect_answer_num() + " / 5");
        displayCurrentQuestion();
    }
}