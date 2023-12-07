package com.nandanarafiardika.aplikasispp.Rest;

import com.nandanarafiardika.aplikasispp.Model.UserPost;
import com.nandanarafiardika.aplikasispp.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("siswa")
    Call<ServerResponse> getSiswa();

    @GET("siswa/{id}")
    Call<ServerResponse> getSiswaWithId(@Path("id") String id);

    @GET("pembayaran/siswa")
    Call<ServerResponse> getSiswaWithToken(@Header("Authorization") String accessToken, @Query("tahun") String tahun );

    @POST("auth/login/siswa")
    Call<ServerResponse> loginSiswa(@Body UserPost userPost);

    @GET("petugas")
    Call<ServerResponse> getPetugas();

    @GET("pembayaran")
    Call<ServerResponse> getPembayaran();
}
