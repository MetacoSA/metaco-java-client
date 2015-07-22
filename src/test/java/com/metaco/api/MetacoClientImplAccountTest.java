package com.metaco.api;

import com.metaco.api.contracts.AccountRegistrationResult;
import com.metaco.api.contracts.AccountStatus;
import com.metaco.api.contracts.RegisterAccountRequest;
import com.metaco.api.contracts.ValidateAccountRequest;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.exceptions.MetacoErrorsDefinitions;
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

            AccountRegistrationResult result = client.registerAccount(registerAccountRequest);
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

            client.confirmPhoneNumber(validateAccountRequest);
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

        AccountRegistrationResult result = client.registerAccount(registerAccountRequest);
        Assert.assertNotNull(result.getApiId());

        client = TestUtils.GetMetacoAnonymousClientTestBuilder()
                .withApiId(result.getApiId())
                .withApiKey(result.getApiKey())
                .makeClient();

        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest();
        validateAccountRequest.setCode("TODO: The code");

        client.confirmPhoneNumber(validateAccountRequest);
    }

    @Test
    public void clientCantGetAccountStatus() {
        try {
            MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

            AccountStatus status = client.getAccountStatus();
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }

    @Test
    public void clientCanGetAccountStatus() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAuthenticatedClientTestBuilder().makeClient();

        AccountStatus status = client.getAccountStatus();

        Assert.assertNotNull(status.getApiId());
    }
}
