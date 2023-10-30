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

import com.nandanarafiardika.aplikasispp.Adapter.ListAccountPetugasAdapter;
import com.nandanarafiardika.aplikasispp.Model.AccountPetugas;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;
import com.nandanarafiardika.aplikasispp.rest.ApiClient;
import com.nandanarafiardika.aplikasispp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AccountPetugasFragment extends Fragment {
    ApiInterface mApiInterface;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_petugas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_account_petugas);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        data();
    }

    public void data() {
        Call<ServerResponse> AccountPetugasCall = mApiInterface.getPetugas();
        AccountPetugasCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response) {
                List<AccountPetugas> AccountPetugasList = response.body().getPetugas();
                Log.d("Retrofit Get", "Jumlah data Petugas: " + String.valueOf(AccountPetugasList.size()));
                ListAccountPetugasAdapter listAccountPetugasAdapter = new ListAccountPetugasAdapter(AccountPetugasList);
                mRecyclerView.setAdapter(listAccountPetugasAdapter);
//                //Onclick
//                listAccountPetugasAdapter.setOnItemClickCallback(data -> showSelectedCoffeeDrink(data));
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