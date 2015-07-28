package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransactionToSign {
    @SerializedName("raw")
    private String raw;
    @SerializedName("inputs_to_sign")
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
