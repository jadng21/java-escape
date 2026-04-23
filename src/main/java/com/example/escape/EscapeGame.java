package com.example.escape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EscapeGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Escape Game");
        primaryStage.setWidth(900);
        primaryStage.setHeight(700);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}