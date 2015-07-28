package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class HistoryCriteria {
    @SerializedName("from")
    public Integer from;
    @SerializedName("to")
    private Integer to;
    @SerializedName("freq")
    private String freq;
    @SerializedName("orderAsc")
    private Boolean orderAsc;

    public HistoryCriteria(Integer from, Integer to, String freq, Boolean orderAsc) {
        this.from = from;
        this.to = to;
        this.freq = freq;
        this.orderAsc = orderAsc;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public Boolean getOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(Boolean orderAsc) {
        this.orderAsc = orderAsc;
    }
}
