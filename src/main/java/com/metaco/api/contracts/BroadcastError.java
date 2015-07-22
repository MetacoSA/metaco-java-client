package com.metaco.api.contracts;

public class BroadcastError {
    private String code;
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
