package com.nandanarafiardika.aplikasispp.Model;

import com.google.gson.annotations.SerializedName;

public class UserPost {
    @SerializedName("nis")
    final String nis;
    @SerializedName("password")
    final String password;

    public UserPost(String nis, String password) {
        this.nis = nis;
        this.password = password;
    }

    public String getNis() {
        return nis;
    }

    public String getPassword() {
        return password;
    }
}
