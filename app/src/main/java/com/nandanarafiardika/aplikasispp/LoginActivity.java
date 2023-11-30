package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.nandanarafiardika.aplikasispp.Auth.AuthManager;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username, et_password;
    private Button btn_submit;
    ApiInterface apiInterface;
    AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        authManager = new AuthManager(this);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_submit = (Button) findViewById(R.id.btn_login_submit);

        btn_submit.setOnClickListener(view -> {
            Login(et_username.getText().toString(), et_password.getText().toString());
        });
    }

    public void Login(String nis, String password) {
        Call<ServerResponse> AccountSiswaCall = apiInterface.loginSiswa(nis, password);
        AccountSiswaCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                AccountSiswa accountSiswa = response.body().getSiswaWithId();
                authManager.saveAccessToken(accountSiswa.getId());
                Intent i = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(i);
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
}