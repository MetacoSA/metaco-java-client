package com.metaco.client;

import com.metaco.client.contracts.NewOrder;
import com.metaco.client.contracts.Order;
import com.metaco.client.contracts.RawTransaction;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplOrdersTest {
    @Test
    public void clientCanGetOrders() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        Order[] orders = client.getOrders();
        Assert.assertNotNull(orders);
        Assert.assertTrue(orders.length > 0);
    }

    @Test
    public void clientCanGetOrder() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        Order order = client.getOrder("5a106504-9650-4b8a-b975-c5fce6c1f0b9");
        Assert.assertNotNull(order);
        Assert.assertEquals(order.getId(), "5a106504-9650-4b8a-b975-c5fce6c1f0b9");
    }

    @Test
    public void clientCantCancelOrder() throws MetacoClientException {
        try {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            client.cancelOrder("5b106584-9670-4b8a-b975-c5fce6c1f0b1");
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.OrderNotFound);
        }
    }

    @Test
    public void clientCanCreateOrder() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewOrder newOrder = new NewOrder();
        newOrder.setAmount_asset(1);
        newOrder.setChange("16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");
        List<String> funding = new ArrayList<String>();
        funding.add("16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");
        newOrder.setFunding(funding);
        newOrder.setRecipient("16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");
        newOrder.setTicker("DKY:USD");
        newOrder.setType("bid");

        Order created = client.createOrder(newOrder);

        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getAmount_asset());
        Assert.assertEquals((int) created.getAmount_asset(), 1);
    }

    @Test
    public void clientCantSubmitSignedOrder() throws MetacoClientException {
        try {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            RawTransaction rawTx = new RawTransaction();
            rawTx.setRaw("fakerawtx");

            client.submitSignedOrder("5a106504-9650-4b8a-b975-c5fce6c1f0b9", rawTx);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.InvalidInput);
        }
    }
}
