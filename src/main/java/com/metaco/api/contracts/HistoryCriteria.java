package com.metaco.api.contracts;

public class HistoryCriteria {
    public long from;
    private long to;
    private String freq;
    private Boolean orderAsc;

    public HistoryCriteria(long from, long to, String freq, Boolean orderAsc) {
        this.from = from;
        this.to = to;
        this.freq = freq;
        this.orderAsc = orderAsc;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
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
