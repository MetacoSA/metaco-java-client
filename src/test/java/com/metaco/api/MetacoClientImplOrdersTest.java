package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplOrdersTest {

    @Test
    public void clientCanProcessOrder() throws MetacoClientException, InterruptedException {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            NewOrder newOrder = new NewOrder();
            newOrder.setAmountAsset(100L);
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
            Assert.assertEquals((long)created.getAmountAsset(), 100L);

            Order orderToSign = WaitForOrderState(client, created.getId(), "Signing");
            if (orderToSign == null) {
                Assert.fail("Order " + created.getId() + " took to long to go to Signing state");
            }

            /** Signing and submit **/
            RawTransaction rawTx = new RawTransaction();

            rawTx.setRaw(TestUtils.GetHexSignedTransaction(orderToSign.getTransaction()));

            client.submitSignedOrder(orderToSign.getId(), rawTx);

            /** Wait for broadcasting **/
            Order unconfirmed = WaitForOrderState(client, created.getId(), "Unconfirmed");
            if (unconfirmed == null) {
                Assert.fail("Order " + created.getId() + " took to long to go to Unconfirmed state");
            }

            Assert.assertEquals(100, (long)unconfirmed.getAmountAsset());

            /** Try to delete broadcasting order **/
            try {
                client.cancelOrder(unconfirmed.getId());
            } catch (MetacoClientException e) {
                Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.OrderNotCancellable);
            }


            /** Fetch all the orders **/

            OrderResultPage orders = client.getOrders();

        if (!OrderIsInList(orders, created.getId())) {
            Assert.fail("Order " + created.getId() + " is not present in orders list");
        }
    }

    private boolean OrderIsInList(OrderResultPage orders, String orderId) {
        for(Order order : orders.getOrders()) {
            if (order.getId().equals(orderId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void clientCanGetPaginatedOrders() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        PageCriteria criteria = new PageCriteria();
        criteria.setPageNumber(0);
        criteria.setPageSize(1);

        OrderResultPage orders = client.getOrders(criteria);
        Assert.assertNotNull(orders);
        Assert.assertEquals(orders.getOrders().length, 1);
    }

    @Test
    public void clientCanCancelOrder() throws MetacoClientException, InterruptedException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewOrder newOrder = new NewOrder();
        newOrder.setAmountAsset(100L);
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
        Assert.assertEquals((long)created.getAmountAsset(), 100L);

        client.cancelOrder(created.getId());

        /** Wait for cancel **/
        Order canceled = WaitForOrderState(client, created.getId(), "Canceled");
        if (canceled == null) {
            Assert.fail("Order " + created.getId() + " took to long to go to Canceled state");
        }
        Assert.assertEquals(canceled.getCancelReason(), "explicit_cancel");
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
