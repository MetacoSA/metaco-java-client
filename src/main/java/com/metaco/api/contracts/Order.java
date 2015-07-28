package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("id")
    private String id;
    @SerializedName("created")
    private Integer created;
    @SerializedName("expiration")
    private Integer expiration;
    @SerializedName("status")
    private String status;
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("type")
    private String type;
    @SerializedName("amount_satoshi")
    private Long amountSatoshi;
    @SerializedName("amount_asset")
    private Long amountAsset;
    @SerializedName("user_has_signed")
    private Boolean userHasSigned;
    @SerializedName("transaction")
    private TransactionToSign transaction;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getAmountSatoshi() {
        return amountSatoshi;
    }

    public void setAmountSatoshi(Long amountSatoshi) {
        this.amountSatoshi = amountSatoshi;
    }

    public Long getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Long amountAsset) {
        this.amountAsset = amountAsset;
    }

    public Boolean getUserHasSigned() {
        return userHasSigned;
    }

    public void setUserHasSigned(Boolean userHasSigned) {
        this.userHasSigned = userHasSigned;
    }

    public TransactionToSign getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionToSign transaction) {
        this.transaction = transaction;
    }
}

