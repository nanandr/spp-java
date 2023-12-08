package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.nandanarafiardika.aplikasispp.Auth.AuthManager;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Rest.ApiClient;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    Handler h = new Handler();

    ApiInterface apiInterface;
    AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        authManager = new AuthManager(this);

        if (!authManager.getAccessToken().isEmpty()) {
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String accessToken = authManager.getAccessToken();
                    attemptAutoLogin(accessToken);
                }
            }, 800);
        } else {
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent s = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(s);
                    finish();
                }
            }, 800);
        }
    }
    private void attemptAutoLogin(String accessToken) {
        Call<ServerResponse> autoLoginCall = apiInterface.getSiswaWithToken("Bearer " + accessToken, "3");

        autoLoginCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if (response.isSuccessful()) {
                    ServerResponse serverResponse = response.body();
                    if (serverResponse != null) {
                        Intent i = new Intent(SplashActivity.this, UserActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        authManager.clearAccessToken();
                        Intent a = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(a);
                        finish();
                    }
                } else {
                    authManager.clearAccessToken();
                    Intent b = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(b);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(SplashActivity.this, "Periksa Koneksi Anda" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}