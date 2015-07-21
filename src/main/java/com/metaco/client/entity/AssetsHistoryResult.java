package com.metaco.client.entity;

import com.metaco.client.entity.AssetHistory;

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