package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class BroadcastError {
    @SerializedName("code")
    private String code;
    @SerializedName("reason")
    private String reason;

    public BroadcastError() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
