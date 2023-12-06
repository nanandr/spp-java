package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class ServerResponse {
    private String message;
    AccountSiswa user;
    List<AccountSiswa> listSiswa;
    List<AccountPetugas> petugas;
    List<Pembayaran> transaksi;
    UserPost userPost;

    public UserPost getUserPost() {
        return userPost;
    }

    public void setUserPost(UserPost userPost) {
        this.userPost = userPost;
    }

    public AccountSiswa getSiswaWithId() {
        return user;
    }

    public void setSiswaWithId(AccountSiswa user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AccountSiswa> getSiswa() {
        return listSiswa;
    }

    public void setSiswa(List<AccountSiswa> listSiswa) {
        this.listSiswa = listSiswa;
    }

    public List<AccountPetugas> getPetugas() {
        return petugas;
    }

    public void setPetugas(List<AccountPetugas> petugas) {
        this.petugas = petugas;
    }

    public List<Pembayaran> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(List<Pembayaran> transaksi) {
        this.transaksi = transaksi;
    }
}
