package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AssetHistory {
    @SerializedName("underlying")
    private String underlying;
    @SerializedName("quotes")
    private List<Float> quotes = new ArrayList<Float>();
    @SerializedName("times")
    private List<Integer> times = new ArrayList<Integer>();
    @SerializedName("volumes")
    private List<Float> volumes = new ArrayList<Float>();

    public AssetHistory() {
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public List<Float> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Float> quotes) {
        this.quotes = quotes;
    }

    public List<Integer> getTimes() {
        return times;
    }

    public void setTimes(List<Integer> times) {
        this.times = times;
    }

    public List<Float> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Float> volumes) {
        this.volumes = volumes;
    }
}