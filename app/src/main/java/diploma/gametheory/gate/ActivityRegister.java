package diploma.gametheory.gate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;
import java.util.Map;

import diploma.gametheory.R;
import diploma.gametheory.main.MainActivity;
import diploma.gametheory.models.Message;
import diploma.gametheory.retrofit.RegisterService;
import diploma.gametheory.retrofit.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRegister extends AppCompatActivity {

    ProgressBar progressBar;
    Button btnRegister;
    EditText etFirstName,etLastName,etUserName,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progress_bar);
        btnRegister = findViewById(R.id.btn_register);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String userName = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();


                Map<String,String> data = new HashMap<>();
                data.put("firstName",firstName);
                data.put("lastName",lastName);
                data.put("userName",userName);
                data.put("password",password);


                RegisterService registerService =
                        ServiceGenerator.createService(RegisterService.class);
                Call<Message> call = registerService.registerUser(data);
                call.enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(@NonNull Call<Message> call, @NonNull Response<Message> response) {
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful()) {
                            Message message = response.body();
                            if (message != null) {
                                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                                intent.putExtra("message",message.getUserName());
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            // error response, no access to resource?
                            System.out.println(response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Message> call, @NonNull Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        // something went completely south (like no internet connection)

                        if (t.getMessage() != null) {
                            Log.d("Error", t.getMessage());
                        }

                    }
                });



            }
        });

    }

    public void viewLoginClicked(View view) {
        onBackPressed();
    }
}
