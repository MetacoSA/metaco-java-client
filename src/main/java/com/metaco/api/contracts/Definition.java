package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Definition {

    @SerializedName("ticker")
    private String ticker;
    @SerializedName("display")
    private String display;
    @SerializedName("contract")
    private String contract;
    @SerializedName("keywords")
    private String keywords;
    @SerializedName("unit")
    private String unit;
    @SerializedName("divisibility")
    private Integer divisibility;
    @SerializedName("asset_id")
    private String assetId;
    @SerializedName("issuer")
    private Issuer issuer;
    @SerializedName("kyc")
    private Kyc kyc;

    public Definition() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getDivisibility() {
        return divisibility;
    }

    public void setDivisibility(Integer divisibility) {
        this.divisibility = divisibility;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Kyc getKyc() {
        return kyc;
    }

    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }
}