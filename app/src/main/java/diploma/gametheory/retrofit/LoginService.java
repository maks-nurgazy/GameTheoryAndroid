package diploma.gametheory.retrofit;



import diploma.gametheory.models.Message;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginService {
    @GET("/isValidUser")
    Call<Message> basicLogin();
}