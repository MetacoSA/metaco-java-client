package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class AccountStatus {
    @SerializedName("apiId")
    private String apiId;
    @SerializedName("KYC1")
    private Boolean Kyc1;
    @SerializedName("KYC2")
    private Boolean Kyc2;
    @SerializedName("max_yearly_chf_order")
    public MaxYearlyChfOrder maxYearlyChfOrder;
    @SerializedName("max_order_chf_value")
    private Long maxOrderChfValue;

    public AccountStatus() {
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public Boolean getKyc1() {
        return Kyc1;
    }

    public void setKyc1(Boolean kyc1) {
        this.Kyc1 = kyc1;
    }

    public Boolean getKyc2() {
        return Kyc2;
    }

    public void setKyc2(Boolean kyc2) {
        this.Kyc2 = kyc2;
    }

    public Long getMaxOrderChfValue() {
        return maxOrderChfValue;
    }

    public void setMaxOrderChfValue(Long maxOrderChfValue) {
        this.maxOrderChfValue = maxOrderChfValue;
    }

    public MaxYearlyChfOrder getMaxYearlyChfOrder() {
        return maxYearlyChfOrder;
    }

    public void setMaxYearlyChfOrder(MaxYearlyChfOrder maxYearlyChfOrder) {
        this.maxYearlyChfOrder = maxYearlyChfOrder;
    }
}