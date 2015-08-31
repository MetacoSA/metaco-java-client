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
    public void clientCanRegisterAndValidateAccount() throws MetacoClientException {
        MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

        /** Account registration **/
        RegisterAccountRequest registerAccountRequest = new RegisterAccountRequest();
        registerAccountRequest.setPhone("+15005550006");
        registerAccountRequest.setProviderId("TestsProvider");

        AccountRegistrationResult result = client.registerAccount(registerAccountRequest);
        Assert.assertNotNull(result.getApiId());

        String validationCode = client.getLatestDebugData();

        /** Account Validation **/
        client = TestUtils.GetMetacoAnonymousClientTestBuilder()
                .withApiId(result.getApiId())
                .withApiKey(result.getApiKey())
                .makeClient();

        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest();
        validateAccountRequest.setCode(validationCode);

        client.confirmPhoneNumber(validateAccountRequest);

        /** Account Check **/
        AccountStatus status = client.getAccountStatus();

        Assert.assertTrue(status.getKyc1());

        /** Can't double validate account **/
        try {
            ValidateAccountRequest doubleValidationRequest = new ValidateAccountRequest();
            validateAccountRequest.setCode(validationCode);

            client.confirmPhoneNumber(doubleValidationRequest);
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.PhoneConfirmationNotFound);
        }
    }


    @Test
    public void clientCantRegisterAccount() {
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
    public void clientCantGetAccountStatus() {
        try {
            MetacoClient client = TestUtils.GetMetacoAnonymousClientTestBuilder().makeClient();

            AccountStatus status = client.getAccountStatus();
        } catch (MetacoClientException e) {
            Assert.assertEquals(e.getErrorType(), MetacoErrorsDefinitions.ErrorType.Unauthorized);
        }
    }
}
