import com.example.escape.QuizApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;
import com.example.escape;

public class Question {
    private String enonce;
    private String answer;
    private String difficulty;
    private String category;
    private List<String> options;

    public Question(JSONObject jsonQuestion) {
        this.enonce = QuizApi.decodeHtml(
                jsonQuestion.getString("enonce")
        );
        this.answer = QuizApi.decodeHtml(
                jsonQuestion.getString("answer")
        );
        this.difficulty = QuizApi.decodeHtml(
                jsonQuestion.getString("difficulty")
        );
        this.category = QuizApi.decodeHtml(
                jsonQuestion.getString("category")
        );

        this.options = new ArrayList<>();
        this.options.add(answer);

        JSONArray false = jsonQuestion.getJSONArray("false");
        for (int i = 0; i < false.length(); i ++){
            this.options.add(QuizApi.decodeHtml(false.getString(i)));
        }

        public boolean verifAnswer(String options){
            return options != null && options.equals(answer);
        }

        public String getEnonce(){
            return enonce;
        }
        public List<String> getOptions(){
            return options;
        }
        public String getDifficulty(){
            return difficulty;
        }
        public String getCategory(){
            return category;
        }
        public String getAnswer(){
            return answer;
        }
    }
}