package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class NewTransaction {
    @SerializedName("from")
    private String from;
    @SerializedName("to")
    private String to;
    @SerializedName("change")
    private String change;
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("amount_asset")
    private Integer amountAsset;
    @SerializedName("amount_satoshi")
    private Integer amountSatoshi;
    @SerializedName("feePerKB")
    private BigDecimal feePerKB;

    public NewTransaction() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Integer amountAsset) {
        this.amountAsset = amountAsset;
    }

    public Integer getAmountSatoshi() {
        return amountSatoshi;
    }

    public void setAmountSatoshi(Integer amountSatoshi) {
        this.amountSatoshi = amountSatoshi;
    }

    public BigDecimal getFeePerKB() {
        return feePerKB;
    }

    public void setFeePerKB(BigDecimal feePerKB) {
        this.feePerKB = feePerKB;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
