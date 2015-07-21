package com.metaco.client.entity;

import java.math.BigDecimal;

public class AccountStatus {
    private String apiId;
    private Boolean KYC1;
    private Boolean KYC2;
    private BigDecimal remaining;

    public AccountStatus() {
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public Boolean getKYC1() {
        return KYC1;
    }

    public void setKYC1(Boolean KYC1) {
        this.KYC1 = KYC1;
    }

    public Boolean getKYC2() {
        return KYC2;
    }

    public void setKYC2(Boolean KYC2) {
        this.KYC2 = KYC2;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }
}