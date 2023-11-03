package com.nandanarafiardika.aplikasispp.Model;

import com.google.gson.annotations.SerializedName;

import java.lang.String;
import java.util.List;

public class AccountSiswa {
    private String id;
    private String nama;
    private String nis;
    private String alamat;
    private String jk;
    private String angkatan;
    private List<Kelas> kelas;
    private String transaksi;
    private String spp;
    private String diskon;
    private String hp;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;

    @SerializedName("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @SerializedName("nis")
    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @SerializedName("jk")
    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    @SerializedName("angkatan")
    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    @SerializedName("kelas")
    public List<Kelas> getKelas() {
        return kelas;
    }

    public void setKelas(List<Kelas> kelas) {
        this.kelas = kelas;
    }

    @SerializedName("transaksi")
    public String getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(String transaksi) {
        this.transaksi = transaksi;
    }

    @SerializedName("spp")
    public String getSpp() {
        return spp;
    }

    public void setSpp(String spp) {
        this.spp = spp;
    }

    @SerializedName("diskon")
    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    @SerializedName("hp")
    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    @SerializedName("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @SerializedName("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @SerializedName("deletedAt")
    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public AccountSiswa(String id, String nama, String nis, String jk, String angkatan, List<Kelas> kelas, String transaksi, String spp, String diskon, String hp, String createdAt, String updatedAt, String deletedAt){
        this.id = id;
        this.nama = nama;
        this.nis = nis;
        this.jk = jk;
        this.angkatan = angkatan;
        this.kelas = kelas;
        this.transaksi = transaksi;
        this.spp = spp;
        this.diskon = diskon;
        this.hp = hp;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

}
