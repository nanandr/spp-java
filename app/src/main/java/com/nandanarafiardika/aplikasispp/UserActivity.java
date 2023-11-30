package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nandanarafiardika.aplikasispp.Adapter.ListAccountSiswaAdapter;
import com.nandanarafiardika.aplikasispp.Auth.AuthManager;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.Kelas;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Rest.ApiClient;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    AuthManager authManager;
    ApiInterface apiInterface;
    TextView current_user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        authManager = new AuthManager(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String id = authManager.getAccessToken();

        current_user_name = (TextView) findViewById(R.id.tv_current_user);

        getData(id);
    }

    public void getData(String id) {
        Call<ServerResponse> AccountSiswaCall = apiInterface.getSiswaWithId(id);
        AccountSiswaCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                AccountSiswa accountSiswa = response.body().getSiswaWithId();
                current_user_name.setText(accountSiswa.getNama());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                builder.setMessage(t.getMessage());
                builder.show();
            }
        });
    }
}