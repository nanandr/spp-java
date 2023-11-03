package com.nandanarafiardika.aplikasispp.rest;

import com.nandanarafiardika.aplikasispp.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("siswa")
    Call<ServerResponse> getSiswa();

    @GET("petugas")
    Call<ServerResponse> getPetugas();

    @GET("pembayaran")
    Call<ServerResponse> getPembayaran();
}
