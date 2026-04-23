package com.example.javaescape;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class MenuController {

    @FXML
    protected void onNouvellePartie(ActionEvent event) {
        System.out.println("Lancement d'une nouvelle partie...");

        GameState nouvellePartie = new GameState();
        nouvellePartie.etapeJeu = 0;
        SaveManager.sauvegarder(nouvellePartie);

        DialogueController dialogueController = new DialogueController();
        DialogueUI dialogueUI = new DialogueUI();

        if(dialogueController.aDesDialoguesSuivants()) {
            dialogueUI.afficherDialogue(dialogueController.getDialogueSuivant());
        }

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Scene sceneActuelle = stage.getScene();

        sceneActuelle.setRoot(dialogueUI.getVue());

        sceneActuelle.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                if (dialogueController.aDesDialoguesSuivants()) {
                    dialogueUI.afficherDialogue(dialogueController.getDialogueSuivant());
                } else {
                    System.out.println("Fin de l'intro ! Passage au jeu du binôme...");
                }
            }
        });
    }

    @FXML
    protected void onReprendre() {
        GameState partieSauvegardee = SaveManager.charger();

        if (partieSauvegardee != null) {
            System.out.println("Partie chargée ! Reprise à l'étape : " + partieSauvegardee.etapeJeu);
        } else {
            System.out.println("Impossible de reprendre, aucune sauvegarde existante.");
        }
    }

    @FXML
    protected void onQuitter() {
        System.out.println("Fermeture du jeu et sauvegarde automatique...");

        GameState etatActuel = new GameState();
        etatActuel.etapeJeu = 0;
        SaveManager.sauvegarder(etatActuel);

        Platform.exit();
    }
}