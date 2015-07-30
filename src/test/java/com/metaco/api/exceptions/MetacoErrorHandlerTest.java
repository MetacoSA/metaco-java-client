package com.metaco.api.exceptions;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.header.InBoundHeaders;
import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class MetacoErrorHandlerTest {
    @Test
    public void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = ErrorHandler.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor is not private", Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test(expected = MetacoClientException.class)
    public void expectException() throws MetacoClientException {
        ClientResponse response = new ClientResponse(400, new InBoundHeaders(), new ByteArrayInputStream("response".getBytes()), null);
        ErrorHandler.HandleInvalidResponse(response);
    }

    @Test
    public void doesNotExpectException() throws MetacoClientException {
        ClientResponse response = new ClientResponse(200, null, new ByteArrayInputStream("response".getBytes()), null);
        ErrorHandler.HandleInvalidResponse(response);
    }
}
