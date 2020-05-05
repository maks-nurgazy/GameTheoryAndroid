package diploma.gametheory.gate;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import diploma.gametheory.R;
import diploma.gametheory.main.MainActivity;
import diploma.gametheory.models.Message;
import diploma.gametheory.retrofit.LoginService;
import diploma.gametheory.retrofit.ServiceGenerator;
import diploma.gametheory.userdetails.UserDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.cirLoginButton);
        progressBar = findViewById(R.id.progress_bar);

        btnLogin.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            String username = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            LoginService loginService =
                    ServiceGenerator.createService(LoginService.class, username, password);
            Call<Message> call = loginService.basicLogin();
            call.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(@NonNull Call<Message> call, @NonNull Response<Message> response) {
                    progressBar.setVisibility(View.GONE);
                    if (response.isSuccessful()) {
                        Message message = response.body();
                        if (message != null) {
                            System.out.println(message);

                            SharedPreferences prefs = getSharedPreferences("CREDENTIAL", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("username", username);
                            editor.putString("password", password);
                            editor.apply();

                            Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                            intent.putExtra("message", message.getUserName());
                            UserDetails.username = message.getUserName();
                            UserDetails.status = message.getRole();
                            startActivity(intent);
                        }

                    } else {
                        // error response, no access to resource?
                        System.out.println("no access to resource");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Message> call, @NonNull Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    // something went completely south (like no internet connection)
                    if (t.getMessage() != null) {
                        System.out.println("Error occurred");
                        Log.d("Error", t.getMessage());
                    }
                }
            });
        });
    }


    public void viewRegisterClicked(View view) {
        Intent intent = new Intent(this, ActivityRegister.class);
        startActivity(intent);
    }



}