package com.metaco.api.contracts;

import java.math.BigDecimal;

public class AccountStatus {
    private String apiId;
    private Boolean KYC1;
    private Boolean KYC2;
    public MaxYearlyChfOrder max_yearly_chf_order;
    private BigDecimal max_order_chf_value;

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

    public BigDecimal getMax_order_chf_value() {
        return max_order_chf_value;
    }

    public void setMax_order_chf_value(BigDecimal max_order_chf_value) {
        this.max_order_chf_value = max_order_chf_value;
    }

    public MaxYearlyChfOrder getMax_yearly_chf_order() {
        return max_yearly_chf_order;
    }

    public void setMax_yearly_chf_order(MaxYearlyChfOrder max_yearly_chf_order) {
        this.max_yearly_chf_order = max_yearly_chf_order;
    }
}