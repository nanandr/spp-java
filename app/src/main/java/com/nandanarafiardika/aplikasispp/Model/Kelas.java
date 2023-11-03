package com.nandanarafiardika.aplikasispp.Model;

public class Kelas {
    private String namaKelas;
    private String tahunAjar;

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getTahunAjar() {
        return tahunAjar;
    }

    public void setTahunAjar(String tahunAjar) {
        this.tahunAjar = tahunAjar;
    }

    public Kelas (String namaKelas, String tahunAjar) {
        this.namaKelas = namaKelas;
        this.tahunAjar = tahunAjar;
    }
}
