package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class ValidateAccountRequest {
    @SerializedName("code")
    private String code;

    public ValidateAccountRequest() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
