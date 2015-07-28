package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Transaction {
    @SerializedName("created")
    private Integer created;
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("type")
    private String type;
    @SerializedName("confirmations")
    private Integer confirmations;
    @SerializedName("amount_asset")
    private Long amountAsset;
    @SerializedName("amount_satoshi")
    private Long amountSatoshi;
    @SerializedName("tx_hash")
    private String tx_hash;
    @SerializedName("feePaid")
    private Long feePaid;
    @SerializedName("order")
    private Order order;

    public Transaction() {
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Long getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Long amountAsset) {
        this.amountAsset = amountAsset;
    }

    public Long getAmountSatoshi() {
        return amountSatoshi;
    }

    public void setAmountSatoshi(Long amountSatoshi) {
        this.amountSatoshi = amountSatoshi;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public Long getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(Long feePaid) {
        this.feePaid = feePaid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
