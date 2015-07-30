package com.metaco.api.exceptions;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.header.InBoundHeaders;
import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class MetacoErrorResultTest {
    @Test
    public void testGetterSetters() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MetacoErrorResult errorResult = new MetacoErrorResult();
        errorResult.setStatus(200);
        errorResult.setMetaco_error("error");
        Assert.assertEquals(errorResult.getMetaco_error(), "error");
        errorResult.setLocation("location");
        Assert.assertEquals(errorResult.getLocation(), "location");
        errorResult.setMessage("message");
        Assert.assertEquals(errorResult.getMessage(), "message");
        errorResult.setParameter_name("parameter");
        Assert.assertEquals(errorResult.getParameter_name(), "parameter");
    }
}
