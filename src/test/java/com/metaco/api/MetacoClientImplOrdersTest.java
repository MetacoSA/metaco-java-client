package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplOrdersTest {

    @Test
    public void clientCanProcessOrder() throws MetacoClientException, InterruptedException {
        try {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            NewOrder newOrder = new NewOrder();
            newOrder.setAmountAsset(1L);
            newOrder.setChange("");
            List<String> funding = new ArrayList<String>();
            funding.add(TestUtils.GetBitcoinAddress());
            newOrder.setFunding(funding);
            newOrder.setRecipient(TestUtils.GetBitcoinAddress());
            newOrder.setTicker("MTC:USD");
            newOrder.setType("bid");

            Order created = client.createOrder(newOrder);
            Assert.assertNotNull(created);
            Assert.assertNotNull(created.getAmountAsset());
            Assert.assertEquals((long)created.getAmountAsset(), 1L);

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

            Assert.assertEquals(1, (long)unconfirmed.getAmountAsset());

            /** Fetch all the orders **/

            OrderResultPage orders = client.getOrders();
            Assert.assertEquals(created.getId(), orders.getOrders()[0].getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clientCanCancelOrder() throws MetacoClientException, InterruptedException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewOrder newOrder = new NewOrder();
        newOrder.setAmountAsset(1L);
        newOrder.setChange("");
        List<String> funding = new ArrayList<String>();
        funding.add(TestUtils.GetBitcoinAddress());
        newOrder.setFunding(funding);
        newOrder.setRecipient(TestUtils.GetBitcoinAddress());
        newOrder.setTicker("MTC:USD");
        newOrder.setType("bid");

        Order created = client.createOrder(newOrder);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getAmountAsset());
        Assert.assertEquals((long)created.getAmountAsset(), 1);

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
