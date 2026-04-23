package com.example.escape;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONObject;
import org.json.JSONArray;

public class QuizApi {
    private static HttpClient httpClient;
    private static final String API_URL = "https://opentdb.com/api.php";

    public QuizApi() {
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public static JSONArray GetQuestions(int nombre, int categorie, String difficulte)
            throws IOException, InterruptedException {

        String urlStr = API_URL + "?amount=" + nombre
                + "&category=" + categorie
                + "&difficulty=" + difficulte
                + "&type=multiple";

        System.out.println("[INFO] Appel API: " + urlStr);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlStr))
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("[INFO] Status Code: " + httpResponse.statusCode());

        if (httpResponse.statusCode() != 200) {
            System.err.println("[Error] Code HTTP " + httpResponse.statusCode());
            return null;
        }

        String responseBody = httpResponse.body();
        JSONObject jsonResponse = new JSONObject(responseBody);
        int responseCode = jsonResponse.getInt("response_code");

        if (responseCode == 0) {
            JSONArray results = jsonResponse.getJSONArray("results");
            System.out.println("[INFO] " + results.length() + " questions reçues");
            return results;
        } else {
            System.err.println("[ERREUR] Response code API: " + responseCode);
            return null;
        }
    }

    public static JSONObject GetOneQuestion(String difficulte)
            throws IOException, InterruptedException {
        JSONArray questions = GetQuestions(1, 9, difficulte);
        if (questions != null && questions.length() > 0) {
            return questions.getJSONObject(0);
        }
        return null;
    }

    public static String decodeHtml(String text) {
        return text
                .replace("&quot;", "\"")
                .replace("&#039;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}
