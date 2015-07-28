package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Market {

    @SerializedName("bid")
    private BigDecimal bid;
    @SerializedName("ask")
    private BigDecimal ask;
    @SerializedName("volume_daily")
    private BigDecimal volumeDaily;
    @SerializedName("yield_daily")
    private BigDecimal yieldDaily;
    @SerializedName("yield_YTD")
    private BigDecimal yieldYTD;
    @SerializedName("volatility_daily")
    private BigDecimal volatilityDaily;
    @SerializedName("issued")
    private Double issued;

    public Market() {
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getVolumeDaily() {
        return volumeDaily;
    }

    public void setVolumeDaily(BigDecimal volumeDaily) {
        this.volumeDaily = volumeDaily;
    }

    public BigDecimal getYieldDaily() {
        return yieldDaily;
    }

    public void setYieldDaily(BigDecimal yieldDaily) {
        this.yieldDaily = yieldDaily;
    }

    public BigDecimal getYieldYTD() {
        return yieldYTD;
    }

    public void setYieldYTD(BigDecimal yieldYTD) {
        this.yieldYTD = yieldYTD;
    }

    public BigDecimal getVolatilityDaily() {
        return volatilityDaily;
    }

    public void setVolatilityDaily(BigDecimal volatilityDaily) {
        this.volatilityDaily = volatilityDaily;
    }

    public Double getIssued() {
        return issued;
    }

    public void setIssued(Double issued) {
        this.issued = issued;
    }
}
