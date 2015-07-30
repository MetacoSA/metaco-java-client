package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplTransactionsTest {
    @Test
    public void clientCanProcessAssetTransaction() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewTransaction newTransaction = new NewTransaction();
        newTransaction.setTicker("MTC:USD");
        newTransaction.setAmountAsset(1);
        newTransaction.setFrom(TestUtils.GetBitcoinAddress());
        newTransaction.setTo(TestUtils.GetBitcoinAddress());
        newTransaction.setChange(TestUtils.GetBitcoinAddress());
        newTransaction.setFeePerKB(BigDecimal.valueOf(12345));
        TransactionToSign created;

        created = client.createTransaction(newTransaction);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getRaw());
        Assert.assertEquals(created.getInputsToSign().get(0).getSigningAddress(), TestUtils.GetBitcoinAddress());

        RawTransaction rawTx = new RawTransaction();

        rawTx.setRaw(TestUtils.GetHexSignedTransaction(created));

        TransactionBroadcastResult result = client.broadcastTransaction(rawTx);

        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void clientCanProcessBtcTransaction() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewTransaction newTransaction = new NewTransaction();
        newTransaction.setTicker("XBT");
        newTransaction.setAmountSatoshi(100000);
        newTransaction.setFrom(TestUtils.GetBitcoinAddress());
        newTransaction.setTo(TestUtils.GetBitcoinAddress());
        newTransaction.setChange(TestUtils.GetBitcoinAddress());
        newTransaction.setFeePerKB(BigDecimal.valueOf(12345));
        TransactionToSign created;

        created = client.createTransaction(newTransaction);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getRaw());
        Assert.assertEquals(created.getInputsToSign().get(0).getSigningAddress(), TestUtils.GetBitcoinAddress());

        RawTransaction rawTx = new RawTransaction();

        rawTx.setRaw(TestUtils.GetHexSignedTransaction(created));

        TransactionBroadcastResult result = client.broadcastTransaction(rawTx);

        Assert.assertTrue(result.isSuccess());
    }


    @Test
    public void clientCantBroadcastTransaction() {
        try {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            RawTransaction raw = new RawTransaction();
            raw.setRaw("fakerawtx");

            client.broadcastTransaction(raw);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.InvalidInput);
        }
    }

    @Test
    public void clientCanGetWalletDetails() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        WalletDetails walletDetails = client.getWalletDetails(TestUtils.GetBitcoinAddress());
        Assert.assertNotNull(walletDetails);
        Assert.assertEquals(walletDetails.getAddresses().get(0), TestUtils.GetBitcoinAddress());
    }
}
