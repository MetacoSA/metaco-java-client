package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class RegisterAccountRequest {
    @SerializedName("phone")
    private String phone;

    public RegisterAccountRequest() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
