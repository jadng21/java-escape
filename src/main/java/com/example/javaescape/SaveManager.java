package com.example.javaescape;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveManager {
    private static final String FICHIER_SAUVEGARDE = "savegame.json";
    private static final Gson gson = new Gson();

    public static void sauvegarder(GameState etat) {
        try (FileWriter writer = new FileWriter(FICHIER_SAUVEGARDE)) {
            gson.toJson(etat, writer);
            System.out.println("Partie sauvegardée avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur de sauvegarde: " + e.getMessage());
        }
    }

    public static GameState charger() {
        try (FileReader reader = new FileReader(FICHIER_SAUVEGARDE)) {
            return gson.fromJson(reader, GameState.class);
        } catch (Exception e) {
            return null;
        }
    }

}
