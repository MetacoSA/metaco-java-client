package com.metaco.client.entity;

public class Asset {
    private Definition definition;
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
}

