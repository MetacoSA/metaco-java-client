package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class InputsToSign {
    @SerializedName("index")
    private Integer index;
    @SerializedName("signing_address")
    private String signingAddress;

    public InputsToSign() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSigningAddress() {
        return signingAddress;
    }

    public void setSigningAddress(String signingAddress) {
        this.signingAddress = signingAddress;
    }
}
