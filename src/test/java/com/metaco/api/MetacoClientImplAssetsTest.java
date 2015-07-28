package com.metaco.api;

import com.metaco.api.contracts.Asset;
import com.metaco.api.contracts.AssetsHistoryResult;
import com.metaco.api.contracts.HistoryCriteria;
import com.metaco.api.exceptions.MetacoClientException;
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

        Asset asset = client.getAsset("MTC:USD");
        Assert.assertNotNull(asset);
        Assert.assertEquals(asset.getDefinition().getTicker(), "MTC:USD");
    }

    @Test
    public void clientCanGetAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        Integer currentTimestamp = (int)(System.currentTimeMillis() / 1000);
        Integer timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        AssetsHistoryResult historyResult = client.getAssetsHistory(criteria);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }

    @Test
    public void clientCanGetSpecificAssetsHistory() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        Integer currentTimestamp = (int)(System.currentTimeMillis() / 1000);
        Integer timestampThirtyMinutesAgo = currentTimestamp - (30 * 60);

        HistoryCriteria criteria = new HistoryCriteria(timestampThirtyMinutesAgo, currentTimestamp, "10m", false);

        List<String> tickers = new ArrayList<String>();
        tickers.add("USD");
        tickers.add("XAU");

        AssetsHistoryResult historyResult = client.getAssetsHistory(criteria, tickers);
        Assert.assertNotNull(historyResult);
        Assert.assertTrue(historyResult.getAssets().length > 0);
    }
}
