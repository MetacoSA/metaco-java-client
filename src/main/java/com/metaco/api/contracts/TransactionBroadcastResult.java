package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class TransactionBroadcastResult {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private BroadcastError error;

    public TransactionBroadcastResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BroadcastError getError() {
        return error;
    }

    public void setError(BroadcastError error) {
        this.error = error;
    }
}
