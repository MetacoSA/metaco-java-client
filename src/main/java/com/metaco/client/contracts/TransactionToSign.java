package com.metaco.client.contracts;

import java.util.ArrayList;
import java.util.List;

public class TransactionToSign {
    private String raw;
    private List<InputsToSign> inputs_to_sign = new ArrayList<InputsToSign>();

    public TransactionToSign() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public List<InputsToSign> getInputs_to_sign() {
        return inputs_to_sign;
    }

    public void setInputs_to_sign(List<InputsToSign> inputs_to_sign) {
        this.inputs_to_sign = inputs_to_sign;
    }
}
