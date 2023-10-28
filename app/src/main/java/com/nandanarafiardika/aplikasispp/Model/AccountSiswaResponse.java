package com.nandanarafiardika.aplikasispp.Model;

import java.util.List;

public class AccountSiswaResponse {
    private String status;
    private String message;
    List<AccountSiswa> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AccountSiswa> getData() {
        return data;
    }

    public void setData(List<AccountSiswa> data) {
        this.data = data;
    }
}
