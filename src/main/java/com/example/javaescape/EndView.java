package com.example.javaescape;

import javafx.geometry.Pos;
import javafx.scene.control.Label;


public class EndView {
    public static Vbox getEcranVictoire() {
        Vbox vue = new Vbox(20);
        vue.setAlignment(Pos.CENTER);
        vue.setStyle("-fx-background-color: #2ecc71;");

        Label titre = new Label("VICTOIRE !");
        titre.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: white;");
    }
}