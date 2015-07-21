package com.metaco.client;

import org.junit.Assert;
import org.junit.Test;

public class MetacoClientBuilderTest {
    @Test
    public void builderMakesMetacoClient() {
        MetacoClient client = new MetacoClientBuilder().makeClient();

        Assert.assertNotNull(client);
    }
}
