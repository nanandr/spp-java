package com.nandanarafiardika.aplikasispp.Rest;

import com.nandanarafiardika.aplikasispp.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("siswa")
    Call<ServerResponse> getSiswa();

    @GET("siswa/{id}")
    Call<ServerResponse> getSiswaWithId(@Path("id") String id);

    @FormUrlEncoded
    @POST("/auth/login")
    Call<ServerResponse> loginSiswa(@Field("nis") String nis, @Field("password") String password);

    @GET("petugas")
    Call<ServerResponse> getPetugas();

    @GET("pembayaran")
    Call<ServerResponse> getPembayaran();
}
