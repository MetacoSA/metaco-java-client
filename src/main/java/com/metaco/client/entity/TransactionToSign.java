package com.metaco.client.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionToSign {
    private String raw;
    private List<InputsToSign> inputsToSign = new ArrayList<InputsToSign>();

    public TransactionToSign() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public List<InputsToSign> getInputsToSign() {
        return inputsToSign;
    }

    public void setInputsToSign(List<InputsToSign> inputsToSign) {
        this.inputsToSign = inputsToSign;
    }
}
