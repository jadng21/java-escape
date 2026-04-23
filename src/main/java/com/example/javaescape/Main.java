package com.example.javaescape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Main extends Application {
        @Override
        public void start(Start stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuView.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 800, 600);

            stage.setTitle("Java Escape Game - Alerte à la bombe !")
            stage.setScene(scene);
            stage.show();
        }

        public  static void main(String[] args) {

            launch();
        }
}