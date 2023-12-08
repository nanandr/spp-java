package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class Transaksi {
    private String namaPetugas;
    private String tanggalBayar;
    private String totalBayar;
    private String bulan;
    private String createdAt;
    private String updatedAt;

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    public String getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(String tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Transaksi() {
        this.namaPetugas = null;
        this.tanggalBayar = null;
        this.totalBayar = "0";
        this.bulan = null;
        this.createdAt = null;
        this.updatedAt = null;
    }
}
