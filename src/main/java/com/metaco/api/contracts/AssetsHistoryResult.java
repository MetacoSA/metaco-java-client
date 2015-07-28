package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class AssetsHistoryResult {
    @SerializedName("timestamp")
    private Integer timestamp;
    @SerializedName("assets")
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