package com.metaco.client.contracts;

import java.util.ArrayList;
import java.util.List;

public class AssetHistory {
    private String ticker;
    private List<AssetHistoryPoint> history = new ArrayList<AssetHistoryPoint>();

    public AssetHistory() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<AssetHistoryPoint> getHistory() {
        return history;
    }

    public void setHistory(List<AssetHistoryPoint> history) {
        this.history = history;
    }
}