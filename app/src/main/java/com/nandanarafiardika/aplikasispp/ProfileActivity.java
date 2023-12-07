package com.nandanarafiardika.aplikasispp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tvNama, tvNis, tvKelas;
    ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvNis = (TextView) findViewById(R.id.tv_nisn);
        tvKelas = (TextView) findViewById(R.id.tv_kelas);
        btnClose = (ImageButton) findViewById(R.id.btn_close);

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
        });
    }
}