package com.metaco.api.contracts;

public class Transaction {
    private Integer created;
    private String ticker;
    private String type;
    private Integer confirmations;
    private Integer amount_asset;
    private Integer amount_satoshi;
    private String tx_hash;
    private Integer feePaid;
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

    public Integer getAmount_asset() {
        return amount_asset;
    }

    public void setAmount_asset(Integer amount_asset) {
        this.amount_asset = amount_asset;
    }

    public Integer getAmount_satoshi() {
        return amount_satoshi;
    }

    public void setAmount_satoshi(Integer amount_satoshi) {
        this.amount_satoshi = amount_satoshi;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public Integer getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(Integer feePaid) {
        this.feePaid = feePaid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
