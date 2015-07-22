package com.metaco.api.contracts;

public class InputsToSign {
    private Integer index;
    private String signing_address;

    public InputsToSign() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSigning_address() {
        return signing_address;
    }

    public void setSigning_address(String signing_address) {
        this.signing_address = signing_address;
    }
}
