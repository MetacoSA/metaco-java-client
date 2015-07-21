package com.metaco.client;

import com.metaco.client.entity.Asset;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplAccountTest {
    @Test
    public void clientCanGetAssets() {
        MetacoClient client = new MetacoClientBuilder()
                .withTestingMode(true)
                .makeClient();

        Asset[] assets = client.GetAssets();
        Assert.assertNotNull(assets);
    }
}
