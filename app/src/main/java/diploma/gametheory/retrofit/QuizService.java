package diploma.gametheory.retrofit;

import java.util.ArrayList;

import diploma.gametheory.models.Question;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuizService {
    @GET("/questions")
    Call<ArrayList<Question>> getQuestions(@Query("difficulty") String difficulty);
}
