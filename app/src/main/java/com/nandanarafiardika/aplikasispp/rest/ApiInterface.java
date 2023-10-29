package com.nandanarafiardika.aplikasispp.rest;

import com.nandanarafiardika.aplikasispp.Model.AccountSiswaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("siswa")
    Call<AccountSiswaResponse> getSiswa();

}
