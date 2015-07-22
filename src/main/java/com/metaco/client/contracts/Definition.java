package com.metaco.client.contracts;

public class Definition {

    private String ticker;
    private Object display;
    private String contract;
    private String keywords;
    private String unit;
    private Integer divisibility;
    private String assetId;
    private Issuer issuer;
    private Kyc kyc;

    public Definition() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Object getDisplay() {
        return display;
    }

    public void setDisplay(Object display) {
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