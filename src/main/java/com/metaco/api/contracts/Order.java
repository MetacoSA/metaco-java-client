package com.metaco.api.contracts;

public class Order {
    private String id;
    private Integer created;
    private Integer expiration;
    private String status;
    private String ticker;
    private String type;
    private Integer amount_satoshi;
    private Integer amount_asset;
    private Boolean user_has_signed;
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

    public Integer getAmount_satoshi() {
        return amount_satoshi;
    }

    public void setAmount_satoshi(Integer amount_satoshi) {
        this.amount_satoshi = amount_satoshi;
    }

    public Integer getAmount_asset() {
        return amount_asset;
    }

    public void setAmount_asset(Integer amount_asset) {
        this.amount_asset = amount_asset;
    }

    public Boolean getUser_has_signed() {
        return user_has_signed;
    }

    public void setUser_has_signed(Boolean user_has_signed) {
        this.user_has_signed = user_has_signed;
    }

    public TransactionToSign getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionToSign transaction) {
        this.transaction = transaction;
    }
}

