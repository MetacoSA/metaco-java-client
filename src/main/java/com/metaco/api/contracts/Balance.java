package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Balance {
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("amount")
    private Long amount;
    @SerializedName("value")
    private Long value;

    public Balance() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
