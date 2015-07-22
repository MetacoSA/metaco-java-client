package com.metaco.client;

import com.metaco.client.entity.Asset;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.exceptions.MetacoClientException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplAssetsTest {
    @Test
    public void clientCanGetAssets() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoClientTestBuilder().makeClient();

        Asset[] assets = client.GetAssets();
        Assert.assertNotNull(assets);
        Assert.assertTrue(assets.length > 0);
    }

    @Test
    public void clientCanGetAsset() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoClientTestBuilder().makeClient();

        Asset asset = client.GetAsset("DKY:USD");
        Assert.assertNotNull(asset);
        Assert.assertEquals(asset.getDefinition().getTicker(), "DKY:USD");
    }

    @Test
    public void clientCanGetAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoClientTestBuilder().makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        AssetsHistoryResult historyResult = client.GetAssetsHistory(criteria);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }

    @Test
    public void clientCanGetSpecificAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoClientTestBuilder().makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        List<String> tickers = new ArrayList<String>();
        tickers.add("USD");
        tickers.add("XAU");

        AssetsHistoryResult historyResult = client.GetAssetsHistory(criteria, tickers);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }
}
