package com.nandanarafiardika.aplikasispp;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandanarafiardika.aplikasispp.Adapter.ListAccountSiswaAdapter;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.Kelas;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.Rest.ApiClient;
import com.nandanarafiardika.aplikasispp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountSiswaFragment extends Fragment {
    ApiInterface mApiInterface;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_siswa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_account_siswa);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        data();
    }

    public void data() {
        Call<ServerResponse> AccountSiswaCall = mApiInterface.getSiswa();
        AccountSiswaCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                List<AccountSiswa> accountSiswaList = response.body().getSiswa();
                Log.d("Retrofit Get", "Jumlah data Siswa: " + String.valueOf(accountSiswaList.size()));

                for (AccountSiswa accountSiswa : accountSiswaList) {
                    String nama = accountSiswa.getNama();
                    String alamat = accountSiswa.getAlamat();
                    String jenisKelamin = accountSiswa.getJk();
                    String angkatan = accountSiswa.getAngkatan();
                    String hp = accountSiswa.getHp();

                    // Access the nested "kelas" object
                    List<Kelas> kelasList = accountSiswa.getKelas();
                    for (Kelas kelas : kelasList) {
                        String namaKelas = kelas.getNamaKelas();
                        String tahunAjar = kelas.getTahunAjar();

                        // Now you can use namaKelas and tahunAjar as needed
                    }
                }

                ListAccountSiswaAdapter listAccountSiswaAdapter = new ListAccountSiswaAdapter(accountSiswaList);
                mRecyclerView.setAdapter(listAccountSiswaAdapter);
//                //Onclick
//                listAccountSiswaAdapter.setOnItemClickCallback(data -> showSelectedCoffeeDrink(data));
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(t.getMessage());
                builder.show();
            }
        });
    }
}