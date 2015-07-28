package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Asset {
    @SerializedName("definition")
    private Definition definition;
    @SerializedName("underlying")
    private String underlying;
    @SerializedName("market")
    private Market market;

    public Asset() {
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }
}

