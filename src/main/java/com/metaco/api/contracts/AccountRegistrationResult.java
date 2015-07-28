package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class AccountRegistrationResult {
    @SerializedName("apiId")
    private String apiId;
    @SerializedName("apiKey")
    private String apiKey;

    public AccountRegistrationResult() {
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
