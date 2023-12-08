package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nandanarafiardika.aplikasispp.Adapter.ListAccountSiswaAdapter;
import com.nandanarafiardika.aplikasispp.Adapter.ListTransaksiUserAdapter;
import com.nandanarafiardika.aplikasispp.Auth.AuthManager;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.Kelas;
import com.nandanarafiardika.aplikasispp.Model.Pembayaran;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Model.Transaksi;
import com.nandanarafiardika.aplikasispp.Rest.ApiClient;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    Handler h = new Handler();

    AuthManager authManager;
    ApiInterface apiInterface;
    TextView current_user_name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageButton btnProfile;
    String nama, nis, kelas;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        authManager = new AuthManager(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String token = authManager.getAccessToken();


        recyclerView = (RecyclerView) findViewById(R.id.rv_account_transaksi);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        current_user_name = (TextView) findViewById(R.id.tv_current_user);
        btnProfile = (ImageButton) findViewById(R.id.btn_profile);


        if (!authManager.getAccessToken().isEmpty()) {
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String accessToken = authManager.getAccessToken();
                    getData(accessToken);
                }
            }, 800);
        } else {
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent s = new Intent(UserActivity.this, LoginActivity.class);
                    startActivity(s);
                    finish();
                }
            }, 800);
        }

        btnProfile.setOnClickListener(view -> {
            Intent i = new Intent(this, ProfileActivity.class);
            i.putExtra("nama", nama);
            i.putExtra("nis", nis);
            i.putExtra("kelas", kelas);
            startActivity(i);
            finish();
        });
        getData(token);
    }

    public void getData(String token) {
        Call<ServerResponse> TransaksiSiswaCall = apiInterface.getSiswaWithToken("Bearer " + token, "3");
        TransaksiSiswaCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                String[] months = {"Juli", "Agustus", "September", "Oktober", "November", "Desember", "Januari", "Februari", "Maret", "April", "Mei", "Juni"};
                List<Transaksi> listPembayaran = new ArrayList<>();
                for(String month : months) {
                    Transaksi pembayaran = new Transaksi();
                    pembayaran.setBulan(month);
                    listPembayaran.add(pembayaran);
                }

                List<Pembayaran> transaksiSiswa = response.body().getTransaksi();
                for(Pembayaran transaksi : transaksiSiswa) {
                    for(Transaksi month : listPembayaran) {
                        if(transaksi.getBulan().equals(month.getBulan())) {
                            month.setTanggalBayar(transaksi.getTanggalBayar());
                            month.setTotalBayar(transaksi.getTotalBayar());
                            month.setCreatedAt(transaksi.getCreatedAt());
                            month.setUpdatedAt(transaksi.getUpdatedAt());
                        }
                    }
                }

                AccountSiswa dataSiswa = response.body().getSiswaWithId();
                nama = dataSiswa.getNama();
                nis = dataSiswa.getNis();

                for (Pembayaran pembayaran : transaksiSiswa) {
                    List<Kelas> kelasList = pembayaran.getKelas();
                    if (kelasList != null && kelasList.size() > 0) {
                        Kelas kelasModel = kelasList.get(0);
                        kelas = kelasModel.getNamaKelas();
                    } else {
                        Toast.makeText(UserActivity.this, "Kelas Tidak Tersedia", Toast.LENGTH_SHORT).show();
                    }
                }
                current_user_name.setText(dataSiswa.getNama());
                Log.d("Retrofit Get", "Jumlah data transaksi: " + String.valueOf(transaksiSiswa.size()));
                //transaksiSiswa =
                ListTransaksiUserAdapter listTransaksiUser = new ListTransaksiUserAdapter(listPembayaran);
                recyclerView.setAdapter(listTransaksiUser);
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