package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nandanarafiardika.aplikasispp.Auth.AuthManager;

public class ProfileActivity extends AppCompatActivity {
    TextView tvNama, tvNis, tvKelas;
    ImageButton btnClose;
    LinearLayout btnLogout;
    AuthManager authManager;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        authManager = new AuthManager(this);

        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvNis = (TextView) findViewById(R.id.tv_nisn);
        tvKelas = (TextView) findViewById(R.id.tv_kelas);
        btnClose = (ImageButton) findViewById(R.id.btn_close);
        btnLogout = (LinearLayout) findViewById(R.id.linear_btn_logout);

        Intent intent = getIntent();
        if (intent != null) {
            String nama = intent.getStringExtra("nama");
            String nis = intent.getStringExtra("nis");
            String kelas = intent.getStringExtra("kelas");

            tvNama.setText(nama);
            tvNis.setText(nis);
            tvKelas.setText(kelas);
        }

        btnClose.setOnClickListener(view -> {
            Intent i = new Intent(this, UserActivity.class);
            startActivity(i);
            finish();
        });

        btnLogout.setOnClickListener(view -> {
            authManager.clearAccessToken();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
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