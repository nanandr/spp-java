package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class Pembayaran {
    private String id;
    private String namaSiswa;
    private String namaPetugas;
    private String tanggalBayar;
    private String totalBayar;
    private String bulan;
    private Spp spp;
    private List<Kelas> kelas;
    private String createdAt;
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

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

    public Spp getSpp() {
        return spp;
    }

    public void setSpp(Spp spp) {
        this.spp = spp;
    }

    public List<Kelas> getKelas() {
        return kelas;
    }

    public void setKelas(List<Kelas> kelas) {
        this.kelas = kelas;
    }

    public Pembayaran(String id, String namaSiswa , String namaPetugas , String tanggalBayar , String totalBayar , String bulan , String createdAt , String updatedAt, Spp spp, List<Kelas> kelas) {
        this.id = id;
        this.namaSiswa = namaSiswa;
        this.namaPetugas = namaPetugas;
        this.tanggalBayar = tanggalBayar;
        this.totalBayar = totalBayar;
        this.bulan = bulan;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.spp = spp;
        this.kelas = kelas;
    }
}
