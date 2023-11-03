package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class ServerResponse {
    private String message;
    List<AccountSiswa> siswa;
    List<AccountPetugas> petugas;
    List<Pembayaran> transaksi;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AccountSiswa> getSiswa() {
        return siswa;
    }

    public void setSiswa(List<AccountSiswa> siswa) {
        this.siswa = siswa;
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
