package com.example.javaescape;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class MenuController {

    @FXML
    protected void onNouvellePartie() {
        System.out.println("Lancement d'une nouvelle partie...");

    }

    @FXML
    protected void onReprendre() {
        System.out.println("Chargement de la partie sauvegardée...");
    }

    @FXML
    protected void onQuitter() {
        System.out.println("Fermeture du jeu.");
        Platform.exit();
    }
}