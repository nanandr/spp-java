package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class ServerResponse {
    private String message;
    AccountSiswa siswa;
    List<AccountSiswa> listSiswa;
    List<AccountPetugas> petugas;
    List<Pembayaran> transaksi;

    public AccountSiswa getSiswaWithId() {
        return siswa;
    }

    public void setSiswaWithId(AccountSiswa siswa) {
        this.siswa = siswa;
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
