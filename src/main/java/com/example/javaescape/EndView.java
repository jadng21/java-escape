package com.example.javaescape;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EndView {

    public static VBox getEcranVictoire() {
        VBox vue = new VBox(20); // Attention au grand B ici !
        vue.setAlignment(Pos.CENTER);
        vue.setStyle("-fx-background-color: #2ecc71;");

        Label titre = new Label("VICTOIRE !");
        titre.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label dialogueChef = new Label("Chef : Tu l'as fait... Tu as réussi à désamorcer la bombe et à sauver la ville.\nGrâce à toi, des vies ont été sauvées aujourd'hui.");
        dialogueChef.setWrapText(true);
        dialogueChef.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-text-alignment: center;");

        vue.getChildren().addAll(titre, dialogueChef);
        return vue;
    }

    public static VBox getEcranDefaite() {
        VBox vue = new VBox(20);
        vue.setAlignment(Pos.CENTER);
        vue.setStyle("-fx-background-color: #e74c3c;");

        Label titre = new Label("BOOM !");
        titre.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label message = new Label("L'échec est total. La bombe a explosé.\nLa ville a été détruite. On est tous très déçus !");
        message.setWrapText(true);
        message.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-text-alignment: center;");

        vue.getChildren().addAll(titre, message);
        return vue;
    }
}