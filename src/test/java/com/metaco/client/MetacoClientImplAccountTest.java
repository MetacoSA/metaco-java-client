package com.metaco.client;

import com.metaco.client.contracts.AccountRegistrationResult;
import com.metaco.client.contracts.AccountStatus;
import com.metaco.client.contracts.RegisterAccountRequest;
import com.metaco.client.contracts.ValidateAccountRequest;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.exceptions.MetacoErrorsDefinitions;
import helpers.TestUtils;
import junit.framework.Assert;
import org.junit.Test;

public class MetacoClientImplAccountTest {

    @Test
    public void clientCantRegisterAndValidateAccount() {
        try {
            MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

            RegisterAccountRequest registerAccountRequest = new RegisterAccountRequest();
            registerAccountRequest.setPhone("");

            AccountRegistrationResult result = client.RegisterAccount(registerAccountRequest);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.SmsSendingFailed);
        }
    }
    @Test
    public void clientCantValidateAccountAfterValidation() {
        try {
            MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder()
                    .makeClient();

            ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest();
            validateAccountRequest.setCode("RandomCode");

            client.ConfirmPhoneNumber(validateAccountRequest);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }

    //TODO: We need an update of the API to support this call in testing
    //@Test
    public void clientCanRegisterAndValidateAccount() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        RegisterAccountRequest registerAccountRequest = new RegisterAccountRequest();
        registerAccountRequest.setPhone("+00000000000");

        AccountRegistrationResult result = client.RegisterAccount(registerAccountRequest);
        Assert.assertNotNull(result.getApiId());

        client = TestUtils.GetMetacoAnonymousClientTestBuilder()
                .withApiId(result.getApiId())
                .withApiKey(result.getApiKey())
                .makeClient();

        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest();
        validateAccountRequest.setCode("TODO: The code");

        client.ConfirmPhoneNumber(validateAccountRequest);
    }

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
