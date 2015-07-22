package com.metaco.client.contracts;

public class InputsToSign {
    private Integer index;
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
