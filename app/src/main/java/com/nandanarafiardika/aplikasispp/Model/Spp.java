package com.nandanarafiardika.aplikasispp.Model;

public class Spp {
    private String id;
    private String tahunAjarId;
    private String spp;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTahunAjarId() {
        return tahunAjarId;
    }

    public void setTahunAjarId(String tahunAjarId) {
        this.tahunAjarId = tahunAjarId;
    }

    public String getSpp() {
        return spp;
    }

    public void setSpp(String spp) {
        this.spp = spp;
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

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Spp (String id, String tahunAjarId, String spp, String createdAt, String updatedAt, String deletedAt) {
        this.id = id;
        this.tahunAjarId = tahunAjarId;
        this.spp = spp;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
