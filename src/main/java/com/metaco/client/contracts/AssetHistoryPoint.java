package com.metaco.client.contracts;

public class AssetHistoryPoint {
    private Integer time;
    private Double quote;
    private Double volume;

    public AssetHistoryPoint() {
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getQuote() {
        return quote;
    }

    public void setQuote(Double quote) {
        this.quote = quote;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}