package com.example.escape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class QuizApplication extends Application {

        @Override
        public void start(Stage stage) throws IOException {
                URL fxmlLocation = getClass().getResource("/com/example/escape/escape-view.fxml"); // Utilisation d'un chemin absolu depuis la racine des ressources

                if (fxmlLocation == null) {
                        System.err.println("ERREUR : Le fichier escape-view.fxml est introuvable !");
                        System.err.println("Vérifiez qu'il est bien dans : src/main/resources/com/example/escape/");
                        return;
                }

                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Scene scene = new Scene(loader.load(), 700, 500);
                stage.setTitle("Escape Game");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}