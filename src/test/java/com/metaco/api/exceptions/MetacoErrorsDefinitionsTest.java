package com.metaco.api.exceptions;

import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class MetacoErrorsDefinitionsTest {

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = MetacoErrorsDefinitions.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor is not private", Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void errorEnumTest() {
        Assert.assertEquals(MetacoErrorsDefinitions.ErrorType.InvalidInput.getParameterName(), "invalid_input");
        Assert.assertEquals(MetacoErrorsDefinitions.ErrorType.fromString("api_calls_quota_exceeded"), MetacoErrorsDefinitions.ErrorType.APICallsQuotaExceeded);
        Assert.assertEquals(MetacoErrorsDefinitions.ErrorType.fromString("error_does_not_exist"), null);
    }

    @Test
    public void shouldReturnTheCorrectError() {
        MetacoErrorResult result = new MetacoErrorResult();

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(null), MetacoErrorsDefinitions.ErrorType.UnknownError);

        result.setStatus(404);

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(result), MetacoErrorsDefinitions.ErrorType.NotFound);

        result.setStatus(401);

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(result), MetacoErrorsDefinitions.ErrorType.Unauthorized);

        result.setStatus(500);

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(result), MetacoErrorsDefinitions.ErrorType.ServerError);

        result.setStatus(800);

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(result), MetacoErrorsDefinitions.ErrorType.UnknownError);

        result.setMetaco_error("not_enough_funds");

        Assert.assertEquals(MetacoErrorsDefinitions.GetErrorType(result), MetacoErrorsDefinitions.ErrorType.NotEnoughFunds);


    }
}
