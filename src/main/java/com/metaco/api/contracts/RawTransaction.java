package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class RawTransaction {
    @SerializedName("raw")
    private String raw;

    public RawTransaction() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}
