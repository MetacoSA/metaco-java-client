package com.metaco.client.entity;

public class HistoryCriteria {
    public int from;
    private int to;
    private String freq;
    private Boolean orderAsc;

    public HistoryCriteria(int from, int to, String freq, Boolean orderAsc) {
        this.from = from;
        this.to = to;
        this.freq = freq;
        this.orderAsc = orderAsc;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
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
