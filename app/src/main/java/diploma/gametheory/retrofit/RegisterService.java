package diploma.gametheory.retrofit;


import java.util.Map;

import diploma.gametheory.models.Message;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterService {

    @FormUrlEncoded
    @POST("register")
    Call<Message> registerUser(@FieldMap Map<String, String> data);
}
