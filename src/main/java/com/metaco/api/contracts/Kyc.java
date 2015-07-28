package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Kyc {
    @SerializedName("required")
    private Boolean required;

    public Kyc() {
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
