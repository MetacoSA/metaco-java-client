package com.metaco.client;

import com.metaco.client.contracts.Order;
import com.metaco.client.exceptions.MetacoClientException;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplOrdersTest {
    @Test
    public void clientCanGetOrders() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        Order[] orders = client.GetOrders();
        Assert.assertNotNull(orders);
        Assert.assertTrue(orders.length > 0);
    }

    @Test
    public void clientCanGetOrder() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        Order order = client.GetOrder("5a106504-9650-4b8a-b975-c5fce6c1f0b9");
        Assert.assertNotNull(order);
        Assert.assertEquals(order.getId(), "5a106504-9650-4b8a-b975-c5fce6c1f0b9");
    }
}
