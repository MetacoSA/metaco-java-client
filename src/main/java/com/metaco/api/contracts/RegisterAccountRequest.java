package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class RegisterAccountRequest {
    @SerializedName("phone")
    private String phone;
    @SerializedName("provider_id")
    private String providerId;

    public RegisterAccountRequest() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
