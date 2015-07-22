package com.metaco.client.contracts;

public class TransactionBroadcastResult {
    private boolean success;
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
