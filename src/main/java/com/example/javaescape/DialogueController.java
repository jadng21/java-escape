package com.example.javaescape;

import java.util.LinkedList;
import java.util.Queue;

public class DialogueController {
    private Queue<Dialogue> fileDialogues;

    public DialogueController() {
        fileDialogues = new LinkedList<>();
        chargerDialoguesIntroduction();
    }

    private void chargerDialoguesIntroduction() {
        fileDialogues.add(new Dialogue("Chef", "Ecoute-moi bien.Une bombe a été placée quelque part en ville, et tout repose sur toi. ","chef.jpg"));
        fileDialogues.add(new Dialogue("Chef", "Nous n'avons pas de temps à perdre. Chaque seconde compte.", "chef.jpg"));
        fileDialogues.add(new Dialogue("Chef", "Voici la situation : tu vas devoir résoudre une série d'énigmes...", "chef.jpg"));
    }
    public boolean aDesDialoguesSuivants() {
        return !fileDialogues.isEmpty();
    }
    public Dialogue getDialogueSuivant() {
        return fileDialogues.poll();
    }
}
