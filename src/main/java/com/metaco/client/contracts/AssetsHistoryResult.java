package com.metaco.client.contracts;

public class AssetsHistoryResult {
    private Integer timestamp;
    private AssetHistory[] assets;

    public AssetsHistoryResult() {
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public AssetHistory[] getAssets() {
        return assets;
    }

    public void setAssets(AssetHistory[] assets) {
        this.assets = assets;
    }
}