package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nandanarafiardika.aplikasispp.Auth.AuthManager;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.UserPost;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Rest.ApiClient;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username, et_password;
    private Button btn_submit;
    ApiInterface apiInterface;
    AuthManager authManager;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        authManager = new AuthManager(this);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_submit = (Button) findViewById(R.id.btn_login_submit);

        btn_submit.setOnClickListener(view -> {
            Login(et_username.getText().toString().trim(), et_password.getText().toString().trim());
        });
    }

    public void Login(String nis, String password) {

        if (nis.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "NIS dan Password harus di isi", Toast.LENGTH_SHORT).show();
            return;
        }
        UserPost userPost = new UserPost(nis, password);

        Call<ServerResponse> loginCall = apiInterface.loginSiswa(userPost);
        loginCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if (response != null && response.isSuccessful()) {
                    if (response.body() != null) {
                        AccountSiswa accountSiswa = response.body().getSiswaWithId();
//                        Toast.makeText(LoginActivity.this, accountSiswa.getToken(), Toast.LENGTH_SHORT).show();
                        authManager.saveAccessToken(accountSiswa.getToken());
                        Intent i = new Intent(LoginActivity.this, UserActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Response body is null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (response != null && response.errorBody() != null) {
                        try {
                            String errorBody = response.errorBody().string();
                            Log.e("LoginError", "Error response body: " + errorBody);
                            Toast.makeText(LoginActivity.this, errorBody, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(t.getMessage());
                builder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}