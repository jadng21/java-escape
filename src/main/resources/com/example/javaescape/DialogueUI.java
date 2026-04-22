package com.example.javaescape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Vbox;
import javafx.util.Duration;


public class DialogueUI {
    private Vbox vuePrincipale;
    private Label labelNom;
    private Label labelTexte;
    private ImageView imagePersonnage;
    private Timeline timeline;

    public DialogueUI() {
       vuePrincipale = new Vbox(10);
       labelNom = new Label ();
       labelNom.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");

       labelTexte = new Label();
       labelTexte.setWrapText(true);

       imagePersonnage = new ImageView();
       imagePersonnage.setHeight(200);
       imagePersonnage.setPreserveRatio(true);

       vuePrincipale.getChildren().addAll(imagePersonnage, labelNom, labelTexte);
    }

    public void printDialogue(Dialogue dialogue) {
        labelNom.setTexte(dialogue.getPersonnage());

        try {
            Image img = new Image(getClass().getResourceAsStream(dialogue.getImagePath()));
            imagePersonnage.setImage(img);
        } catch (Exception e) {
            System.out.println("Image non trouvée : " + dialogue.getImagePath());
        }
        animerTexte(dialogue.getTexte());
    }
    private void animerTexte(String texteComplet) {
        if (timeline != null) timeline.stop();

        labelTexte.setText("");
        timeline = new Timeline();


        for (int i = 0; i < texteComplet.length(); i++) {
            final String sousTexte = texteComplet.substring(0, i + 1);
            KeyFrame kf = new KeyFrame(Duration.millis(30 * i), e -> labelTexte.setText(sousTexte));
            timeline.getKeyFrames().add(kf);
        }
        timeline.play();
    }
    public VBox getVue() {
        return vuePrincipale;
    }

}