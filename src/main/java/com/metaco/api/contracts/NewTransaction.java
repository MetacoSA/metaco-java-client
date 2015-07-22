package com.metaco.api.contracts;

import java.math.BigDecimal;

public class NewTransaction {
    private String from;
    private String to;
    private String change;
    private String ticker;
    private Integer amount_asset;
    private Integer amount_satoshi;
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
