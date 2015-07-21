package com.metaco.client.entity;

public class Market {

    private Double bid;
    private Double ask;
    private Double volumeDaily;
    private Double yieldDaily;
    private Double yieldYTD;
    private Double volatilityDaily;
    private Integer issued;

    public Market() {
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getVolumeDaily() {
        return volumeDaily;
    }

    public void setVolumeDaily(Double volumeDaily) {
        this.volumeDaily = volumeDaily;
    }

    public Double getYieldDaily() {
        return yieldDaily;
    }

    public void setYieldDaily(Double yieldDaily) {
        this.yieldDaily = yieldDaily;
    }

    public Double getYieldYTD() {
        return yieldYTD;
    }

    public void setYieldYTD(Double yieldYTD) {
        this.yieldYTD = yieldYTD;
    }

    public Double getVolatilityDaily() {
        return volatilityDaily;
    }

    public void setVolatilityDaily(Double volatilityDaily) {
        this.volatilityDaily = volatilityDaily;
    }

    public Integer getIssued() {
        return issued;
    }

    public void setIssued(Integer issued) {
        this.issued = issued;
    }
}
