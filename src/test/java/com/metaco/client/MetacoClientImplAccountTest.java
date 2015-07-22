package com.metaco.client;

import com.metaco.client.contracts.AccountStatus;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplAccountTest {
    /*@Test
    public void clientCanRegisterAndValidateAccount() {
        try {
            MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

            RegisterAccountRequest request = new RegisterAccountRequest();
            request.setPhone("+00000000000");

            AccountRegistrationResult result = client.RegisterAccount(request);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }*/

    @Test
    public void clientCantGetAccountStatus() {
        try {
            MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

            AccountStatus status = client.GetAccountStatus();
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }

    @Test
    public void clientCanGetAccountStatus() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        AccountStatus status = client.GetAccountStatus();

        Assert.assertNotNull(status.getApiId());
    }
}
