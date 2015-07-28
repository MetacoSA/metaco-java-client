package com.metaco.api;

import com.metaco.api.contracts.NewOrder;
import com.metaco.api.contracts.Order;
import com.metaco.api.contracts.RawTransaction;
import com.metaco.api.contracts.WalletDetails;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
import com.metaco.api.http.HttpClient;
import com.sun.jersey.api.client.ClientResponse;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplOrdersTest {

    @Test
    public void clientCanProcessOrder() throws MetacoClientException, InterruptedException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewOrder newOrder = new NewOrder();
        newOrder.setAmount_asset(1);
        newOrder.setChange("");
        List<String> funding = new ArrayList<String>();
        funding.add(TestUtils.GetBitcoinAddress());
        newOrder.setFunding(funding);
        newOrder.setRecipient(TestUtils.GetBitcoinAddress());
        newOrder.setTicker("MTC:USD");
        newOrder.setType("bid");

        Order created = client.createOrder(newOrder);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getAmount_asset());
        Assert.assertEquals((int) created.getAmount_asset(), 1);

        Order orderToSign = WaitForOrderState(client, created.getId(), "Signing");
        if (orderToSign == null) {
            Assert.fail("Order took to long to go to Signing state");
        }

        /** Signing and submit **/
        RawTransaction rawTx = new RawTransaction();

        rawTx.setRaw(TestUtils.GetHexSignedTransaction(orderToSign.getTransaction()));

        client.submitSignedOrder(orderToSign.getId(), rawTx);

        /** Wait for broadcasting **/
        Order unconfirmed = WaitForOrderState(client, created.getId(), "Unconfirmed");
        if (unconfirmed == null) {
            Assert.fail("Order took to long to go to Unsigned state");
        }

        Assert.assertEquals(1, (int)unconfirmed.getAmount_asset());

        /** Fetch all the orders **/

        Order[] orders = client.getOrders();
        Assert.assertEquals(created.getId(), orders[0].getId());
    }

    @Test
    public void clientCanCancelOrder() throws MetacoClientException, InterruptedException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewOrder newOrder = new NewOrder();
        newOrder.setAmount_asset(1);
        newOrder.setChange("");
        List<String> funding = new ArrayList<String>();
        funding.add(TestUtils.GetBitcoinAddress());
        newOrder.setFunding(funding);
        newOrder.setRecipient(TestUtils.GetBitcoinAddress());
        newOrder.setTicker("MTC:USD");
        newOrder.setType("bid");

        Order created = client.createOrder(newOrder);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getAmount_asset());
        Assert.assertEquals((int) created.getAmount_asset(), 1);

        client.cancelOrder(created.getId());

        /** Wait for cancel **/
        Order canceled = WaitForOrderState(client, created.getId(), "Canceled");
        if (canceled == null) {
            Assert.fail("Order took to long to go to Canceled state");
        }

        Assert.assertEquals("Canceled", canceled.getStatus());
    }

    private Order WaitForOrderState(MetacoClient client, String orderId, String status) throws MetacoClientException, InterruptedException {
        int remainingTries = 15;
        boolean orderReady = false;
        Order order;
        do {
            Thread.sleep(2000);
            order = client.getOrder(orderId);

            if (order.getStatus().equals(status)) {
                orderReady = true;
            }

            remainingTries--;

            if (remainingTries == 0) {
                return null;
            }
        } while (!orderReady);
        return order;
    }
}
