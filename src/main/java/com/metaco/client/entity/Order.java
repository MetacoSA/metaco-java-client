package com.metaco.client.entity;

public class Order {
    private String id;
    private Integer created;
    private Integer expiration;
    private String status;
    private String ticker;
    private String type;
    private Integer amountSatoshi;
    private Integer amountAsset;
    private Boolean userHasSigned;
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

    public Integer getAmountSatoshi() {
        return amountSatoshi;
    }

    public void setAmountSatoshi(Integer amountSatoshi) {
        this.amountSatoshi = amountSatoshi;
    }

    public Integer getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Integer amountAsset) {
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

