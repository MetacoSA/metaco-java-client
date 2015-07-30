package com.metaco.api;

import com.metaco.api.contracts.Asset;
import com.metaco.api.contracts.AssetsHistoryResult;
import com.metaco.api.contracts.HistoryCriteria;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
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
    public void clientCantGetFalseAsset() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();
        try {
            Asset asset = client.getAsset("FAKE:ASSET");
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.InvalidInput);
            Assert.assertEquals(e.getContent(), "{\r\n  \"status\": 404,\r\n  \"metaco_error\": \"invalid_input\",\r\n  \"parameter_name\": \"tickedId\",\r\n  \"message\": \"Ticker not found\"\r\n}");
            Assert.assertEquals(e.getMetacoError().getMessage(), "Ticker not found");
            Assert.assertEquals(e.getStatusCode(), 404);
            Assert.assertEquals(e.getMetacoError().getLocation(), null);
            Assert.assertEquals(e.getMetacoError().getParameter_name(), "tickerId");
        }
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
