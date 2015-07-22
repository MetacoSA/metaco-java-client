package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MetacoClientImplTransactionsTest {
    @Test
    public void clientCanCreateTransaction() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        NewTransaction newTransaction = new NewTransaction();
        newTransaction.setTicker("DKY:USD");
        newTransaction.setAmount_asset(10);
        newTransaction.setFrom("akGDsn4LYKKrMKWczpWGSkR826MgcHgvBTR");
        newTransaction.setTo("akGH9z9R9w6uKBV6PmhWMsaUhiGUnrQZhJg");
        TransactionToSign created;
        created = client.createTransaction(newTransaction);
        Assert.assertNotNull(created);
        Assert.assertNotNull(created.getRaw());
        Assert.assertEquals(created.getInputs_to_sign().get(0).getSigning_address(), "16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");
    }

    @Test public void clientCantBroadcastTransaction() {
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

    @Test public void clientCanGetWalletDetails() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                .makeClient();

        List<String> addresses = new ArrayList<String>();
        addresses.add("16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");

        WalletDetails walletDetails = client.getWalletDetails(addresses);
        Assert.assertNotNull(walletDetails);
        Assert.assertEquals(walletDetails.getAddresses().get(0), "16FzXtXCqqxfTGTdmtAG6ZDSkkWSCjXcQM");
    }
}
