package com.metaco.client;

import com.metaco.client.entity.Asset;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.HistoryCriteria;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplAssetsTest {
    @Test
    public void clientCanGetAssets() {
        MetacoClient client = new MetacoClientBuilder()
                .withApiUrl("http://***REMOVED***/v1/")
                .withTestingMode(true)
                .makeClient();

        Asset[] assets = client.GetAssets();
        Assert.assertNotNull(assets);
        Assert.assertTrue(assets.length > 0);
    }

    @Test
    public void clientCanGetAsset() {
        MetacoClient client = new MetacoClientBuilder()
                .withApiUrl("http://***REMOVED***/v1/")
                .withTestingMode(true)
                .makeClient();

        Asset asset = client.GetAsset("DKY:USD");
        Assert.assertNotNull(asset);
        Assert.assertEquals(asset.getDefinition().getTicker(), "DKY:USD");
    }

    @Test
    public void clientCanGetAssetsHistory() {
        MetacoClient client = new MetacoClientBuilder()
                .withApiUrl("http://***REMOVED***/v1/")
                .withTestingMode(true)
                .makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        AssetsHistoryResult historyResult = client.GetAssetsHistory(criteria);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }

    @Test
    public void clientCanGetAssetHistory() {
        MetacoClient client = new MetacoClientBuilder()
                .withApiUrl("http://***REMOVED***/v1/")
                .withTestingMode(true)
                .makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        AssetsHistoryResult historyResult = client.GetAssetHistory("DKY:USD", criteria);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }
}
