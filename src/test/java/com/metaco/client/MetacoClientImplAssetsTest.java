package com.metaco.client;

import com.metaco.client.contracts.Asset;
import com.metaco.client.contracts.AssetsHistoryResult;
import com.metaco.client.contracts.HistoryCriteria;
import com.metaco.client.exceptions.MetacoClientException;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplAssetsTest {
    @Test
    public void clientCanGetAssets() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        Asset[] assets = client.getAssets();
        Assert.assertNotNull(assets);
        Assert.assertTrue(assets.length > 0);
    }

    @Test
    public void clientCanGetAsset() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        Asset asset = client.getAsset("DKY:USD");
        Assert.assertNotNull(asset);
        Assert.assertEquals(asset.getDefinition().getTicker(), "DKY:USD");
    }

    @Test
    public void clientCanGetAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        AssetsHistoryResult historyResult = client.getAssetsHistory(criteria);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }

    @Test
    public void clientCanGetSpecificAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        long currentTimestamp = System.currentTimeMillis() / 1000;
        long timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        List<String> tickers = new ArrayList<String>();
        tickers.add("USD");
        tickers.add("XAU");

        AssetsHistoryResult historyResult = client.getAssetsHistory(criteria, tickers);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }
}
