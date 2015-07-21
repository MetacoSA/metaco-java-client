package com.metaco.client;

import com.metaco.client.entity.AccountStatus;
import com.metaco.client.entity.Asset;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.exceptions.MetacoErrorResult;
import com.metaco.client.exceptions.MetacoErrorsDefinitions;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplAccountTest {
    @Test
    public void clientCantGetAccountStatus() {
        try {
            MetacoClient client = new MetacoClientBuilder()
                    .withApiUrl("TEST_SERVER")
                    .withTestingMode(true)
                    .makeClient();

            AccountStatus status = client.GetAccountStatus();
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }

}
